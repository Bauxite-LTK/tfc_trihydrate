package net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic;

import blusunrize.immersiveengineering.api.multiblocks.ClientMultiblocks;
import blusunrize.immersiveengineering.common.blocks.multiblocks.IETemplateMultiblock;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class ThickenerMultiblock extends IETemplateMultiblock {
    public ThickenerMultiblock() {
        super(ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","multiblocks/thickener"),
                ThickenerLogic.MASTER_OFFSET, new BlockPos(4, 1, 8), new BlockPos(9, 8, 9),
                TFCTHMultiblockLogic.THICKENER);
    }

    @Override
    public float getManualScale() {
        return 8;
    }

    @Override
    public void initializeClient(Consumer<ClientMultiblocks.MultiblockManualData> consumer){
        consumer.accept(new TFCTHMultiblockProperties(this, 4.5,0.5,4.5));
    }
}
