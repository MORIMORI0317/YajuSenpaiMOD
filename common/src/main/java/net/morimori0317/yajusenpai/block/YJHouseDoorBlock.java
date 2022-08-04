package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YJHouseDoorBlock extends DoorBlock {
    public YJHouseDoorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        blockState = blockState.cycle(OPEN);
        level.setBlock(blockPos, blockState, 10);
        level.playSound(null, blockPos, blockState.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), SoundSource.BLOCKS, 1, 1);
        level.gameEvent(player, this.isOpen(blockState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public SoundEvent getCloseSound() {
        return YJSoundEvents.YJ_DOOR_CLOSE.get();
    }

    public SoundEvent getOpenSound() {
        return YJSoundEvents.YJ_DOOR_OPEN.get();
    }
}
