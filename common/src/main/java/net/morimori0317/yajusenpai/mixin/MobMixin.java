package net.morimori0317.yajusenpai.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ServerLevelAccessor;
import net.morimori0317.yajusenpai.entity.YJSpawn;
import net.morimori0317.yajusenpai.item.YJItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public class MobMixin {
    @Inject(method = "finalizeSpawn", at = @At("TAIL"))
    private void finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag, CallbackInfoReturnable<SpawnGroupData> cir) {
        YJSpawn.onSpawn((Mob) (Object) this);
    }

    @Inject(method = "maybeDisableShield", at = @At("HEAD"))
    private void maybeDisableShield(Player player, ItemStack itemStack, ItemStack itemStack2, CallbackInfo ci) {
        var ths = (Mob) (Object) this;
        if (!itemStack.isEmpty() && !itemStack2.isEmpty() && itemStack.getItem() instanceof AxeItem && itemStack2.is(YJItems.JAKEN_YORUIKIMASYOU_SHIELD.get())) {
            float f = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(ths) * 0.05F;
            if (ths.getRandom().nextFloat() < f) {
                player.getCooldowns().addCooldown(YJItems.JAKEN_YORUIKIMASYOU_SHIELD.get(), 100);
                ths.level.broadcastEntityEvent(player, (byte) 30);
            }
        }
    }
}
