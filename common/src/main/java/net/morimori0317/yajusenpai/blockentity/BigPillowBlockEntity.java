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
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.util.YJPlayerUtils;

public class BigPillowBlockEntity extends BlockEntity {
    private LivingEntity livingEntity;

    public BigPillowBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(YJBlockEntityTypes.BIG_PILLOW.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BigPillowBlockEntity blockEntity) {
        if (!level.isClientSide()) {
            var area = new AABB(blockPos.getX() - 5, blockPos.getY(), blockPos.getZ() - 5, blockPos.getX() + 5, blockPos.getY() + 5, blockPos.getZ() + 5);
            if (blockEntity.livingEntity != null) {
                if (blockEntity.livingEntity.isAlive() && area.contains(blockEntity.livingEntity.position()) && blockPos.equals(((YJLivingEntity) blockEntity.livingEntity).getSleepingPos())) {
                    blockEntity.livingEntity.setPos(blockPos.getX() + 0.5, blockPos.getY() + blockState.getCollisionShape(level, blockPos).max(Direction.Axis.Y), blockPos.getZ() + 0.5);
                } else {
                    if (((YJLivingEntity) blockEntity.livingEntity).getSleepingPos() != null)
                        blockEntity.sendSleepPacket(blockEntity.livingEntity, blockPos, null);
                    ((YJLivingEntity) blockEntity.livingEntity).setSleepingPos(null);

                    blockEntity.livingEntity = null;
                }
            } else {
                var entities = level.getEntitiesOfClass(LivingEntity.class, area);
                for (LivingEntity entity : entities) {
                    if (((YJLivingEntity) entity).getSleepingPos() == null && canComa(entity)) {
                        blockEntity.livingEntity = entity;
                        ((YJLivingEntity) entity).setSleepingPos(blockPos);
                        blockEntity.sendSleepPacket(entity, blockPos, blockPos);
                        break;
                    }
                }
            }
        }
    }

    private void sendSleepPacket(LivingEntity livingEntity, BlockPos thsBlockPos, BlockPos pos) {
        if (pos != null) {
            YJPlayerUtils.doPlayers(level, thsBlockPos, p -> NetworkManager.sendToPlayer(p, YJPackets.SLEEP, new YJPackets.SleepMessage(livingEntity.getId(), pos, false).toFBB()));
        } else {
            YJPlayerUtils.doPlayers(level, thsBlockPos, p -> NetworkManager.sendToPlayer(p, YJPackets.SLEEP, new YJPackets.SleepMessage(livingEntity.getId(), BlockPos.ZERO, true).toFBB()));
        }
    }

    public static boolean canComa(LivingEntity livingEntity) {
        if (livingEntity instanceof Player player && player.isSpectator())
            return false;
        if (livingEntity.getMaxHealth() >= 100 && (livingEntity.getHealth() / livingEntity.getMaxHealth()) >= 0.3)
            return false;
        return livingEntity.isAlive() && ((YJLivingEntity) livingEntity).isComa();
    }
}
