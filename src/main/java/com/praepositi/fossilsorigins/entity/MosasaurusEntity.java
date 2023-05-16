
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
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

public class MosasaurusEntity extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(MosasaurusEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(MosasaurusEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(MosasaurusEntity.class, EntityDataSerializers.STRING);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public MosasaurusEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FossilsoriginsModEntities.MOSASAURUS.get(), world);
	}

	public MosasaurusEntity(EntityType<MosasaurusEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (MosasaurusEntity.this.isInWater())
					MosasaurusEntity.this.setDeltaMovement(MosasaurusEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !MosasaurusEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - MosasaurusEntity.this.getX();
					double dy = this.wantedY - MosasaurusEntity.this.getY();
					double dz = this.wantedZ - MosasaurusEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * MosasaurusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					MosasaurusEntity.this.setYRot(this.rotlerp(MosasaurusEntity.this.getYRot(), f, 10));
					MosasaurusEntity.this.yBodyRot = MosasaurusEntity.this.getYRot();
					MosasaurusEntity.this.yHeadRot = MosasaurusEntity.this.getYRot();
					if (MosasaurusEntity.this.isInWater()) {
						MosasaurusEntity.this.setSpeed((float) MosasaurusEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						MosasaurusEntity.this.setXRot(this.rotlerp(MosasaurusEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(MosasaurusEntity.this.getXRot() * (float) (Math.PI / 180.0));
						MosasaurusEntity.this.setZza(f3 * f1);
						MosasaurusEntity.this.setYya((float) (f1 * dy));
					} else {
						MosasaurusEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					MosasaurusEntity.this.setSpeed(0);
					MosasaurusEntity.this.setYya(0);
					MosasaurusEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "mosasuarus");
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
		this.goalSelector.addGoal(1, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canContinueToUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, true) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, OviraptorEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, GalimimusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlesiosuarusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 21));
		this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 21, 40));
		this.targetSelector.addGoal(8, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = MosasaurusEntity.this.getX();
				double y = MosasaurusEntity.this.getY();
				double z = MosasaurusEntity.this.getZ();
				Entity entity = MosasaurusEntity.this;
				Level world = MosasaurusEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
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
		MosasaurusEntity retval = FossilsoriginsModEntities.MOSASAURUS.get().create(serverWorld);
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
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 15);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 50);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if (this.isInWaterOrBubble()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Mosasaurus.swim", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Mosasaurus.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private <E extends IAnimatable> PlayState attackingPredicate(AnimationEvent<E> event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level.getGameTime();
		}
		if (this.swinging && this.lastSwing + 15L <= level.getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Mosasaurus.attack", EDefaultLoopTypes.PLAY_ONCE));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
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
			this.remove(MosasaurusEntity.RemovalReason.KILLED);
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
		data.addAnimationController(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
