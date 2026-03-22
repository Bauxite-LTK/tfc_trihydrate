package net.bauxite_ltk.tfc_trihydrate.gui;

import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockState;
import blusunrize.immersiveengineering.common.gui.IEContainerMenu;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.BallMillLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.FlotationCellLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.HydrocycloneLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.ThickenerLogic;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.BallMillMenu;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.FlotationCellMenu;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.HydrocycloneMenu;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.ThickenerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TFCTHMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TFCTrihydrate.MODID);
    public static final MultiblockContainer<BallMillLogic.State, BallMillMenu> BALL_MILL = registerMultiblock(
            "ball_mill", BallMillMenu::makeServer, BallMillMenu::makeClient
    );

    public static final MultiblockContainer<FlotationCellLogic.State, FlotationCellMenu> FLOTATION_CELL = registerMultiblock(
            "flotation_cell", FlotationCellMenu::makeServer, FlotationCellMenu::makeClient
    );

    public static final MultiblockContainer<HydrocycloneLogic.State, HydrocycloneMenu> HYDROCYCLONE = registerMultiblock(
            "hydrocyclone", HydrocycloneMenu::makeServer, HydrocycloneMenu::makeClient
    );

    public static final MultiblockContainer<ThickenerLogic.State, ThickenerMenu> THICKENER = registerMultiblock(
            "thickener", ThickenerMenu::makeServer, ThickenerMenu::makeClient
    );


    public static <S extends IMultiblockState, C extends IEContainerMenu>
    MultiblockContainer<S, C> registerMultiblock(
            String name,
            ArgContainerConstructor<IEContainerMenu.MultiblockMenuContext<S>, C> container,
            ClientContainerConstructor<C> client
    )
    {
        RegistryObject<MenuType<C>> typeRef = registerType(name, client);
        return new MultiblockContainer<>(typeRef, container);
    }

    private static <C extends IEContainerMenu>
    RegistryObject<MenuType<C>> registerType(String name, ClientContainerConstructor<C> client)
    {
        return REGISTER.register(
                name, () -> {
                    Mutable<MenuType<C>> typeBox = new MutableObject<>();
                    MenuType<C> type = new MenuType<>((id, inv) -> client.construct(typeBox.getValue(), id, inv), FeatureFlagSet.of());
                    typeBox.setValue(type);
                    return type;
                }
        );
    }

    public static class ArgContainer<T, C extends IEContainerMenu>
    {
        private final RegistryObject<MenuType<C>> type;
        private final ArgContainerConstructor<T, C> factory;

        private ArgContainer(RegistryObject<MenuType<C>> type, ArgContainerConstructor<T, C> factory)
        {
            this.type = type;
            this.factory = factory;
        }

        public C create(int windowId, Inventory playerInv, T tile)
        {
            return factory.construct(getType(), windowId, playerInv, tile);
        }

        public MenuProvider provide(T arg)
        {
            return new MenuProvider()
            {
                @Nonnull
                @Override
                public Component getDisplayName()
                {
                    return Component.empty();
                }

                @Nullable
                @Override
                public AbstractContainerMenu createMenu(
                        int containerId, @Nonnull Inventory inventory, @Nonnull Player player
                )
                {
                    return create(containerId, inventory, arg);
                }
            };
        }

        public MenuType<C> getType()
        {
            return type.get();
        }
    }
    

    public static class MultiblockContainer<S extends IMultiblockState, C extends IEContainerMenu> extends
            ArgContainer<IEContainerMenu.MultiblockMenuContext<S>, C>
    {
        private MultiblockContainer(
                RegistryObject<MenuType<C>> type,
                ArgContainerConstructor<IEContainerMenu.MultiblockMenuContext<S>, C> factory
        )
        {
            super(type, factory);
        }

        public MenuProvider provide(IMultiblockContext<S> ctx, BlockPos relativeClicked)
        {
            return provide(new IEContainerMenu.MultiblockMenuContext<>(ctx, ctx.getLevel().toAbsolute(relativeClicked)));
        }
    }

    public record ItemContainerType<C extends AbstractContainerMenu>(
            RegistryObject<MenuType<C>> type, ItemContainerConstructor<C> factory
    )
    {
        public C create(int id, Inventory inv, Level w, EquipmentSlot slot, ItemStack stack)
        {
            return factory.construct(getType(), id, inv, w, slot, stack);
        }

        public MenuType<C> getType()
        {
            return type.get();
        }
    }

    public record ItemContainerTypeNew<C extends AbstractContainerMenu>(
            RegistryObject<MenuType<C>> type, NewItemContainerConstructor<C> factory
    )
    {
        public C create(int id, Inventory inv, EquipmentSlot slot, ItemStack stack)
        {
            return factory.construct(getType(), id, inv, slot, stack);
        }

        public MenuType<C> getType()
        {
            return type.get();
        }
    }

    public interface ArgContainerConstructor<T, C extends IEContainerMenu>
    {
        C construct(MenuType<C> type, int windowId, Inventory inventoryPlayer, T te);
    }

    public interface ClientContainerConstructor<C extends IEContainerMenu>
    {
        C construct(MenuType<C> type, int windowId, Inventory inventoryPlayer);
    }

    public interface ItemContainerConstructor<C extends AbstractContainerMenu>
    {
        C construct(MenuType<C> type, int windowId, Inventory inventoryPlayer, Level world, EquipmentSlot slot, ItemStack stack);
    }

    public interface NewItemContainerConstructor<C extends AbstractContainerMenu>
    {
        C construct(MenuType<C> type, int windowId, Inventory inventoryPlayer, EquipmentSlot slot, ItemStack stack);
    }

    public interface SimpleContainerConstructor<C extends AbstractContainerMenu>
    {
        C construct(MenuType<?> type, int windowId, Inventory inventoryPlayer);
    }

    public static void init(IEventBus modEventBus){
        REGISTER.register(modEventBus);
    }
}
