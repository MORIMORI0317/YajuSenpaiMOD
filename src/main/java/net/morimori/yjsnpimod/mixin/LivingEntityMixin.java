package net.morimori.yjsnpimod.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.block.YJSoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    public abstract ItemStack getItemBySlot(EquipmentSlot equipmentSlot);

    @ModifyVariable(method = "playBlockFallSound", ordinal = 0, at = @At("STORE"))
    private SoundType playBlockFallSound(SoundType soundType) {
        return soundType instanceof YJSoundType ? ((YJSoundType) soundType).getLowPitchSound() : soundType;
    }

    @ModifyVariable(method = "playHurtSound", ordinal = 0, at = @At("STORE"))
    private SoundEvent playHurtSound(SoundEvent soundEvent) {
        ItemStack stack = getItemBySlot(EquipmentSlot.HEAD);
        if (stack.getItem() instanceof BlockItem && YJBlocks.INM_BLOCKS.contains(((BlockItem) stack.getItem()).getBlock())) {
            return ((BlockItem) stack.getItem()).getBlock().getSoundType(((BlockItem) stack.getItem()).getBlock().defaultBlockState()).getHitSound();
        }
        return soundEvent;
    }

    @ModifyVariable(method = "hurt", ordinal = 0, at = @At("STORE"))
    private SoundEvent hurt(SoundEvent soundEvent) {
        ItemStack stack = getItemBySlot(EquipmentSlot.HEAD);
        if (stack.getItem() instanceof BlockItem && YJBlocks.INM_BLOCKS.contains(((BlockItem) stack.getItem()).getBlock())) {
            return ((BlockItem) stack.getItem()).getBlock().getSoundType(((BlockItem) stack.getItem()).getBlock().defaultBlockState()).getBreakSound();
        }
        return soundEvent;
    }

    @ModifyVariable(method = "handleEntityEvent", ordinal = 0, at = @At("STORE"))
    private SoundEvent handleEntityEvent(SoundEvent soundEvent) {
        ItemStack stack = getItemBySlot(EquipmentSlot.HEAD);
        if (stack.getItem() instanceof BlockItem && YJBlocks.INM_BLOCKS.contains(((BlockItem) stack.getItem()).getBlock())) {
            return ((BlockItem) stack.getItem()).getBlock().getSoundType(((BlockItem) stack.getItem()).getBlock().defaultBlockState()).getBreakSound();
        }
        return soundEvent;
    }

}
