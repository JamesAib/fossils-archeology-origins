
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

public class SpinosaurusEntity extends Animal implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SpinosaurusEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SpinosaurusEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SpinosaurusEntity.class, EntityDataSerializers.STRING);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public SpinosaurusEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FossilsoriginsModEntities.SPINOSAURUS.get(), world);
	}

	public SpinosaurusEntity(EntityType<SpinosaurusEntity> type, Level world) {
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
		this.entityData.define(TEXTURE, "spinosaurus");
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
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, TyrannosaurausEntity.class, (float) 6, 1, 1.2));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && BreedingProcedure.execute(world, x, y, z, entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, GalimimusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, OviraptorEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, DimetrodonEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, DilophosaurusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, CryolophosaurusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, AnkylosaurusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, TriceratopsEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, CarnotaurusEntity.class, false, true) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && EnergyBasedHuntingProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && EnergyBasedHuntingProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(12, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(13, new RandomStrollGoal(this, 2));
		this.targetSelector.addGoal(14, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canUse() && AttackPlayerTranqValProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SpinosaurusEntity.this.getX();
				double y = SpinosaurusEntity.this.getY();
				double z = SpinosaurusEntity.this.getZ();
				Entity entity = SpinosaurusEntity.this;
				Level world = SpinosaurusEntity.this.level;
				return super.canContinueToUse() && AttackPlayerTranqValProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(15, new RandomLookAroundGoal(this));
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
		SpinosaurusEntity retval = FossilsoriginsModEntities.SPINOSAURUS.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(Items.SALMON).contains(stack.getItem());
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
		builder = builder.add(Attributes.ARMOR, 24);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 50);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Spinosaurus.move", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Spinosaurus.idle", EDefaultLoopTypes.LOOP));
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
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.Spinosaurus.attack", EDefaultLoopTypes.PLAY_ONCE));
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
			this.remove(SpinosaurusEntity.RemovalReason.KILLED);
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
