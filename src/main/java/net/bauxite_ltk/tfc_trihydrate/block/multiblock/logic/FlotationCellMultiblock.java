package net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic;

import blusunrize.immersiveengineering.api.multiblocks.ClientMultiblocks;
import blusunrize.immersiveengineering.common.blocks.multiblocks.IETemplateMultiblock;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class FlotationCellMultiblock extends IETemplateMultiblock {
    public FlotationCellMultiblock() {
        super(ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","multiblocks/flotation_cell"),
                FlotationCellLogic.MASTER_OFFSET, new BlockPos(2, 1, 3), new BlockPos(5, 5, 4),
                TFCTHMultiblockLogic.FLOTATION_CELL);
    }

    @Override
    public float getManualScale() {
        return 12;
    }

    @Override
    public void initializeClient(Consumer<ClientMultiblocks.MultiblockManualData> consumer){
        consumer.accept(new TFCTHMultiblockProperties(this, 2.5,1.5,1.5));
    }
}
