package net.bauxite_ltk.tfc_trihydrate.block.multiblock;

import blusunrize.immersiveengineering.api.multiblocks.blocks.MultiblockRegistration;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockLogic;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockState;
import blusunrize.immersiveengineering.common.register.IEBlocks;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.*;
import net.bauxite_ltk.tfc_trihydrate.gui.TFCTHMenuTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TFCTHMultiblockLogic {
    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(
            BuiltInRegistries.BLOCK, TFCTrihydrate.MODID
    );
    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(
            BuiltInRegistries.ITEM, TFCTrihydrate.MODID
    );
    private static final DeferredRegister<BlockEntityType<?>> BE_REGISTER = DeferredRegister.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, TFCTrihydrate.MODID
    );

    public static final MultiblockRegistration<BallMillLogic.State> BALL_MILL =
            metal(new BallMillLogic(), "ball_mill")
            .structure(() -> TFCTHMultiblocks.BALL_MILL)
            .gui(TFCTHMenuTypes.BALL_MILL)
            .redstone(s -> s.rsState, BallMillLogic.REDSTONE_POS)
            .comparator(BallMillLogic.makeComparator())
            .build();

    public static final MultiblockRegistration<FlotationCellLogic.State> FLOTATION_CELL =
            metal(new FlotationCellLogic(), "flotation_cell")
            .structure(() -> TFCTHMultiblocks.FLOTATION_CELL)
            .gui(TFCTHMenuTypes.FLOTATION_CELL)
            .redstone(s -> s.rsState, FlotationCellLogic.REDSTONE_POS)
            .build();

    public static final MultiblockRegistration<HydrocycloneLogic.State> HYDROCYCLONE =
            metal(new HydrocycloneLogic(), "hydrocyclone")
                    .structure(() -> TFCTHMultiblocks.HYDROCYCLONE)
                    .gui(TFCTHMenuTypes.HYDROCYCLONE)
                    .redstone(s -> s.rsState, HydrocycloneLogic.REDSTONE_POS)
                    .build();

    public static final MultiblockRegistration<ThickenerLogic.State> THICKENER =
            metal(new ThickenerLogic(), "thickener")
                    .structure(() -> TFCTHMultiblocks.THICKENER)
                    .gui(TFCTHMenuTypes.THICKENER)
                    .redstone(s -> s.rsState, ThickenerLogic.REDSTONE_POS)
                    .build();

    private static <S extends IMultiblockState>
    TFCTHMultiblockBuilder<S> metal(IMultiblockLogic<S> logic, String name)
    {
        return new TFCTHMultiblockBuilder<>(logic, name)
                .defaultBEs(BE_REGISTER)
                .defaultBlock(BLOCK_REGISTER, ITEM_REGISTER, IEBlocks.METAL_PROPERTIES_NO_OCCLUSION.get());
    }

    public static void init(IEventBus bus)
    {
        BLOCK_REGISTER.register(bus);
        ITEM_REGISTER.register(bus);
        BE_REGISTER.register(bus);
        TFCTHMultiblockBuilder.handleModBusRegistrations(bus);
    }
}
