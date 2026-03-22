package net.bauxite_ltk.tfc_trihydrate.block.multiblock;

import blusunrize.immersiveengineering.ImmersiveEngineering;
import blusunrize.immersiveengineering.api.multiblocks.blocks.MultiblockRegistration;
import blusunrize.immersiveengineering.api.multiblocks.blocks.MultiblockRegistrationBuilder;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.ComparatorManager;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.IMultiblockComponent;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.RedstoneControl;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockLogic;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockState;
import blusunrize.immersiveengineering.common.blocks.multiblocks.component.MultiblockGui;

import blusunrize.immersiveengineering.common.register.IEMenuTypes;
import com.google.common.base.Preconditions;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.gui.TFCTHMenuTypes;
import net.bauxite_ltk.tfc_trihydrate.gui.TFCTHMultiblockGui;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TFCTHMultiblockBuilder<S extends IMultiblockState>
        extends MultiblockRegistrationBuilder<S, TFCTHMultiblockBuilder<S>>
{


    public TFCTHMultiblockBuilder(IMultiblockLogic<S> logic, String name)
    {
        super(logic, ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,name));
    }

    public TFCTHMultiblockBuilder<S> gui(TFCTHMenuTypes.MultiblockContainer<S, ?> menu)
    {
        return component(new TFCTHMultiblockGui<>(menu));
    }

    public TFCTHMultiblockBuilder<S> redstoneNoComputer(IMultiblockComponent.StateWrapper<S, RedstoneControl.RSState> getState, BlockPos... positions)
    {
        redstoneAware();
        return selfWrappingComponent(new RedstoneControl<>(getState, false, positions));
    }

    public TFCTHMultiblockBuilder<S> redstone(IMultiblockComponent.StateWrapper<S, RedstoneControl.RSState> getState, BlockPos... positions)
    {
        redstoneAware();
        return selfWrappingComponent(new RedstoneControl<>(getState, positions));
    }

    public TFCTHMultiblockBuilder<S> comparator(ComparatorManager<S> comparator)
    {
        withComparator();
        return super.selfWrappingComponent(comparator);
    }

    public MultiblockRegistration<S> build()
    {
        return super.build();
    }


    @Override
    public <CS, C extends IMultiblockComponent<CS> & IMultiblockComponent.StateWrapper<S, CS>>
    TFCTHMultiblockBuilder<S> selfWrappingComponent(C extraComponent)
    {
        Preconditions.checkArgument(!(extraComponent instanceof ComparatorManager<?>));
        return super.selfWrappingComponent(extraComponent);
    }

    @Override
    protected TFCTHMultiblockBuilder<S> self()
    {
        return this;
    }
}

