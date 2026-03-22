package net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic;

import blusunrize.immersiveengineering.api.multiblocks.ClientMultiblocks;
import blusunrize.immersiveengineering.common.blocks.multiblocks.IETemplateMultiblock;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class HydrocycloneMultiblock extends IETemplateMultiblock {
    public HydrocycloneMultiblock() {
        super(ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","multiblocks/hydrocyclone"),
                HydrocycloneLogic.MASTER_OFFSET, new BlockPos(1, 1, 2), new BlockPos(3, 3, 3),
                TFCTHMultiblockLogic.HYDROCYCLONE);
    }

    @Override
    public float getManualScale() {
        return 16;
    }

    @Override
    public void initializeClient(Consumer<ClientMultiblocks.MultiblockManualData> consumer){
        consumer.accept(new TFCTHMultiblockProperties(this, 1.5,1.5,1.5));
    }
}
