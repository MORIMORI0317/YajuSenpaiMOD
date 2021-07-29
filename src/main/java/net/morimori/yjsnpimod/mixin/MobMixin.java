package net.morimori.yjsnpimod.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.block.YJSoundType;
import net.morimori.yjsnpimod.registry.YJSpawn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobMixin {
    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot equipmentSlot);

    @Inject(method = "finalizeSpawn", at = @At("RETURN"), cancellable = true)
    private void finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag, CallbackInfoReturnable<SpawnGroupData> cir) {
        YJSpawn.onSpawn((Mob) (Object) this);
    }


    @ModifyVariable(method = "playAmbientSound", ordinal = 0, at = @At("STORE"))
    private SoundEvent playAmbientSound(SoundEvent soundEvent) {
        ItemStack stack = getItemBySlot(EquipmentSlot.HEAD);
        if (stack.getItem() instanceof BlockItem && YJBlocks.INM_BLOCKS.contains(((BlockItem) stack.getItem()).getBlock())) {
            Block block = ((BlockItem) stack.getItem()).getBlock();
            SoundType soundType = block.getSoundType(block.defaultBlockState());
            if (soundType == YJSoundType.MEZIKARA) {
                return soundType.getHitSound();
            } else {
                int num = ((Mob) (Object) this).getRandom().nextInt(4);
                switch (num) {
                    case 0:
                        return soundType.getPlaceSound();
                    case 1:
                        return soundType.getHitSound();
                    case 2:
                        return soundType.getFallSound();
                    case 3:
                        return soundType.getStepSound();
                }
            }
        }
        return soundEvent;
    }
}
