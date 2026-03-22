package net.bauxite_ltk.tfc_trihydrate.block.multiblock.shapes;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class HydrocycloneShapes implements Function<BlockPos, VoxelShape> {

    public static final Function<BlockPos, VoxelShape> SHAPE_GETTER = new HydrocycloneShapes();

    private HydrocycloneShapes()
    {
    }

    @Override
    public VoxelShape apply(BlockPos posInMultiBlock) {
        if(new BoundingBox(0,0,0,2,2,1).isInside(posInMultiBlock)){
            if(new BlockPos(0,1,0).equals(posInMultiBlock)){
                return Shapes.box(0.5,0,0.5,1,1,1);
            }
            else if(new BlockPos(0,2,0).equals(posInMultiBlock)){
                return Shapes.box(0.5,0,0.5,1,0.5,1);
            }
            else if(new BlockPos(0,1,1).equals(posInMultiBlock)){
                return Shapes.box(0.5,0,0,1,1,1);
            }
            else if(new BlockPos(0,2,1).equals(posInMultiBlock)){
                return Shapes.box(0.5,0,0,1,0.5,1);
            }
            else if(new BlockPos(2,1,0).equals(posInMultiBlock)){
                return Shapes.box(0,0,0.5, 0.5,1,1);
            }
            else if(new BlockPos(2,2,0).equals(posInMultiBlock)){
                return Shapes.box(0,0,0.5, 0.5,0.5,1);
            }
            else if(new BlockPos(2,1,1).equals(posInMultiBlock)){
                return Shapes.box(0,0,0, 0.5,1,1);
            }
            else if(new BlockPos(2,2,1).equals(posInMultiBlock)){
                return Shapes.box(0,0,0, 0.5,0.5,1);
            }
            else if(new BlockPos(1,1,0).equals(posInMultiBlock)){
                return Shapes.box(0,0,0.5,1,1,1);
            }
            else if(new BlockPos(1,2,0).equals(posInMultiBlock)){
                return Shapes.box(0,0,0.5,1,0.5,1);
            }
            else if(new BlockPos(1,2,1).equals(posInMultiBlock)){
                Shapes.box(0,0,0,1,0.5,1);
            }
            return Shapes.block();
        }
        else if(new BoundingBox(0,0,2,2,0,2).isInside(posInMultiBlock)){
            if(posInMultiBlock.getX() == 0){
                return Shapes.or(
                        Shapes.box(0,0,0,1,0.5,1),
                        Shapes.box(5/16d,0.5,5/16d,11/16d,1,11/16d)
                );
            }
            return Shapes.box(0,0,0,1,0.5,1);
        }
        else if(new BlockPos(1,1,2).equals(posInMultiBlock)){
            return Shapes.block();
        }
        else if(new BlockPos(0,1,2).equals(posInMultiBlock)){
            return Shapes.box(5/16d,0,5/16d,11/16d,1,11/16d);
        }
        else if(new BlockPos(0,2,2).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(5/16d,0,5/16d,11/16d,12/16d,11/16d),
                    Shapes.box(4/16d,12/16d,4/16d,12/16d,1,12/16d)

            );
        }
        return Shapes.empty();
    }
}
