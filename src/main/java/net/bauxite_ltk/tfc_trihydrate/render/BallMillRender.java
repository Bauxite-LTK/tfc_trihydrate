package net.bauxite_ltk.tfc_trihydrate.render;

import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockBEHelperMaster;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.registry.MultiblockBlockEntityMaster;
import blusunrize.immersiveengineering.api.multiblocks.blocks.util.MultiblockOrientation;
import blusunrize.immersiveengineering.client.render.tile.BERenderUtils;
import blusunrize.immersiveengineering.client.render.tile.IEBlockEntityRenderer;

import blusunrize.immersiveengineering.common.blocks.multiblocks.logic.SqueezerLogic;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.BallMillLogic;
import net.bauxite_ltk.tfc_trihydrate.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;

public class BallMillRender extends IEBlockEntityRenderer<MultiblockBlockEntityMaster<BallMillLogic.State>> {
    public static final String NAME = "ball_mill_barrel";
    public static TFCTHDynamicModel BARREL;


    @Override
    public void render(MultiblockBlockEntityMaster<BallMillLogic.State> te, float partialTicks, @NotNull PoseStack matrixStack, @NotNull MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        final BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BakedModel model = BARREL.get();
        final IMultiblockBEHelperMaster<BallMillLogic.State> helper = te.getHelper();
        final MultiblockOrientation orientation = helper.getContext().getLevel().getOrientation();

        matrixStack.pushPose();

        bufferIn = BERenderUtils.mirror(orientation, matrixStack, bufferIn);
        VertexConsumer buffer = bufferIn.getBuffer(RenderType.solid());
        rotateForFacing(matrixStack, orientation.front());

        boolean active = helper.getState().shouldRenderActive();
        float barrelAngle = helper.getState().getBarrelAngle()+ (active? 9 * partialTicks: 0);

        Helper.applyRotationX(14,0,barrelAngle,matrixStack);



        blockRenderer.getModelRenderer().renderModel(
                matrixStack.last(), buffer, null, model,
                1, 1, 1,
                combinedLightIn, combinedOverlayIn, ModelData.EMPTY, RenderType.solid()
        );

        matrixStack.popPose();
    }
}
