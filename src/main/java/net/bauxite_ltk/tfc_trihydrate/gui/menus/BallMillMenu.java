package net.bauxite_ltk.tfc_trihydrate.gui.menus;

import blusunrize.immersiveengineering.api.energy.IMutableEnergyStorage;
import blusunrize.immersiveengineering.api.energy.MutableEnergyStorage;
import blusunrize.immersiveengineering.common.gui.IEContainerMenu;
import blusunrize.immersiveengineering.common.gui.IESlot;
import blusunrize.immersiveengineering.common.gui.sync.GenericContainerData;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.BallMillLogic;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BallMillMenu extends IEContainerMenu {
    public final IMutableEnergyStorage energy;
    public final BallMillLogic.BallMillTanks tanks;

    public static BallMillMenu makeServer(
            MenuType<?> type, int id, Inventory invPlayer, MultiblockMenuContext<BallMillLogic.State> ctx
    )
    {
        final BallMillLogic.State state = ctx.mbContext().getState();
        return new BallMillMenu(
                multiblockCtx(type, id, ctx), invPlayer, state.getInventory(), state.getEnergy(), state.tanks
        );
    }

    public static BallMillMenu makeClient(MenuType<?> type, int id, Inventory invPlayer)
    {
        return new BallMillMenu(
                clientCtx(type, id),
                invPlayer,
                new ItemStackHandler(BallMillLogic.NUM_SLOTS),
                new MutableEnergyStorage(BallMillLogic.ENERGY_CAPACITY),
                new BallMillLogic.BallMillTanks()
        );
    }


    protected BallMillMenu(
            MenuContext ctx,
            Inventory inventoryPlayer, IItemHandler inv, IMutableEnergyStorage energy, BallMillLogic.BallMillTanks tanks) {
        super(ctx);
        this.energy = energy;
        this.tanks = tanks;

        for(int i = 0; i < 8; i++)
            this.addSlot(new SlotItemHandler(inv, i, 37+(i%4)*18, 19+(i/4)*18));
        this.addSlot(new IESlot.NewOutput(inv, 8, 138, 53));
        ownSlotCount = 9;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 9; j++)
                addSlot(new Slot(inventoryPlayer, j+i*9+9, 8+j*18, 85+i*18));
        for(int i = 0; i < 9; i++)
            addSlot(new Slot(inventoryPlayer, i, 8+i*18, 143));
        addGenericData(GenericContainerData.energy(energy));
        addGenericData(GenericContainerData.fluid(tanks.input()));
        addGenericData(GenericContainerData.fluid(tanks.output()));

    }
}
