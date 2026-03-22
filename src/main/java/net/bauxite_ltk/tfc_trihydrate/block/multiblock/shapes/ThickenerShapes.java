package net.bauxite_ltk.tfc_trihydrate.block.multiblock.shapes;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class ThickenerShapes implements Function<BlockPos, VoxelShape> {

    public static final Function<BlockPos, VoxelShape> SHAPE_GETTER = new ThickenerShapes();


    private ThickenerShapes()
    {
    }

    @Override
    public VoxelShape apply(BlockPos posInMultiBlock) {
        int pX = posInMultiBlock.getX();
        int pY = posInMultiBlock.getY();
        int pZ = posInMultiBlock.getZ();
        if(new BlockPos(0,0,2).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BlockPos(0,1,2).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BlockPos(0,0,3).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,8,4,0,-4),
                    center(8,8,8,4,-4,4)
            );
        }
        else if(new BlockPos(0,1,3).equals(posInMultiBlock)){
            return center(8,16,8,4,0,-4);
        }
        else if(new BlockPos(0,0,4).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,16,-4,4,0)
                    );
        }
        else if(new BlockPos(0,1,4).equals(posInMultiBlock)){
            return center(8,16,16,-4,0,0);
        }
        else if(new BlockPos(0,0,5).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,8,4,0,4),
                    center(8,8,8,4,-4,-4)
            );
        }
        else if(new BlockPos(0,1,5).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(pX==0 && pZ==6 && pY>=0 && pY<=1){
            return center(8,16,8,4,0,-4);
        }
        else if(new BlockPos(1,0,1).equals(posInMultiBlock)){
            return center(8,8,8,4,-4,4);
        }
        else if(new BlockPos(1,0,2).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,8,-4,4,4)
            );
        }
        else if(new BlockPos(1,0,7).equals(posInMultiBlock)){
            return center(8,8,8,4,-4,-4);
        }
        else if(new BlockPos(1,0,6).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,8,-4,4,-4)
            );
        }
        else if(new BlockPos(2,0,0).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BlockPos(2,1,0).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BlockPos(2,0,1).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,16,4,0,0),
                    center(8,8,8,4,4,-4)
            );
        }

        else if(new BlockPos(2,0,8).equals(posInMultiBlock)){
            return center(8,16,8,4,0,-4);
        }
        else if(new BlockPos(2,1,8).equals(posInMultiBlock)){
            return center(8,16,8,4,0,-4);
        }
        else if(new BlockPos(2,0,7).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,16,4,0,0),
                    center(8,8,8,4,4,4)
            );
        }
        else if(new BlockPos(3,0,0).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,4),
                    center(8,8,8,-4,4,4)
            );
        }
        else if(new BlockPos(3,0,1).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,-4),
                    center(8,8,8,-4,4,-4)
            );
        }
        else if(new BlockPos(3,1,0).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(new BlockPos(3,1,1).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,-4);
        }

        else if(new BlockPos(3,0,8).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,-4),
                    center(8,8,8,-4,4,-4)
            );
        }
        else if(new BlockPos(3,0,7).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,4),
                    center(8,8,8,-4,4,4)
            );
        }
        else if(new BlockPos(3,1,8).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,-4);
        }
        else if(new BlockPos(3,1,7).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }

        else if(new BlockPos(4,0,0).equals(posInMultiBlock)){
            return center(16,8,8,0,-4,4);
        }
        else if(new BlockPos(4,0,1).equals(posInMultiBlock)){
            return center(16,8,8,0,-4,-4);
        }
        else if(new BlockPos(4,0,4).equals(posInMultiBlock)){
            return Shapes.block();
        }
        else if(new BlockPos(4,0,7).equals(posInMultiBlock)){
            return center(16,8,8,0,-4,4);
        }
        else if(new BlockPos(4,0,8).equals(posInMultiBlock)){
            return center(16,8,16,0,-4,0);
        }


        if(new BlockPos(8,0,2).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(new BlockPos(8,1,2).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(new BlockPos(8,0,3).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,8,-4,0,-4),
                    center(8,8,8,-4,-4,4)
            );
        }
        else if(new BlockPos(8,1,3).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,-4);
        }
        else if(new BlockPos(8,0,4).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,16,4,4,0)
            );
        }
        else if(new BlockPos(8,1,4).equals(posInMultiBlock)){
            return center(8,16,16,4,0,0);
        }
        else if(new BlockPos(8,0,5).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,8,-4,0,4),
                    center(8,8,8,-4,-4,-4)
            );
        }
        else if(new BlockPos(8,1,5).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(pX==8 && pZ==6 && pY>=0 && pY<=1){
            return center(8,16,8,-4,0,-4);
        }
        else if(new BlockPos(7,0,1).equals(posInMultiBlock)){
            return center(8,8,8,-4,-4,4);
        }
        else if(new BlockPos(7,0,2).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,8,4,4,4)
            );
        }
        else if(new BlockPos(7,0,7).equals(posInMultiBlock)){
            return center(8,8,8,-4,-4,-4);
        }
        else if(new BlockPos(7,0,6).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,16,0,-4,0),
                    center(8,8,8,4,4,-4)
            );
        }
        else if(new BlockPos(6,0,0).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(new BlockPos(6,1,0).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,4);
        }
        else if(new BlockPos(6,0,1).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,16,-4,0,0),
                    center(8,8,8,-4,4,-4)
            );
        }

        else if(new BlockPos(6,0,8).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,-4);
        }
        else if(new BlockPos(6,1,8).equals(posInMultiBlock)){
            return center(8,16,8,-4,0,-4);
        }
        else if(new BlockPos(6,0,7).equals(posInMultiBlock)){
            return Shapes.or(
                    center(8,16,16,-4,0,0),
                    center(8,8,8,-4,4,4)
            );
        }
        else if(new BlockPos(5,0,0).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,4),
                    center(8,8,8,4,4,4)
            );
        }
        else if(new BlockPos(5,0,1).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,-4),
                    center(8,8,8,4,4,-4)
            );
        }
        else if(new BlockPos(5,1,0).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BlockPos(5,1,1).equals(posInMultiBlock)){
            return center(8,16,8,4,0,-4);
        }

        else if(new BlockPos(5,0,8).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,-4),
                    center(8,8,8,4,4,-4)
            );
        }
        else if(new BlockPos(5,0,7).equals(posInMultiBlock)){
            return Shapes.or(
                    center(16,8,8,0,-4,4),
                    center(8,8,8,4,4,4)
            );
        }
        else if(new BlockPos(5,1,8).equals(posInMultiBlock)){
            return center(8,16,8,4,0,-4);
        }
        else if(new BlockPos(5,1,7).equals(posInMultiBlock)){
            return center(8,16,8,4,0,4);
        }
        else if(new BoundingBox(5,0,4,7,0,4).isInside(posInMultiBlock)){
            return center(16,8,8,0,0,0);
        }
        else if(pY == 2){
            if(new BlockPos(0,2,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            else if(new BlockPos(8,2,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            if(new BoundingBox(1,2,2,7,2,6).isInside(posInMultiBlock)){
                return center(16,8,16,0,-4,0);
            }
            else if(new BoundingBox(2,2,1,6,2,1).isInside(posInMultiBlock)){
                return center(16,8,16,0,-4,0);
            }
            else if(new BoundingBox(2,2,7,6,2,7).isInside(posInMultiBlock)){
                return center(16,8,16,0,-4,0);
            }

            else if(new BoundingBox(0,2,2,0,2,6).isInside(posInMultiBlock)){
                return center(8,16,16,4,0,0);
            }
            else if(new BoundingBox(8,2,2,8,2,6).isInside(posInMultiBlock)){
                return center(8,16,16,-4,0,0);
            }
            else if(new BoundingBox(2,2,0,6,2,0).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,4);
            }
            else if(new BoundingBox(2,2,8,6,2,8).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,-4);
            }
            else if(new BlockPos(1,2,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,4,0,-4)
                );
            }
            else if(new BlockPos(7,2,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,-4,0,-4)
                );
            }
            else if(new BlockPos(1,2,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,4,0,4)
                );
            }
            else if(new BlockPos(7,2,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,-4,0,4)
                );
            }
            else return Shapes.block();
        }
        else if (pY == 3){
            if(new BlockPos(0,3,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            else if(new BlockPos(8,3,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            if(new BoundingBox(4,3,1,4,3,7).isInside(posInMultiBlock)){
                return Shapes.empty();
            }
            else if(new BoundingBox(1,3,4,7,3,4).isInside(posInMultiBlock)){
                return Shapes.empty();
            }



            else if(new BoundingBox(0,3,2,0,3,6).isInside(posInMultiBlock)){
                return center(8,16,16,4,0,0);
            }
            else if(new BoundingBox(8,3,2,8,3,6).isInside(posInMultiBlock)){
                return center(8,16,16,-4,0,0);
            }
            else if(new BoundingBox(2,3,0,6,3,0).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,4);
            }
            else if(new BoundingBox(2,3,8,6,3,8).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,-4);
            }
            else if(new BlockPos(1,3,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,4,0,-4)
                );
            }
            else if(new BlockPos(7,3,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,-4,0,-4)
                );
            }
            else if(new BlockPos(1,3,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,4,0,4)
                );
            }
            else if(new BlockPos(7,3,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,-4,0,4)
                );
            }
            else return Shapes.block();
        }
        else if(pY == 4){
            if(new BlockPos(0,4,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            else if(new BlockPos(8,4,4).equals(posInMultiBlock)){
                return Shapes.block();
            }

             else if(new BoundingBox(0,4,2,0,4,6).isInside(posInMultiBlock)){
                return center(8,16,16,4,0,0);
            }
            else if(new BoundingBox(8,4,2,8,4,6).isInside(posInMultiBlock)){
                return center(8,16,16,-4,0,0);
            }
            else if(new BoundingBox(2,4,0,6,4,0).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,4);
            }
            else if(new BoundingBox(2,4,8,6,4,8).isInside(posInMultiBlock)){
                return center(16,16,8,0,0,-4);
            }
            else if(new BlockPos(1,4,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,4,0,-4)
                );
            }
            else if(new BlockPos(7,4,1).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,4),
                        center(8,16,8,-4,0,-4)
                );
            }
            else if(new BlockPos(1,4,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,4,0,4)
                );
            }
            else if(new BlockPos(7,4,7).equals(posInMultiBlock)){
                return Shapes.or(
                        center(16,16,8,0,0,-4),
                        center(8,16,8,-4,0,4)
                );
            }
            return Shapes.block();
        }
        else if(pY == 5){
            if(new BlockPos(4,5,4).equals(posInMultiBlock)){
                return Shapes.block();
            }
            else return center(16,4,16,0,6,0);
        }
        else return Shapes.block();
    }

    public VoxelShape center(double sizeX, double sizeY, double sizeZ, double offsetX, double offsetY, double offsetZ){
        double sx = sizeX/16;
        double sy= sizeY/16;
        double sz = sizeZ/16;
        double ox = offsetX/16;
        double oy = offsetY/16;
        double oz = offsetZ/16;
        return Shapes.box(ox+0.5-sx/2, oy+0.5-sy/2, oz+0.5-sz/2, ox+0.5+sx/2, oy+0.5+sy/2, oz+0.5+sz/2);
    }
}
