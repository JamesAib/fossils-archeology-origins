
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

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
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

public class DimetrodonEntity extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(DimetrodonEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(DimetrodonEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(DimetrodonEntity.class, EntityDataSerializers.STRING);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public DimetrodonEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FossilsoriginsModEntities.DIMETRODON.get(), world);
	}

	public DimetrodonEntity(EntityType<DimetrodonEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "dimetrodon");
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
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canContinueToUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}
		});
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, TyrannosaurausEntity.class, (float) 6, 1, 1.2));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, SpinosaurusEntity.class, (float) 6, 1, 1.2));
		this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, CarnotaurusEntity.class, (float) 6, 1, 1.2));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, true) {
			@Override
			public boolean canUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, DryosaurusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, CompsognathusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = DimetrodonEntity.this.getX();
				double y = DimetrodonEntity.this.getY();
				double z = DimetrodonEntity.this.getZ();
				Entity entity = DimetrodonEntity.this;
				Level world = DimetrodonEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(10, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
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
		DimetrodonEntity retval = FossilsoriginsModEntities.DIMETRODON.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.PORKCHOP).contains(stack.getItem());
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
		builder = builder.add(Attributes.MAX_HEALTH, 25);
		builder = builder.add(Attributes.ARMOR, 7);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Dimetrodon.move", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Dimetrodon.idle", EDefaultLoopTypes.LOOP));
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
			this.remove(DimetrodonEntity.RemovalReason.KILLED);
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
