
package com.praepositi.fossilsorigins.entity;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;

import java.util.List;

import com.praepositi.fossilsorigins.procedures.SettingMobParametersProcedure;
import com.praepositi.fossilsorigins.procedures.EnergyBasedHuntingProcedure;
import com.praepositi.fossilsorigins.procedures.BreedingProcedure;
import com.praepositi.fossilsorigins.procedures.AttackPlayerTranqValProcedure;
import com.praepositi.fossilsorigins.init.FossilsoriginsModEntities;

public class PlesiosuarusEntity extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(PlesiosuarusEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(PlesiosuarusEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(PlesiosuarusEntity.class, EntityDataSerializers.STRING);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public PlesiosuarusEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FossilsoriginsModEntities.PLESIOSUARUS.get(), world);
	}

	public PlesiosuarusEntity(EntityType<PlesiosuarusEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (PlesiosuarusEntity.this.isInWater())
					PlesiosuarusEntity.this.setDeltaMovement(PlesiosuarusEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !PlesiosuarusEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - PlesiosuarusEntity.this.getX();
					double dy = this.wantedY - PlesiosuarusEntity.this.getY();
					double dz = this.wantedZ - PlesiosuarusEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * PlesiosuarusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					PlesiosuarusEntity.this.setYRot(this.rotlerp(PlesiosuarusEntity.this.getYRot(), f, 10));
					PlesiosuarusEntity.this.yBodyRot = PlesiosuarusEntity.this.getYRot();
					PlesiosuarusEntity.this.yHeadRot = PlesiosuarusEntity.this.getYRot();
					if (PlesiosuarusEntity.this.isInWater()) {
						PlesiosuarusEntity.this.setSpeed((float) PlesiosuarusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						PlesiosuarusEntity.this.setXRot(this.rotlerp(PlesiosuarusEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(PlesiosuarusEntity.this.getXRot() * (float) (Math.PI / 180.0));
						PlesiosuarusEntity.this.setZza(f3 * f1);
						PlesiosuarusEntity.this.setYya((float) (f1 * dy));
					} else {
						PlesiosuarusEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					PlesiosuarusEntity.this.setSpeed(0);
					PlesiosuarusEntity.this.setYya(0);
					PlesiosuarusEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "plesiosuarus");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreedGoal(this, 21) {
			@Override
			public boolean canUse() {
				double x = PlesiosuarusEntity.this.getX();
				double y = PlesiosuarusEntity.this.getY();
				double z = PlesiosuarusEntity.this.getZ();
				Entity entity = PlesiosuarusEntity.this;
				Level world = PlesiosuarusEntity.this.level;
				return super.canUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PlesiosuarusEntity.this.getX();
				double y = PlesiosuarusEntity.this.getY();
				double z = PlesiosuarusEntity.this.getZ();
				Entity entity = PlesiosuarusEntity.this;
				Level world = PlesiosuarusEntity.this.level;
				return super.canContinueToUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}
		});
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, MosasaurusEntity.class, (float) 6, 11, 13));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, TropicalFish.class, false, true) {
			@Override
			public boolean canUse() {
				double x = PlesiosuarusEntity.this.getX();
				double y = PlesiosuarusEntity.this.getY();
				double z = PlesiosuarusEntity.this.getZ();
				Entity entity = PlesiosuarusEntity.this;
				Level world = PlesiosuarusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 21, 40));
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = PlesiosuarusEntity.this.getX();
				double y = PlesiosuarusEntity.this.getY();
				double z = PlesiosuarusEntity.this.getZ();
				Entity entity = PlesiosuarusEntity.this;
				Level world = PlesiosuarusEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PlesiosuarusEntity.this.getX();
				double y = PlesiosuarusEntity.this.getY();
				double z = PlesiosuarusEntity.this.getZ();
				Entity entity = PlesiosuarusEntity.this;
				Level world = PlesiosuarusEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		}.setAlertOthers());
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 21));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		Entity entity = this;
		Level world = this.level;
		double x = this.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return super.getDimensions(p_33597_).scale((float) SettingMobParametersProcedure.execute(entity));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		PlesiosuarusEntity retval = FossilsoriginsModEntities.PLESIOSUARUS.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.SALMON).contains(stack.getItem());
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if (this.isInWaterOrBubble()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.plesiosaurus.swim", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.plesiosaurus.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		Entity entity = this;
		Level world = entity.level;
		boolean loop = false;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (!loop && this.lastloop) {
			this.lastloop = false;
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			event.getController().clearAnimationCache();
			return PlayState.STOP;
		}
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			if (!loop) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
				if (event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
					this.animationprocedure = "empty";
					event.getController().markNeedsReload();
				}
			} else {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.LOOP));
				this.lastloop = true;
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(PlesiosuarusEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
