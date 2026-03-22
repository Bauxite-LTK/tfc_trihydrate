package net.bauxite_ltk.tfc_trihydrate.render;

import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockBEHelperMaster;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.registry.MultiblockBlockEntityMaster;
import blusunrize.immersiveengineering.api.multiblocks.blocks.util.MultiblockOrientation;
import blusunrize.immersiveengineering.client.render.tile.BERenderUtils;
import blusunrize.immersiveengineering.client.render.tile.IEBlockEntityRenderer;

import blusunrize.immersiveengineering.client.utils.GuiHelper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.FlotationCellLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.ThickenerLogic;
import net.bauxite_ltk.tfc_trihydrate.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.fluids.FluidStack;

import org.jetbrains.annotations.NotNull;

public class ThickenerRender extends IEBlockEntityRenderer<MultiblockBlockEntityMaster<ThickenerLogic.State>> {
    public static final String NAME = "thickener_agitator";
    public static TFCTHDynamicModel AGITATOR;
    private FluidStack currentOutput = null;


    @Override
    public void render(MultiblockBlockEntityMaster<ThickenerLogic.State> te, float partialTicks, @NotNull PoseStack matrixStack, @NotNull MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        final BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BakedModel model = AGITATOR.get();
        final IMultiblockBEHelperMaster<ThickenerLogic.State> helper = te.getHelper();
        final MultiblockOrientation orientation = helper.getContext().getLevel().getOrientation();

        matrixStack.pushPose();
        bufferIn = BERenderUtils.mirror(orientation, matrixStack, bufferIn);
        VertexConsumer buffer = bufferIn.getBuffer(RenderType.solid());
        rotateForFacing(matrixStack, orientation.front());

        boolean active = helper.getState().shouldRenderActive();
        float agitatorAngle = helper.getState().getAgitatorAngle()+ (active? 1.5f * partialTicks: 0);

        Helper.applyRotationY(8,8,agitatorAngle,matrixStack);



        blockRenderer.getModelRenderer().renderModel(
                matrixStack.last(), buffer, null, model,
                1, 1, 1,
                combinedLightIn, combinedOverlayIn, ModelData.EMPTY, RenderType.solid()
        );

        matrixStack.popPose();


        ThickenerLogic.ThickenerTanks tanks = helper.getState().tanks;
        FluidStack outputFluid = tanks.output().getFluid();
        FluidStack ore = tanks.input().getFluid();

        if(!outputFluid.isEmpty()) {
            if(currentOutput==null){
                currentOutput = new FluidStack(outputFluid.getFluid(),1000);
            }
            else if(!currentOutput.getFluid().equals(outputFluid.getFluid())){
                currentOutput = new FluidStack(outputFluid.getFluid(),1000);
            }
        }

        int maxHeight = 31;
        float capacity = (float)(tanks.input().getCapacity() + tanks.output().getCapacity());
        float oreHeight = 1 + (float) maxHeight * ore.getAmount() / capacity;
        float outputHeight = 1 + oreHeight + (float) maxHeight * Math.max(outputFluid.getAmount(),1000) / capacity;

//        TFCTrihydrate.LOGGER.info("OreHeight: " + oreHeight);
//        TFCTrihydrate.LOGGER.info("Ore: " + ore);

        if(!ore.isEmpty()){
            renderFluidLayerXZ(
                    matrixStack,orientation,bufferIn,
                    ore,
                    -48,46,-31,112,78,
                    Math.round(oreHeight));
            renderFluidLayerXZ(
                    matrixStack,orientation,bufferIn,
                    ore,
                    -38,46,-41,92,10,
                    Math.round(oreHeight));
            renderFluidLayerXZ(
                    matrixStack,orientation,bufferIn,
                    ore,
                    -28,46,-51,72,10,
                    Math.round(oreHeight));
            renderFluidLayerXZ(
                    matrixStack,orientation,bufferIn,
                    ore,
                    -38,46,47,92,10,
                    Math.round(oreHeight));
            renderFluidLayerXZ(
                    matrixStack,orientation,bufferIn,
                    ore,
                    -28,46,57,72,10,
                    Math.round(oreHeight));
        }
        if (currentOutput != null) {
            if(helper.getState().shouldRenderActive() || !outputFluid.isEmpty()){
                renderFluidLayerXZ(
                        matrixStack,orientation,bufferIn,
                        currentOutput,
                        -48,46,-31,112,78,
                        Math.round(outputHeight));
                renderFluidLayerXZ(
                        matrixStack,orientation,bufferIn,
                        currentOutput,
                        -38,46,-41,92,10,
                        Math.round(outputHeight));
                renderFluidLayerXZ(
                        matrixStack,orientation,bufferIn,
                        currentOutput,
                        -28,46,-51,72,10,
                        Math.round(outputHeight));
                renderFluidLayerXZ(
                        matrixStack,orientation,bufferIn,
                        currentOutput,
                        -38,46,47,92,10,
                        Math.round(outputHeight));
                renderFluidLayerXZ(
                        matrixStack,orientation,bufferIn,
                        currentOutput,
                        -28,46,57,72,10,
                        Math.round(outputHeight));
            }
        }

    }

    private static void renderFluidLayerXZ(
            PoseStack matrixStack,
            MultiblockOrientation orientation,
            MultiBufferSource bufferIn,
            FluidStack fluidStack,
            float tx, float ty, float tz,
            float w, float h,
            int height)
    {
        float baseScale = .0625f;
        matrixStack.pushPose();
        rotateForFacing(matrixStack, orientation.front());
        matrixStack.scale(baseScale, baseScale, baseScale);
        matrixStack.translate(tx,ty,tz);
        matrixStack.translate(0, height,0);
        Helper.applyRotationX(0,0,90,matrixStack);
        GuiHelper.drawRepeatedFluidSprite(bufferIn.getBuffer(RenderType.translucent()), matrixStack, fluidStack,
                0, 0, w, h);
        matrixStack.popPose();
    }
}
