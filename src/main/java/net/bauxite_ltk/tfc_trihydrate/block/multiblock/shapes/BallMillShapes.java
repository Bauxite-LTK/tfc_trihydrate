package net.bauxite_ltk.tfc_trihydrate.block.multiblock.shapes;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class BallMillShapes implements Function<BlockPos, VoxelShape> {

    public static final Function<BlockPos, VoxelShape> SHAPE_GETTER = new BallMillShapes();

    private BallMillShapes()
    {
    }

    @Override
    public VoxelShape apply(BlockPos posInMultiBlock) {
        //bottom
        if(new BoundingBox(1,0,0,5,0,2).isInside(posInMultiBlock)){
            if(new BlockPos(3,0,2).equals(posInMultiBlock)){
                return Shapes.or(
                        Shapes.box(0,0,0,1,0.5,1),
                        Shapes.box(2/16d,0.5,10/16d,4/16d,1,14/16d),
                        Shapes.box(12/16d,0.5,10/16d,14/16d,1,14/16d)
                );
            }
            else return Shapes.box(0,0,0,1,0.5,1);
        }

        //slade
        else if(new BlockPos(6,1,2).equals(posInMultiBlock)
            || new BlockPos(0,1,2).equals(posInMultiBlock)
            || new BlockPos(0,2,0).equals(posInMultiBlock)
        ){
            return Shapes.box(0,0,0,1,0.5,1);
        }

        //solid
        else if(new BoundingBox(0,0,0,0,0,2).isInside(posInMultiBlock)
            || new BoundingBox(6,0,0,6,0,2).isInside(posInMultiBlock)
            || new BlockPos(0,1,0).equals(posInMultiBlock)
            || new BlockPos(6,1,0).equals(posInMultiBlock)
        ){
            return Shapes.block();
        }

        else if(new BlockPos(0,2,1).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(2/16d, 0, 1/16d, 1,9/16d, 15/16d),
                    Shapes.box(0, 9/16d, 0, 1,1,1)
            );
        }

        else if(new BlockPos(3,1,2).equals(posInMultiBlock)){
            return Shapes.box(0,0,0.5, 1,1,1);
        }

        else if(new BlockPos(1,1,2).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(0,0,0,4/16d,6/16d,15/16d),
                    Shapes.box(4/16d,0,12/16d,1,6/16d,15/16d),
                    Shapes.box(0,10/16d,0,4/16d,1,15/16d),
                    Shapes.box(4/16d,10/16d,12/16d,1,1,15/16d),
                    Shapes.box(0,6/16d,12/16d,4/16d,10/16d,15/16d)
            );
        }


        else if(new BlockPos(5,1,2).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(12/16d,0,0,1,6/16d,15/16d),
                    Shapes.box(4/16d,0,12/16d,1,6/16d,15/16d),
                    Shapes.box(12/16d,10/16d,0,1,1,15/16d),
                    Shapes.box(4/16d,10/16d,12/16d,1,1,15/16d),
                    Shapes.box(12/16d,6/16d,12/16d,1,10/16d,15/16d)
            );
        }

        else if(new BlockPos(2,1,2).equals(posInMultiBlock)
                || new BlockPos(4,1,2).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(0,0,12/16d,1,6/16d,15/16d),
                    Shapes.box(0,10/16d,12/16d,1,1,15/16d)
            );
        }

        else if(new BlockPos(6,1,1).equals(posInMultiBlock)){
            return Shapes.box(0,0,0,15/16d,15/16d,1);
        }
        else if(new BlockPos(0,1,1).equals(posInMultiBlock)){
            return Shapes.box(1/16d,0,0,1,1,1);
        }

        else if(new BoundingBox(1,1,0,5,2,1).isInside(posInMultiBlock)){
            if(new BoundingBox(1,1,0,5,1,0).isInside(posInMultiBlock)){
                return Shapes.box(0,4/16d,6/16d,1,1,1);
            }
            else if(new BoundingBox(1,2,0,5,2,0).isInside(posInMultiBlock)){
                return Shapes.box(0,0,6/16d,1,8/16d,1);
            }
            else if(new BoundingBox(1,2,1,5,2,1).isInside(posInMultiBlock)){
                return Shapes.box(0,4/16d,0,1,8/16d,10/16d);
            }
            else if(new BoundingBox(1,1,1,5,1,1).isInside(posInMultiBlock)){
                return Shapes.box(0,4/16d,0,1,1,10/16d);
            }
            return Shapes.block();
        }
        return Shapes.empty();
    }
}
