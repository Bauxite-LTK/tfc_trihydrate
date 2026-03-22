package net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic;

import blusunrize.immersiveengineering.api.multiblocks.ClientMultiblocks;
import blusunrize.immersiveengineering.common.blocks.multiblocks.IETemplateMultiblock;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.data.ModelData;


import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.bauxite_ltk.tfc_trihydrate.render.BallMillRender.BARREL;


public class BallMillMultiblock extends IETemplateMultiblock {

    public static final BallMillMultiblock INSTANCE = new BallMillMultiblock();

    public BallMillMultiblock() {
        super(ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","multiblocks/ball_mill"),
                BallMillLogic.MASTER_OFFSET, new BlockPos(3, 1, 2), new BlockPos(7, 3, 3),
                TFCTHMultiblockLogic.BALL_MILL);
    }

    @Override
    public float getManualScale() {
        return 12;
    }

    @Override
    public void initializeClient(Consumer<ClientMultiblocks.MultiblockManualData> consumer){
        consumer.accept(new BallMillMultiblockProperties());
    }



    public static class BallMillMultiblockProperties extends TFCTHMultiblockProperties{
        public BallMillMultiblockProperties(){
            super(INSTANCE, 3.5, 1.5, 1.5);
        }

        @Override
        public void renderExtras(PoseStack matrix, MultiBufferSource buffer){
            matrix.pushPose();
            matrix.translate(-0.5, -0.5, -0.5);
            renderObj(buffer, matrix);
            matrix.popPose();
        }

        private static void renderObj(@Nonnull MultiBufferSource bufferIn, @Nonnull PoseStack matrix){
            final BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
            BakedModel model = BARREL.get();
            PoseStack.Pose last = matrix.last();
            VertexConsumer solid = bufferIn.getBuffer(RenderType.solid());

            blockRenderer.getModelRenderer().renderModel(
                    last, solid, null, model,
                    1, 1, 1,
                    LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY , ModelData.EMPTY, RenderType.solid()
            );

        }
    }
}
