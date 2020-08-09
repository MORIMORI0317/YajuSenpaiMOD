package net.morimori.yjsnpimod.block;

import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import red.felnull.otyacraftengine.util.IKSGVoxelShapeUtil;

public class ToiletVoxelshape {
    private static final VoxelShape NORTH_OPEN_PART1 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 9, 10, 12, 22, 11);
    private static final VoxelShape NORTH_OPEN_PART2 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 8, 10, 13, 21, 11);
    private static final VoxelShape NORTH_OPEN_PART3 = IKSGVoxelShapeUtil.makeCuboidShaoe0(2, 7, 10, 14, 19, 11);
    private static final VoxelShape NORTH_OPEN_PART4 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 9, 11, 12, 21, 12);
    private static final VoxelShape NORTH_OPEN_PART5 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 9, 11, 13, 20, 12);
    private static final VoxelShape NORTH_OPEN_PART6 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 8, 13, 13, 20, 15);
    private static final VoxelShape NORTH_OPEN_PART7 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 8, 12, 12, 20, 16);
    private static final VoxelShape NORTH_OPEN_PART8 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 7, 13, 12, 21, 15);
    private static final VoxelShape NORTH_OPEN_PART9 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 6, 10, 13, 10, 13);
    private static final VoxelShape NORTH_OPEN_PART10 = IKSGVoxelShapeUtil.makeCuboidShaoe0(2, 17, 13, 3, 19, 14);
    private static final VoxelShape NORTH_OPEN_PART11 = IKSGVoxelShapeUtil.makeCuboidShaoe0(11, 6, 0, 13, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART12 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 6, 0, 5, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART13 = IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 0, 6, 8, 2);
    private static final VoxelShape NORTH_OPEN_PART14 = IKSGVoxelShapeUtil.makeCuboidShaoe0(6, 6, 0, 7, 8, 1);
    private static final VoxelShape NORTH_OPEN_PART15 = IKSGVoxelShapeUtil.makeCuboidShaoe0(6, 6, 9, 7, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART16 = IKSGVoxelShapeUtil.makeCuboidShaoe0(9, 6, 9, 10, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART17 = IKSGVoxelShapeUtil.makeCuboidShaoe0(9, 6, 0, 10, 8, 1);
    private static final VoxelShape NORTH_OPEN_PART18 = IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 8, 6, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART19 = IKSGVoxelShapeUtil.makeCuboidShaoe0(10, 6, 0, 11, 8, 2);
    private static final VoxelShape NORTH_OPEN_PART20 = IKSGVoxelShapeUtil.makeCuboidShaoe0(10, 6, 8, 11, 8, 10);
    private static final VoxelShape NORTH_OPEN_PART21 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 6, 10, 12, 8, 12);
    private static final VoxelShape NORTH_OPEN_PART22 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 6, -2, 12, 8, 0);
    private static final VoxelShape NORTH_OPEN_PART23 = IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 0, 11, 7, 10);
    private static final VoxelShape NORTH_OPEN_PART24 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 0, 1, 12, 6, 11);
    private static final VoxelShape NORTH_OPEN_PART25 = IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 2, 0, 12, 6, 12);
    private static final VoxelShape NORTH_OPEN_PART26 = IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 2, 1, 13, 6, 11);
    public static final VoxelShape NORTH_OPEN_AXIS_AABB = VoxelShapes.or(NORTH_OPEN_PART1, NORTH_OPEN_PART2, NORTH_OPEN_PART3, NORTH_OPEN_PART4, NORTH_OPEN_PART5, NORTH_OPEN_PART6, NORTH_OPEN_PART7, NORTH_OPEN_PART8, NORTH_OPEN_PART9, NORTH_OPEN_PART10, NORTH_OPEN_PART11, NORTH_OPEN_PART12, NORTH_OPEN_PART13, NORTH_OPEN_PART14, NORTH_OPEN_PART15, NORTH_OPEN_PART16, NORTH_OPEN_PART17, NORTH_OPEN_PART18, NORTH_OPEN_PART19, NORTH_OPEN_PART20, NORTH_OPEN_PART21, NORTH_OPEN_PART22, NORTH_OPEN_PART23, NORTH_OPEN_PART24, NORTH_OPEN_PART25, NORTH_OPEN_PART26);

    private static final VoxelShape WEST_OPEN_PART1 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 9, 10, 12, 22, 11);
    private static final VoxelShape WEST_OPEN_PART2 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 8, 10, 13, 21, 11);
    private static final VoxelShape WEST_OPEN_PART3 = IKSGVoxelShapeUtil.makeCuboidShaoe90(2, 7, 10, 14, 19, 11);
    private static final VoxelShape WEST_OPEN_PART4 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 9, 11, 12, 21, 12);
    private static final VoxelShape WEST_OPEN_PART5 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 9, 11, 13, 20, 12);
    private static final VoxelShape WEST_OPEN_PART6 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 8, 13, 13, 20, 15);
    private static final VoxelShape WEST_OPEN_PART7 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 8, 12, 12, 20, 16);
    private static final VoxelShape WEST_OPEN_PART8 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 7, 13, 12, 21, 15);
    private static final VoxelShape WEST_OPEN_PART9 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 6, 10, 13, 10, 13);
    private static final VoxelShape WEST_OPEN_PART10 = IKSGVoxelShapeUtil.makeCuboidShaoe90(2, 17, 13, 3, 19, 14);
    private static final VoxelShape WEST_OPEN_PART11 = IKSGVoxelShapeUtil.makeCuboidShaoe90(11, 6, 0, 13, 8, 10);
    private static final VoxelShape WEST_OPEN_PART12 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 6, 0, 5, 8, 10);
    private static final VoxelShape WEST_OPEN_PART13 = IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 0, 6, 8, 2);
    private static final VoxelShape WEST_OPEN_PART14 = IKSGVoxelShapeUtil.makeCuboidShaoe90(6, 6, 0, 7, 8, 1);
    private static final VoxelShape WEST_OPEN_PART15 = IKSGVoxelShapeUtil.makeCuboidShaoe90(6, 6, 9, 7, 8, 10);
    private static final VoxelShape WEST_OPEN_PART16 = IKSGVoxelShapeUtil.makeCuboidShaoe90(9, 6, 9, 10, 8, 10);
    private static final VoxelShape WEST_OPEN_PART17 = IKSGVoxelShapeUtil.makeCuboidShaoe90(9, 6, 0, 10, 8, 1);
    private static final VoxelShape WEST_OPEN_PART18 = IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 8, 6, 8, 10);
    private static final VoxelShape WEST_OPEN_PART19 = IKSGVoxelShapeUtil.makeCuboidShaoe90(10, 6, 0, 11, 8, 2);
    private static final VoxelShape WEST_OPEN_PART20 = IKSGVoxelShapeUtil.makeCuboidShaoe90(10, 6, 8, 11, 8, 10);
    private static final VoxelShape WEST_OPEN_PART21 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 6, 10, 12, 8, 12);
    private static final VoxelShape WEST_OPEN_PART22 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 6, -2, 12, 8, 0);
    private static final VoxelShape WEST_OPEN_PART23 = IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 0, 11, 7, 10);
    private static final VoxelShape WEST_OPEN_PART24 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 0, 1, 12, 6, 11);
    private static final VoxelShape WEST_OPEN_PART25 = IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 2, 0, 12, 6, 12);
    private static final VoxelShape WEST_OPEN_PART26 = IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 2, 1, 13, 6, 11);
    public static final VoxelShape WEST_OPEN_AXIS_AABB = VoxelShapes.or(WEST_OPEN_PART1, WEST_OPEN_PART2, WEST_OPEN_PART3, WEST_OPEN_PART4, WEST_OPEN_PART5, WEST_OPEN_PART6, WEST_OPEN_PART7, WEST_OPEN_PART8, WEST_OPEN_PART9, WEST_OPEN_PART10, WEST_OPEN_PART11, WEST_OPEN_PART12, WEST_OPEN_PART13, WEST_OPEN_PART14, WEST_OPEN_PART15, WEST_OPEN_PART16, WEST_OPEN_PART17, WEST_OPEN_PART18, WEST_OPEN_PART19, WEST_OPEN_PART20, WEST_OPEN_PART21, WEST_OPEN_PART22, WEST_OPEN_PART23, WEST_OPEN_PART24, WEST_OPEN_PART25, WEST_OPEN_PART26);

    private static final VoxelShape EAST_OPEN_PART1 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 9, 10, 12, 22, 11);
    private static final VoxelShape EAST_OPEN_PART2 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 8, 10, 13, 21, 11);
    private static final VoxelShape EAST_OPEN_PART3 = IKSGVoxelShapeUtil.makeCuboidShaoe270(2, 7, 10, 14, 19, 11);
    private static final VoxelShape EAST_OPEN_PART4 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 9, 11, 12, 21, 12);
    private static final VoxelShape EAST_OPEN_PART5 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 9, 11, 13, 20, 12);
    private static final VoxelShape EAST_OPEN_PART6 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 8, 13, 13, 20, 15);
    private static final VoxelShape EAST_OPEN_PART7 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 8, 12, 12, 20, 16);
    private static final VoxelShape EAST_OPEN_PART8 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 7, 13, 12, 21, 15);
    private static final VoxelShape EAST_OPEN_PART9 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 6, 10, 13, 10, 13);
    private static final VoxelShape EAST_OPEN_PART10 = IKSGVoxelShapeUtil.makeCuboidShaoe270(2, 17, 13, 3, 19, 14);
    private static final VoxelShape EAST_OPEN_PART11 = IKSGVoxelShapeUtil.makeCuboidShaoe270(11, 6, 0, 13, 8, 10);
    private static final VoxelShape EAST_OPEN_PART12 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 6, 0, 5, 8, 10);
    private static final VoxelShape EAST_OPEN_PART13 = IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 0, 6, 8, 2);
    private static final VoxelShape EAST_OPEN_PART14 = IKSGVoxelShapeUtil.makeCuboidShaoe270(6, 6, 0, 7, 8, 1);
    private static final VoxelShape EAST_OPEN_PART15 = IKSGVoxelShapeUtil.makeCuboidShaoe270(6, 6, 9, 7, 8, 10);
    private static final VoxelShape EAST_OPEN_PART16 = IKSGVoxelShapeUtil.makeCuboidShaoe270(9, 6, 9, 10, 8, 10);
    private static final VoxelShape EAST_OPEN_PART17 = IKSGVoxelShapeUtil.makeCuboidShaoe270(9, 6, 0, 10, 8, 1);
    private static final VoxelShape EAST_OPEN_PART18 = IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 8, 6, 8, 10);
    private static final VoxelShape EAST_OPEN_PART19 = IKSGVoxelShapeUtil.makeCuboidShaoe270(10, 6, 0, 11, 8, 2);
    private static final VoxelShape EAST_OPEN_PART20 = IKSGVoxelShapeUtil.makeCuboidShaoe270(10, 6, 8, 11, 8, 10);
    private static final VoxelShape EAST_OPEN_PART21 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 6, 10, 12, 8, 12);
    private static final VoxelShape EAST_OPEN_PART22 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 6, -2, 12, 8, 0);
    private static final VoxelShape EAST_OPEN_PART23 = IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 0, 11, 7, 10);
    private static final VoxelShape EAST_OPEN_PART24 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 0, 1, 12, 6, 11);
    private static final VoxelShape EAST_OPEN_PART25 = IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 2, 0, 12, 6, 12);
    private static final VoxelShape EAST_OPEN_PART26 = IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 2, 1, 13, 6, 11);
    public static final VoxelShape EAST_OPEN_AXIS_AABB = VoxelShapes.or(EAST_OPEN_PART1, EAST_OPEN_PART2, EAST_OPEN_PART3, EAST_OPEN_PART4, EAST_OPEN_PART5, EAST_OPEN_PART6, EAST_OPEN_PART7, EAST_OPEN_PART8, EAST_OPEN_PART9, EAST_OPEN_PART10, EAST_OPEN_PART11, EAST_OPEN_PART12, EAST_OPEN_PART13, EAST_OPEN_PART14, EAST_OPEN_PART15, EAST_OPEN_PART16, EAST_OPEN_PART17, EAST_OPEN_PART18, EAST_OPEN_PART19, EAST_OPEN_PART20, EAST_OPEN_PART21, EAST_OPEN_PART22, EAST_OPEN_PART23, EAST_OPEN_PART24, EAST_OPEN_PART25, EAST_OPEN_PART26);

    private static final VoxelShape SOUTH_OPEN_PART1 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 9, 10, 12, 22, 11);
    private static final VoxelShape SOUTH_OPEN_PART2 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 8, 10, 13, 21, 11);
    private static final VoxelShape SOUTH_OPEN_PART3 = IKSGVoxelShapeUtil.makeCuboidShaoe180(2, 7, 10, 14, 19, 11);
    private static final VoxelShape SOUTH_OPEN_PART4 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 9, 11, 12, 21, 12);
    private static final VoxelShape SOUTH_OPEN_PART5 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 9, 11, 13, 20, 12);
    private static final VoxelShape SOUTH_OPEN_PART6 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 8, 13, 13, 20, 15);
    private static final VoxelShape SOUTH_OPEN_PART7 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 8, 12, 12, 20, 16);
    private static final VoxelShape SOUTH_OPEN_PART8 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 7, 13, 12, 21, 15);
    private static final VoxelShape SOUTH_OPEN_PART9 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 6, 10, 13, 10, 13);
    private static final VoxelShape SOUTH_OPEN_PART10 = IKSGVoxelShapeUtil.makeCuboidShaoe180(2, 17, 13, 3, 19, 14);
    private static final VoxelShape SOUTH_OPEN_PART11 = IKSGVoxelShapeUtil.makeCuboidShaoe180(11, 6, 0, 13, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART12 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 6, 0, 5, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART13 = IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 0, 6, 8, 2);
    private static final VoxelShape SOUTH_OPEN_PART14 = IKSGVoxelShapeUtil.makeCuboidShaoe180(6, 6, 0, 7, 8, 1);
    private static final VoxelShape SOUTH_OPEN_PART15 = IKSGVoxelShapeUtil.makeCuboidShaoe180(6, 6, 9, 7, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART16 = IKSGVoxelShapeUtil.makeCuboidShaoe180(9, 6, 9, 10, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART17 = IKSGVoxelShapeUtil.makeCuboidShaoe180(9, 6, 0, 10, 8, 1);
    private static final VoxelShape SOUTH_OPEN_PART18 = IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 8, 6, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART19 = IKSGVoxelShapeUtil.makeCuboidShaoe180(10, 6, 0, 11, 8, 2);
    private static final VoxelShape SOUTH_OPEN_PART20 = IKSGVoxelShapeUtil.makeCuboidShaoe180(10, 6, 8, 11, 8, 10);
    private static final VoxelShape SOUTH_OPEN_PART21 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 6, 10, 12, 8, 12);
    private static final VoxelShape SOUTH_OPEN_PART22 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 6, -2, 12, 8, 0);
    private static final VoxelShape SOUTH_OPEN_PART23 = IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 0, 11, 7, 10);
    private static final VoxelShape SOUTH_OPEN_PART24 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 0, 1, 12, 6, 11);
    private static final VoxelShape SOUTH_OPEN_PART25 = IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 2, 0, 12, 6, 12);
    private static final VoxelShape SOUTH_OPEN_PART26 = IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 2, 1, 13, 6, 11);
    public static final VoxelShape SOUTH_OPEN_AXIS_AABB = VoxelShapes.or(SOUTH_OPEN_PART1, SOUTH_OPEN_PART2, SOUTH_OPEN_PART3, SOUTH_OPEN_PART4, SOUTH_OPEN_PART5, SOUTH_OPEN_PART6, SOUTH_OPEN_PART7, SOUTH_OPEN_PART8, SOUTH_OPEN_PART9, SOUTH_OPEN_PART10, SOUTH_OPEN_PART11, SOUTH_OPEN_PART12, SOUTH_OPEN_PART13, SOUTH_OPEN_PART14, SOUTH_OPEN_PART15, SOUTH_OPEN_PART16, SOUTH_OPEN_PART17, SOUTH_OPEN_PART18, SOUTH_OPEN_PART19, SOUTH_OPEN_PART20, SOUTH_OPEN_PART21, SOUTH_OPEN_PART22, SOUTH_OPEN_PART23, SOUTH_OPEN_PART24, SOUTH_OPEN_PART25, SOUTH_OPEN_PART26);

    private static final VoxelShape NORTH_CLOSE_PART1 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 7, -3, 12, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART2 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 7, -2, 13, 8, 11);
    private static final VoxelShape NORTH_CLOSE_PART3 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(2, 7, 0, 14, 8, 12);
    private static final VoxelShape NORTH_CLOSE_PART4 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 8, -2, 12, 9, 10);
    private static final VoxelShape NORTH_CLOSE_PART5 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 8, -1, 13, 9, 10);
    private static final VoxelShape NORTH_CLOSE_PART6 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 8, 13, 13, 20, 15);
    private static final VoxelShape NORTH_CLOSE_PART7 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 8, 12, 12, 20, 16);
    private static final VoxelShape NORTH_CLOSE_PART8 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 7, 13, 12, 21, 15);
    private static final VoxelShape NORTH_CLOSE_PART9 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 6, 10, 13, 10, 13);
    private static final VoxelShape NORTH_CLOSE_PART10 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(2, 17, 13, 3, 19, 14);
    private static final VoxelShape NORTH_CLOSE_PART11 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(11, 6, 0, 13, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART12 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 6, 0, 5, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART13 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 0, 6, 8, 2);
    private static final VoxelShape NORTH_CLOSE_PART14 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(6, 6, 0, 7, 8, 1);
    private static final VoxelShape NORTH_CLOSE_PART15 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(6, 6, 9, 7, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART16 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(9, 6, 9, 10, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART17 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(9, 6, 0, 10, 8, 1);
    private static final VoxelShape NORTH_CLOSE_PART18 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 8, 6, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART19 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(10, 6, 0, 11, 8, 2);
    private static final VoxelShape NORTH_CLOSE_PART20 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(10, 6, 8, 11, 8, 10);
    private static final VoxelShape NORTH_CLOSE_PART21 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 6, 10, 12, 8, 12);
    private static final VoxelShape NORTH_CLOSE_PART22 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 6, -2, 12, 8, 0);
    private static final VoxelShape NORTH_CLOSE_PART23 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(5, 6, 0, 11, 7, 10);
    private static final VoxelShape NORTH_CLOSE_PART24 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 0, 1, 12, 6, 11);
    private static final VoxelShape NORTH_CLOSE_PART25 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(4, 2, 0, 12, 6, 12);
    private static final VoxelShape NORTH_CLOSE_PART26 =  IKSGVoxelShapeUtil.makeCuboidShaoe0(3, 2, 1, 13, 6, 11);
    public static final VoxelShape NORTH_CLOSE_AXIS_AABB = VoxelShapes.or(NORTH_CLOSE_PART1,NORTH_CLOSE_PART2,NORTH_CLOSE_PART3,NORTH_CLOSE_PART4,NORTH_CLOSE_PART5,NORTH_CLOSE_PART6,NORTH_CLOSE_PART7,NORTH_CLOSE_PART8,NORTH_CLOSE_PART9,NORTH_CLOSE_PART10,NORTH_CLOSE_PART11,NORTH_CLOSE_PART12,NORTH_CLOSE_PART13,NORTH_CLOSE_PART14,NORTH_CLOSE_PART15,NORTH_CLOSE_PART16,NORTH_CLOSE_PART17,NORTH_CLOSE_PART18,NORTH_CLOSE_PART19,NORTH_CLOSE_PART20,NORTH_CLOSE_PART21,NORTH_CLOSE_PART22,NORTH_CLOSE_PART23,NORTH_CLOSE_PART24,NORTH_CLOSE_PART25,NORTH_CLOSE_PART26);

    private static final VoxelShape SOUTH_CLOSE_PART1 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 7, -3, 12, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART2 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 7, -2, 13, 8, 11);
    private static final VoxelShape SOUTH_CLOSE_PART3 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(2, 7, 0, 14, 8, 12);
    private static final VoxelShape SOUTH_CLOSE_PART4 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 8, -2, 12, 9, 10);
    private static final VoxelShape SOUTH_CLOSE_PART5 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 8, -1, 13, 9, 10);
    private static final VoxelShape SOUTH_CLOSE_PART6 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 8, 13, 13, 20, 15);
    private static final VoxelShape SOUTH_CLOSE_PART7 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 8, 12, 12, 20, 16);
    private static final VoxelShape SOUTH_CLOSE_PART8 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 7, 13, 12, 21, 15);
    private static final VoxelShape SOUTH_CLOSE_PART9 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 6, 10, 13, 10, 13);
    private static final VoxelShape SOUTH_CLOSE_PART10 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(2, 17, 13, 3, 19, 14);
    private static final VoxelShape SOUTH_CLOSE_PART11 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(11, 6, 0, 13, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART12 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 6, 0, 5, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART13 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 0, 6, 8, 2);
    private static final VoxelShape SOUTH_CLOSE_PART14 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(6, 6, 0, 7, 8, 1);
    private static final VoxelShape SOUTH_CLOSE_PART15 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(6, 6, 9, 7, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART16 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(9, 6, 9, 10, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART17 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(9, 6, 0, 10, 8, 1);
    private static final VoxelShape SOUTH_CLOSE_PART18 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 8, 6, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART19 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(10, 6, 0, 11, 8, 2);
    private static final VoxelShape SOUTH_CLOSE_PART20 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(10, 6, 8, 11, 8, 10);
    private static final VoxelShape SOUTH_CLOSE_PART21 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 6, 10, 12, 8, 12);
    private static final VoxelShape SOUTH_CLOSE_PART22 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 6, -2, 12, 8, 0);
    private static final VoxelShape SOUTH_CLOSE_PART23 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(5, 6, 0, 11, 7, 10);
    private static final VoxelShape SOUTH_CLOSE_PART24 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 0, 1, 12, 6, 11);
    private static final VoxelShape SOUTH_CLOSE_PART25 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(4, 2, 0, 12, 6, 12);
    private static final VoxelShape SOUTH_CLOSE_PART26 =  IKSGVoxelShapeUtil.makeCuboidShaoe180(3, 2, 1, 13, 6, 11);
    public static final VoxelShape SOUTH_CLOSE_AXIS_AABB = VoxelShapes.or(SOUTH_CLOSE_PART1,SOUTH_CLOSE_PART2,SOUTH_CLOSE_PART3,SOUTH_CLOSE_PART4,SOUTH_CLOSE_PART5,SOUTH_CLOSE_PART6,SOUTH_CLOSE_PART7,SOUTH_CLOSE_PART8,SOUTH_CLOSE_PART9,SOUTH_CLOSE_PART10,SOUTH_CLOSE_PART11,SOUTH_CLOSE_PART12,SOUTH_CLOSE_PART13,SOUTH_CLOSE_PART14,SOUTH_CLOSE_PART15,SOUTH_CLOSE_PART16,SOUTH_CLOSE_PART17,SOUTH_CLOSE_PART18,SOUTH_CLOSE_PART19,SOUTH_CLOSE_PART20,SOUTH_CLOSE_PART21,SOUTH_CLOSE_PART22,SOUTH_CLOSE_PART23,SOUTH_CLOSE_PART24,SOUTH_CLOSE_PART25,SOUTH_CLOSE_PART26);

    private static final VoxelShape WEST_CLOSE_PART1 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 7, -3, 12, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART2 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 7, -2, 13, 8, 11);
    private static final VoxelShape WEST_CLOSE_PART3 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(2, 7, 0, 14, 8, 12);
    private static final VoxelShape WEST_CLOSE_PART4 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 8, -2, 12, 9, 10);
    private static final VoxelShape WEST_CLOSE_PART5 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 8, -1, 13, 9, 10);
    private static final VoxelShape WEST_CLOSE_PART6 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 8, 13, 13, 20, 15);
    private static final VoxelShape WEST_CLOSE_PART7 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 8, 12, 12, 20, 16);
    private static final VoxelShape WEST_CLOSE_PART8 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 7, 13, 12, 21, 15);
    private static final VoxelShape WEST_CLOSE_PART9 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 6, 10, 13, 10, 13);
    private static final VoxelShape WEST_CLOSE_PART10 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(2, 17, 13, 3, 19, 14);
    private static final VoxelShape WEST_CLOSE_PART11 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(11, 6, 0, 13, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART12 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 6, 0, 5, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART13 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 0, 6, 8, 2);
    private static final VoxelShape WEST_CLOSE_PART14 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(6, 6, 0, 7, 8, 1);
    private static final VoxelShape WEST_CLOSE_PART15 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(6, 6, 9, 7, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART16 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(9, 6, 9, 10, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART17 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(9, 6, 0, 10, 8, 1);
    private static final VoxelShape WEST_CLOSE_PART18 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 8, 6, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART19 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(10, 6, 0, 11, 8, 2);
    private static final VoxelShape WEST_CLOSE_PART20 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(10, 6, 8, 11, 8, 10);
    private static final VoxelShape WEST_CLOSE_PART21 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 6, 10, 12, 8, 12);
    private static final VoxelShape WEST_CLOSE_PART22 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 6, -2, 12, 8, 0);
    private static final VoxelShape WEST_CLOSE_PART23 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(5, 6, 0, 11, 7, 10);
    private static final VoxelShape WEST_CLOSE_PART24 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 0, 1, 12, 6, 11);
    private static final VoxelShape WEST_CLOSE_PART25 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(4, 2, 0, 12, 6, 12);
    private static final VoxelShape WEST_CLOSE_PART26 =  IKSGVoxelShapeUtil.makeCuboidShaoe90(3, 2, 1, 13, 6, 11);
    public static final VoxelShape WEST_CLOSE_AXIS_AABB = VoxelShapes.or(WEST_CLOSE_PART1,WEST_CLOSE_PART2,WEST_CLOSE_PART3,WEST_CLOSE_PART4,WEST_CLOSE_PART5,WEST_CLOSE_PART6,WEST_CLOSE_PART7,WEST_CLOSE_PART8,WEST_CLOSE_PART9,WEST_CLOSE_PART10,WEST_CLOSE_PART11,WEST_CLOSE_PART12,WEST_CLOSE_PART13,WEST_CLOSE_PART14,WEST_CLOSE_PART15,WEST_CLOSE_PART16,WEST_CLOSE_PART17,WEST_CLOSE_PART18,WEST_CLOSE_PART19,WEST_CLOSE_PART20,WEST_CLOSE_PART21,WEST_CLOSE_PART22,WEST_CLOSE_PART23,WEST_CLOSE_PART24,WEST_CLOSE_PART25,WEST_CLOSE_PART26);

    private static final VoxelShape EAST_CLOSE_PART1 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 7, -3, 12, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART2 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 7, -2, 13, 8, 11);
    private static final VoxelShape EAST_CLOSE_PART3 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(2, 7, 0, 14, 8, 12);
    private static final VoxelShape EAST_CLOSE_PART4 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 8, -2, 12, 9, 10);
    private static final VoxelShape EAST_CLOSE_PART5 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 8, -1, 13, 9, 10);
    private static final VoxelShape EAST_CLOSE_PART6 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 8, 13, 13, 20, 15);
    private static final VoxelShape EAST_CLOSE_PART7 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 8, 12, 12, 20, 16);
    private static final VoxelShape EAST_CLOSE_PART8 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 7, 13, 12, 21, 15);
    private static final VoxelShape EAST_CLOSE_PART9 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 6, 10, 13, 10, 13);
    private static final VoxelShape EAST_CLOSE_PART10 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(2, 17, 13, 3, 19, 14);
    private static final VoxelShape EAST_CLOSE_PART11 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(11, 6, 0, 13, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART12 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 6, 0, 5, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART13 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 0, 6, 8, 2);
    private static final VoxelShape EAST_CLOSE_PART14 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(6, 6, 0, 7, 8, 1);
    private static final VoxelShape EAST_CLOSE_PART15 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(6, 6, 9, 7, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART16 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(9, 6, 9, 10, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART17 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(9, 6, 0, 10, 8, 1);
    private static final VoxelShape EAST_CLOSE_PART18 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 8, 6, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART19 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(10, 6, 0, 11, 8, 2);
    private static final VoxelShape EAST_CLOSE_PART20 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(10, 6, 8, 11, 8, 10);
    private static final VoxelShape EAST_CLOSE_PART21 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 6, 10, 12, 8, 12);
    private static final VoxelShape EAST_CLOSE_PART22 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 6, -2, 12, 8, 0);
    private static final VoxelShape EAST_CLOSE_PART23 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(5, 6, 0, 11, 7, 10);
    private static final VoxelShape EAST_CLOSE_PART24 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 0, 1, 12, 6, 11);
    private static final VoxelShape EAST_CLOSE_PART25 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(4, 2, 0, 12, 6, 12);
    private static final VoxelShape EAST_CLOSE_PART26 =  IKSGVoxelShapeUtil.makeCuboidShaoe270(3, 2, 1, 13, 6, 11);
    public static final VoxelShape EAST_CLOSE_AXIS_AABB = VoxelShapes.or(EAST_CLOSE_PART1,EAST_CLOSE_PART2,EAST_CLOSE_PART3,EAST_CLOSE_PART4,EAST_CLOSE_PART5,EAST_CLOSE_PART6,EAST_CLOSE_PART7,EAST_CLOSE_PART8,EAST_CLOSE_PART9,EAST_CLOSE_PART10,EAST_CLOSE_PART11,EAST_CLOSE_PART12,EAST_CLOSE_PART13,EAST_CLOSE_PART14,EAST_CLOSE_PART15,EAST_CLOSE_PART16,EAST_CLOSE_PART17,EAST_CLOSE_PART18,EAST_CLOSE_PART19,EAST_CLOSE_PART20,EAST_CLOSE_PART21,EAST_CLOSE_PART22,EAST_CLOSE_PART23,EAST_CLOSE_PART24,EAST_CLOSE_PART25,EAST_CLOSE_PART26);


}
