package net.morimori0317.yajusenpai.blockentity;

import dev.architectury.networking.NetworkManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.util.YJUtils;

public class BigPillowBlockEntity extends BlockEntity {
    private LivingEntity livingEntity;

    public BigPillowBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(YJBlockEntityTypes.BIG_PILLOW.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BigPillowBlockEntity blockEntity) {
        if (!level.isClientSide()) {
            var area = new AABB(blockPos.getX() - 5, blockPos.getY(), blockPos.getZ() - 5, blockPos.getX() + 5, blockPos.getY() + 5, blockPos.getZ() + 5);

            if (blockEntity.livingEntity != null) {
                if (blockEntity.livingEntity.isAlive() && area.contains(blockEntity.livingEntity.position()) && blockPos.equals(((YJLivingEntityAccessor) blockEntity.livingEntity).yajuSenpai$getSleepingPos())) {
                    blockEntity.livingEntity.setPos(blockPos.getX() + 0.5, blockPos.getY() + blockState.getCollisionShape(level, blockPos).max(Direction.Axis.Y), blockPos.getZ() + 0.5);
                } else {
                    blockEntity.sendSleepPacket(blockEntity.livingEntity, blockPos, null);
                    ((YJLivingEntityAccessor) blockEntity.livingEntity).yajuSenpai$setSleepingPos(null);

                    blockEntity.livingEntity = null;
                }
            } else {
                var entities = level.getEntitiesOfClass(LivingEntity.class, area);
                for (LivingEntity entity : entities) {
                    if (((YJLivingEntityAccessor) entity).yajuSenpai$getSleepingPos() == null && canComa(entity)) {
                        blockEntity.livingEntity = entity;
                        ((YJLivingEntityAccessor) entity).yajuSenpai$setSleepingPos(blockPos);
                        blockEntity.sendSleepPacket(entity, blockPos, blockPos);
                        break;
                    }
                }
            }
        }
    }

    private void sendSleepPacket(LivingEntity livingEntity, BlockPos thsBlockPos, BlockPos pos) {
        if (pos != null) {
            YJUtils.doPlayers(getLevel(), thsBlockPos, p -> NetworkManager.sendToPlayer(p, new YJPackets.SleepMessage(livingEntity.getId(), pos, false)));
        } else {
            YJUtils.doPlayers(getLevel(), thsBlockPos, p -> NetworkManager.sendToPlayer(p, new YJPackets.SleepMessage(livingEntity.getId(), BlockPos.ZERO, true)));
        }
    }

    public static boolean canComa(LivingEntity livingEntity) {
        if (livingEntity instanceof Player player && player.isSpectator())
            return false;
        if (livingEntity.getMaxHealth() >= 100 && (livingEntity.getHealth() / livingEntity.getMaxHealth()) >= 0.3)
            return false;
        return livingEntity.isAlive() && ((YJLivingEntityAccessor) livingEntity).yajuSenpai$isComa();
    }
}
