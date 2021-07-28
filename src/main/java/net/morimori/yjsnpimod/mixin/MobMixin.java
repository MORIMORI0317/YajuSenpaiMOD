package net.morimori.yjsnpimod.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.util.YJUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public class MobMixin {
    @Inject(method = "finalizeSpawn", at = @At("HEAD"), cancellable = true)
    private void finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag, CallbackInfoReturnable<SpawnGroupData> cir) {
        Mob mob = (Mob) (Object) this;

        if (!(YJUtils.isYJDim(mob.level) || YJUtils.yjRandom(mob.getRandom())))
            return;

        if (mob instanceof EnderMan enderMan) {
            enderMan.setCarriedBlock(YJBlocks.ENDERMAN_BLOCKS.get(mob.getRandom().nextInt(YJBlocks.ENDERMAN_BLOCKS.size())).defaultBlockState());
            return;
        }

        if (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin) {
            mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES));
        }
        if (mob instanceof Villager)
            mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(YJBlocks.YJSNPI_INTERVIEW_BLOCK));
    }
}
