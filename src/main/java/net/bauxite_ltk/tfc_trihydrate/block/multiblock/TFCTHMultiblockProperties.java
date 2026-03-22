package net.bauxite_ltk.tfc_trihydrate.block.multiblock;

import blusunrize.immersiveengineering.api.multiblocks.ClientMultiblocks;
import blusunrize.immersiveengineering.common.blocks.multiblocks.IETemplateMultiblock;
import blusunrize.immersiveengineering.common.util.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.ModelData;

import javax.annotation.Nullable;
import java.util.*;

public class TFCTHMultiblockProperties implements ClientMultiblocks.MultiblockManualData{

    private final IETemplateMultiblock multiblock;
    @Nullable
    private NonNullList<ItemStack> materials;
    private final ItemStack renderStack;
    @Nullable
    private final Vec3 renderOffset;

    public TFCTHMultiblockProperties(IETemplateMultiblock multiblock){
        this(multiblock, null);
    }

    public TFCTHMultiblockProperties(IETemplateMultiblock multiblock, double offX, double offY, double offZ){
        this(multiblock, new Vec3(offX, offY, offZ));
    }

    private TFCTHMultiblockProperties(IETemplateMultiblock multiblock, @Nullable Vec3 renderOffset){
        this.multiblock = multiblock;
        this.renderStack = new ItemStack(multiblock.getBlock());
        this.renderOffset = renderOffset;
    }

    /** Skipping normal rendering behaviour */
    protected boolean usingCustomRendering(){
        return false;
    }

    @Override
    public NonNullList<ItemStack> getTotalMaterials(){
        // TODO (malte): Add helper for this to IE API
        if(this.materials == null){
            List<StructureTemplate.StructureBlockInfo> structure = this.multiblock.getStructure(Minecraft.getInstance().level);
            this.materials = NonNullList.create();
            for(StructureTemplate.StructureBlockInfo info: structure){
                ItemStack picked = Utils.getPickBlock(info.state());
                boolean added = false;
                for(ItemStack existing: this.materials)
                    if(ItemStack.isSameItem(existing, picked)){
                        existing.grow(1);
                        added = true;
                        break;
                    }
                if(!added)
                    this.materials.add(picked.copy());
            }
        }
        return this.materials;
    }

    @Override
    public boolean canRenderFormedStructure(){
        return this.renderOffset != null;
    }

    /** Allowing custom accessories to be rendered. Unused if {@link #usingCustomRendering()} returns true */
    public void renderExtras(PoseStack matrix, MultiBufferSource buffer){
    }

    /** Only used when {@link #usingCustomRendering()} returns true */
    public void renderCustomFormedStructure(PoseStack matrix, MultiBufferSource buffer){
    }

    @Override
    public final void renderFormedStructure(PoseStack matrix, MultiBufferSource buffer){
        Objects.requireNonNull(this.renderOffset);

        if(usingCustomRendering()){
            renderCustomFormedStructure(matrix, buffer);
            return;
        }

        matrix.translate(this.renderOffset.x, this.renderOffset.y, this.renderOffset.z);
        Minecraft.getInstance().getItemRenderer().renderStatic(this.renderStack, ItemDisplayContext.NONE, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, matrix, buffer, Minecraft.getInstance().level, 0);
        matrix.pushPose();
        {
            renderExtras(matrix, buffer);
        }
        matrix.popPose();
    }
}
