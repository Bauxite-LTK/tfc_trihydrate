package net.bauxite_ltk.tfc_trihydrate.block.multiblock.shapes;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class FlotationCellShapes implements Function<BlockPos, VoxelShape> {

    public static final Function<BlockPos, VoxelShape> SHAPE_GETTER = new FlotationCellShapes();

    private FlotationCellShapes()
    {
    }

    @Override
    public VoxelShape apply(BlockPos posInMultiBlock) {
        if(new BoundingBox(0,0,0,4,2,3).isInside(posInMultiBlock)){
            if(new BoundingBox(1,1,1,1,2,2).isInside(posInMultiBlock))
                return Shapes.empty();
            else if(new BoundingBox(3,1,1,3,2,2).isInside(posInMultiBlock))
                return Shapes.empty();
            else if(new BoundingBox(2,1,2,2,2,2).isInside(posInMultiBlock))
                return Shapes.empty();
            else if(new BoundingBox(2,1,1,2,2,1).isInside(posInMultiBlock))
                return Shapes.box(0.25,0,0.25,0.75,1,0.75);
            else if(new BoundingBox(0,2,3,5,2,3).isInside(posInMultiBlock))
                return Shapes.box(0,0,0.5,1,1,1);
            else return Shapes.block();
        }
        else if(new BoundingBox(0,3,0,4,3,0).isInside(posInMultiBlock)){
            return Shapes.block();
        }
        else if(new BoundingBox(0,3,1,4,3,3).isInside(posInMultiBlock)){
            if(new BlockPos(2,3,1).equals(posInMultiBlock)){
                return Shapes.box(0.25,0,0.25,0.75,1,0.75);
            }
            else return Shapes.box(0,4/16d,0,1,0.5,1);
        }
        else if(new BlockPos(2,4,0).equals(posInMultiBlock)){
            return Shapes.block();
        }
        else if(new BlockPos(2,4,1).equals(posInMultiBlock)){
            return Shapes.or(
                    Shapes.box(0.25,0,0.25,0.75,0.5,0.75),
                    Shapes.box(0,0.5,0,1,1,1),
                    Shapes.box(-2/16d,10/16d,-2/16d,18/16d,14/16d,18/16d)
            );
        }
        return Shapes.empty();
    }
}
