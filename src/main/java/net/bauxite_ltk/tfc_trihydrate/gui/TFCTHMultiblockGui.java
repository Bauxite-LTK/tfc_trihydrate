package net.bauxite_ltk.tfc_trihydrate.gui;

import blusunrize.immersiveengineering.api.multiblocks.blocks.component.IMultiblockComponent;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

public record TFCTHMultiblockGui<S extends IMultiblockState>(
		TFCTHMenuTypes.MultiblockContainer<S, ?> menu) implements IMultiblockComponent<S>
{
	@Override
	public InteractionResult click(
			IMultiblockContext<S> ctx,
			BlockPos posInMultiblock,
			Player player,
			InteractionHand hand,
			BlockHitResult absoluteHit,
			boolean isClient
	)
	{
		if(!isClient)
			player.openMenu(menu.provide(ctx, posInMultiblock));
		return InteractionResult.SUCCESS;
	}
}