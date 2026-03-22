package net.bauxite_ltk.tfc_trihydrate.crafting;

import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.api.crafting.FluidTagInput;
import blusunrize.immersiveengineering.api.crafting.IERecipeSerializer;
import blusunrize.immersiveengineering.api.crafting.IESerializableRecipe;
import com.google.gson.JsonObject;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class ThickenerRecipeSerializer extends IERecipeSerializer<ThickenerRecipe> {
    @Override
    public ItemStack getIcon() {
        return TFCTHMultiblockLogic.THICKENER.iconStack();
    }

    @Override
    public ThickenerRecipe readFromJson(ResourceLocation recipeId, JsonObject json, ICondition.IContext context) {
        FluidStack fluidOutput = FluidStack.EMPTY;
        FluidTagInput fluidInput = null;
        Lazy<ItemStack> itemOutput = IESerializableRecipe.LAZY_EMPTY;

        fluidInput = FluidTagInput.deserialize(GsonHelper.getAsJsonObject(json, "input_fluid"));

        fluidOutput = ApiUtils.jsonDeserializeFluidStack(GsonHelper.getAsJsonObject(json, "result_fluid"));

        itemOutput = readOutput(json.get("result_item"));

        int energy = GsonHelper.getAsInt(json, "energy");
        return new ThickenerRecipe(recipeId, fluidOutput, itemOutput, fluidInput, energy);
    }

    @Override
    public @Nullable ThickenerRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        FluidStack fluidOutput = buffer.readFluidStack();
        Lazy<ItemStack> itemOutput = readLazyStack(buffer);
        FluidTagInput fluidInput = FluidTagInput.read(buffer);
        int energy = buffer.readInt();
        return new ThickenerRecipe(recipeId, fluidOutput, itemOutput, fluidInput, energy);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, ThickenerRecipe recipe) {
        buffer.writeFluidStack(recipe.outputFluid);
        buffer.writeItem(recipe.outputItem.get());
        recipe.inputFluid.write(buffer);
        buffer.writeInt(recipe.getTotalProcessEnergy());

    }
}
