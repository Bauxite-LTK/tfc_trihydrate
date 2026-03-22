package net.bauxite_ltk.tfc_trihydrate.crafting;

import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.api.crafting.FluidTagInput;
import blusunrize.immersiveengineering.api.crafting.IERecipeSerializer;
import blusunrize.immersiveengineering.api.crafting.IESerializableRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
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

public class FlotationCellRecipeSerializer extends IERecipeSerializer<FlotationCellRecipe> {
    @Override
    public ItemStack getIcon() {
        return TFCTHMultiblockLogic.FLOTATION_CELL.iconStack();
    }

    @Override
    public FlotationCellRecipe readFromJson(ResourceLocation recipeId, JsonObject json, ICondition.IContext context) {
        FluidStack outputConcentrate = FluidStack.EMPTY;
        FluidStack outputTailing = FluidStack.EMPTY;
        FluidTagInput inputOre = null;
        FluidTagInput inputAdd = null;



        inputOre = FluidTagInput.deserialize(GsonHelper.getAsJsonObject(json, "input_ore"));
        inputAdd = FluidTagInput.deserialize(GsonHelper.getAsJsonObject(json, "input_add"));
        outputConcentrate = ApiUtils.jsonDeserializeFluidStack(GsonHelper.getAsJsonObject(json, "result_concentrate"));
        if(json.has("result_tailing"))
            outputTailing = ApiUtils.jsonDeserializeFluidStack(GsonHelper.getAsJsonObject(json, "result_tailing"));



        int time = GsonHelper.getAsInt(json, "time");
        int energy = GsonHelper.getAsInt(json, "energy");
        return new FlotationCellRecipe(recipeId, outputConcentrate, outputTailing, inputOre, inputAdd, time, energy);
    }

    @Override
    public @Nullable FlotationCellRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        FluidStack concentrate = buffer.readFluidStack();
        FluidStack tailing = buffer.readFluidStack();
        FluidTagInput ore = FluidTagInput.read(buffer);
        FluidTagInput add = FluidTagInput.read(buffer);
        int time = buffer.readInt();
        int energy = buffer.readInt();
        return new FlotationCellRecipe(recipeId, concentrate, tailing, ore, add, time, energy);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, FlotationCellRecipe recipe) {
        buffer.writeFluidStack(recipe.outputConcentrate);
        buffer.writeFluidStack(recipe.outputTailing);
        recipe.inputOre.write(buffer);
        recipe.inputAdd.write(buffer);
        buffer.writeInt(recipe.getTotalProcessTime());
        buffer.writeInt(recipe.getTotalProcessEnergy());

    }
}
