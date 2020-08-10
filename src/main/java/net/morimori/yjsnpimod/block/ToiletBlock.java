package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.entity.ToiletSitEntity;
import net.morimori.yjsnpimod.tileentity.ToiletTileEntity;
import red.felnull.otyacraftengine.util.IKSGEntityUtil;

import javax.annotation.Nullable;

public class ToiletBlock extends HorizontalBlock {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public ToiletBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(OPEN, Boolean.valueOf(false)));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(HorizontalBlock.HORIZONTAL_FACING);
        boolean open = state.get(OPEN);
        if (open) {
            switch (direction) {
                case NORTH:
                    return ToiletVoxelshape.NORTH_OPEN_AXIS_AABB;
                case SOUTH:
                    return ToiletVoxelshape.SOUTH_OPEN_AXIS_AABB;
                case EAST:
                    return ToiletVoxelshape.EAST_OPEN_AXIS_AABB;
                case WEST:
                    return ToiletVoxelshape.WEST_OPEN_AXIS_AABB;
                default:
                    return ToiletVoxelshape.NORTH_OPEN_AXIS_AABB;
            }
        } else {
            switch (direction) {
                case NORTH:
                    return ToiletVoxelshape.NORTH_CLOSE_AXIS_AABB;
                case SOUTH:
                    return ToiletVoxelshape.SOUTH_CLOSE_AXIS_AABB;
                case EAST:
                    return ToiletVoxelshape.EAST_CLOSE_AXIS_AABB;
                case WEST:
                    return ToiletVoxelshape.WEST_CLOSE_AXIS_AABB;
                default:
                    return ToiletVoxelshape.NORTH_CLOSE_AXIS_AABB;
            }
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stack = player.getHeldItem(handIn);
        if (player.isCrouching()) {
            if (state.get(OPEN)) {
                if (worldIn.getTileEntity(pos) instanceof ToiletTileEntity) {
                    ToiletTileEntity tile = (ToiletTileEntity) worldIn.getTileEntity(pos);
                    if (!tile.getBukkakeItem().isEmpty()) {
                        ItemStack bustack = tile.getBukkakeItem().copy();
                        tile.setBukkakeItem(ItemStack.EMPTY);
                        worldIn.addEntity(IKSGEntityUtil.createItemEntity(bustack, worldIn, pos.getX() + 0.5f, pos.getY() + 0.75f, pos.getZ() + 0.5f));
                        return ActionResultType.SUCCESS;
                    }
                }
            }
            state = state.func_235896_a_(OPEN);
            worldIn.setBlockState(pos, state, 2);
            this.playSound(player, worldIn, pos, state.get(OPEN));
            return ActionResultType.SUCCESS;
        } else {
            if (state.get(OPEN)) {
                if (!stack.isEmpty()) {
                    if (worldIn.getTileEntity(pos) instanceof ToiletTileEntity) {
                        ToiletTileEntity tile = (ToiletTileEntity) worldIn.getTileEntity(pos);
                        if (tile.getBukkakeItem().isEmpty()) {
                            tile.setBukkakeItem(stack.copy());
                            if (!player.isCreative()) {
                                stack.shrink(stack.getCount());
                            }
                            return ActionResultType.SUCCESS;
                        }
                    }
                } else {
                    if (player.getRidingEntity() == null) {
                        ToiletSitEntity tse = new ToiletSitEntity(worldIn);
                        tse.setPosition(pos.getX() + 0.5f, pos.getY() + 0.2f, pos.getZ() + 0.5f);
                        worldIn.addEntity(tse);
                        player.startRiding(tse);
                        if (worldIn.isRemote) {
                            player.sendStatusMessage(new TranslationTextComponent("message.toilet.untisuru", YJSNPIMOD.proxy.getMinecraft().gameSettings.keyBindJump.func_238171_j_()), false);
                        }
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            if (worldIn.getTileEntity(pos) instanceof ToiletTileEntity) {
                ToiletTileEntity tileentity = (ToiletTileEntity) worldIn.getTileEntity(pos);
                worldIn.updateComparatorOutputLevel(pos, state.getBlock());
                ItemStack bustack = tileentity.getBukkakeItem().copy();
                tileentity.setBukkakeItem(ItemStack.EMPTY);
                worldIn.addEntity(IKSGEntityUtil.createItemEntity(bustack, worldIn, pos.getX() + 0.5f, pos.getY() + 0.75f, pos.getZ() + 0.5f));
            }
            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    protected void playSound(@Nullable PlayerEntity player, World worldIn, BlockPos pos, boolean open) {
        if (open) {
            worldIn.playEvent(player, 1037, pos, 0);
        } else {
            worldIn.playEvent(player, 1036, pos, 0);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return (BlockState) this.getDefaultState().with(HORIZONTAL_FACING, p_196258_1_.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(HORIZONTAL_FACING, OPEN);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ToiletTileEntity();
    }

    @Override
    public final boolean hasTileEntity(BlockState state) {
        return true;
    }
}
