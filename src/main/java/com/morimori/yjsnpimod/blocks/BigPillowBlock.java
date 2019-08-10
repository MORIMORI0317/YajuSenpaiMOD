package com.morimori.yjsnpimod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
public class BigPillowBlock extends Block implements IWaterLoggable {
	   private static final VoxelShape ATARIZ = Block.makeCuboidShape(3, 0, 0, 13, 3, 16);
	   private static final VoxelShape ATARIX = Block.makeCuboidShape(0, 0, 3, 16, 3, 13);
	   public static final BooleanProperty WATERLOGGED =BlockStateProperties.WATERLOGGED;
	   public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public BigPillowBlock(Properties properties) {
		super(properties);
		 this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		    Direction direction = state.get(FACING);
		      return direction.getAxis() == Direction.Axis.X ? ATARIX : ATARIZ;
		   }
	   public BlockState getStateForPlacement(BlockItemUseContext context) {
		      return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
		   }
	   public BlockState rotate(BlockState state, Rotation rot) {
		      return state.with(FACING, rot.rotate(state.get(FACING)));
		   }
	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		      builder.add(FACING).add(new IProperty[]{WATERLOGGED});
		   }
	   @SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		      if (stateIn.get(WATERLOGGED)) {
		          worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		       }
		   return facing == Direction.DOWN && !this.isValidPosition(stateIn, worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		   }

		   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		      return func_220055_a(worldIn, pos.down(), Direction.UP);
		   }
		   @SuppressWarnings("deprecation")
		public IFluidState getFluidState(BlockState state) {
			      return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
			   }
		   public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			      return !state.get(WATERLOGGED);
			   }
		   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
			      if (worldIn.isRemote) {

		               player.trySleep(pos).ifLeft((p_220173_1_) -> {
		                   if (p_220173_1_ != null) {
		                      player.sendStatusMessage(p_220173_1_.getMessage(), true);
		                   }

		                });
		                return true;
			      }
			    return true;




		   }



}
