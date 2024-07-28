package net.morimori0317.yajusenpai.entity;


import dev.architectury.networking.NetworkManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.jetbrains.annotations.Nullable;

public class KatyouCat extends Cat {
    private static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(YajuSenpai.MODID, "textures/entity/katyou_cat.png");

    public KatyouCat(EntityType<? extends Cat> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D).add(Attributes.ATTACK_DAMAGE, 8.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Creeper.class, false));
        this.targetSelector.addGoal(6, new ResetUniversalAngerTargetGoal(this, true));
    }

    @Override
    public ResourceLocation getTextureId() {
        return LOCATION;
    }

    @Nullable
    @Override
    public Cat getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Cat cat = YJEntityTypes.KATYOU_CAT.get().create(serverLevel);
        if (ageableMob instanceof KatyouCat) {
            if (this.isTame()) {
                cat.setOwnerUUID(this.getOwnerUUID());
                cat.setTame(true, true);
                if (this.random.nextBoolean()) {
                    cat.setCollarColor(this.getCollarColor());
                } else {
                    cat.setCollarColor(((Cat) ageableMob).getCollarColor());
                }
            }
        }
        return cat;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return YJSoundEvents.KATYOU_NYA.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return YJSoundEvents.KATYOU_BROKEN.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return YJSoundEvents.KATYOU.get();
    }

    @Override
    public void hiss() {
        this.playSound(YJSoundEvents.KATYOU.get(), this.getSoundVolume(), this.getVoicePitch());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity serverEntity) {
        return NetworkManager.createAddEntityPacket(this, serverEntity);
    }
}