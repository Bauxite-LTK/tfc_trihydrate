package net.bauxite_ltk.tfc_trihydrate.gui.menus;

import blusunrize.immersiveengineering.api.energy.IMutableEnergyStorage;
import blusunrize.immersiveengineering.api.energy.MutableEnergyStorage;
import blusunrize.immersiveengineering.common.gui.IEContainerMenu;
import blusunrize.immersiveengineering.common.gui.sync.GenericContainerData;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.FlotationCellLogic;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

public class FlotationCellMenu extends IEContainerMenu {
    public final IMutableEnergyStorage energy;
    public final FlotationCellLogic.FlotationCellTanks tanks;

    public static FlotationCellMenu makeServer(
            MenuType<?> type, int id, Inventory invPlayer, MultiblockMenuContext<FlotationCellLogic.State> ctx
    )
    {
        final FlotationCellLogic.State state = ctx.mbContext().getState();
        return new FlotationCellMenu(
                multiblockCtx(type, id, ctx), invPlayer, state.getEnergy(), state.tanks
        );
    }

    public static FlotationCellMenu makeClient(MenuType<?> type, int id, Inventory invPlayer)
    {
        return new FlotationCellMenu(
                clientCtx(type, id),
                invPlayer,
                new MutableEnergyStorage(FlotationCellLogic.ENERGY_CAPACITY),
                new FlotationCellLogic.FlotationCellTanks()
        );
    }


    protected FlotationCellMenu(
            MenuContext ctx,
            Inventory inventoryPlayer, IMutableEnergyStorage energy, FlotationCellLogic.FlotationCellTanks tanks) {
        super(ctx);
        this.energy = energy;
        this.tanks = tanks;

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 9; j++)
                addSlot(new Slot(inventoryPlayer, j+i*9+9, 8+j*18, 85+i*18));
        for(int i = 0; i < 9; i++)
            addSlot(new Slot(inventoryPlayer, i, 8+i*18, 143));
        addGenericData(GenericContainerData.energy(energy));
        addGenericData(GenericContainerData.fluid(tanks.inputOre()));
        addGenericData(GenericContainerData.fluid(tanks.inputAdd()));
        addGenericData(GenericContainerData.fluid(tanks.outputConcentrate()));
        addGenericData(GenericContainerData.fluid(tanks.outputTailing()));
        addGenericData(GenericContainerData.fluid(tanks.overflow()));
    }
}
