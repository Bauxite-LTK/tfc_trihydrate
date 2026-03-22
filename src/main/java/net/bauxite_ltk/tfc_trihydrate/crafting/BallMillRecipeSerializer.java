package net.bauxite_ltk.tfc_trihydrate.crafting;

import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.api.crafting.*;
import blusunrize.immersiveengineering.common.config.IEServerConfig;
import blusunrize.immersiveengineering.common.register.IEMultiblockLogic;
import com.google.gson.JsonObject;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class BallMillRecipeSerializer extends IERecipeSerializer<BallMillRecipe> {
    @Override
    public ItemStack getIcon() {
        return TFCTHMultiblockLogic.BALL_MILL.iconStack();
    }

    @Override
    public BallMillRecipe readFromJson(ResourceLocation recipeId, JsonObject json, ICondition.IContext context) {
        FluidStack fluidOutput = FluidStack.EMPTY;
        FluidTagInput fluidInput = null;
        Lazy<ItemStack> itemOutput = IESerializableRecipe.LAZY_EMPTY;

        if(json.has("input_fluid")){
            fluidInput = FluidTagInput.deserialize(GsonHelper.getAsJsonObject(json, "input_fluid"));
        }
        if(json.has("result_fluid"))
            fluidOutput = ApiUtils.jsonDeserializeFluidStack(GsonHelper.getAsJsonObject(json, "result_fluid"));

        if(json.has("result_item"))
            itemOutput = readOutput(json.get("result_item"));

        IngredientWithSize itemInput = IngredientWithSize.deserialize(json.get("input_item"));

        int time = GsonHelper.getAsInt(json, "time");
        int energy = GsonHelper.getAsInt(json, "energy");
        return new BallMillRecipe(recipeId, fluidOutput, itemOutput, fluidInput, itemInput, time, energy);
    }

    @Override
    public @Nullable BallMillRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        FluidStack fluidOutput = buffer.readFluidStack();
        FluidTagInput fluidInput = buffer.readBoolean()?FluidTagInput.read(buffer): null;
        Lazy<ItemStack> itemOutput = readLazyStack(buffer);
        IngredientWithSize itemInput = IngredientWithSize.read(buffer);
        int time = buffer.readInt();
        int energy = buffer.readInt();
        return new BallMillRecipe(recipeId, fluidOutput, itemOutput, fluidInput, itemInput, time, energy);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, BallMillRecipe recipe) {
        buffer.writeFluidStack(recipe.outputFluid);
        if(recipe.inputFluid!=null)
        {
            buffer.writeBoolean(true);
            recipe.inputFluid.write(buffer);
        }
        else
            buffer.writeBoolean(false);

        buffer.writeItem(recipe.outputItem.get());
        recipe.inputItem.write(buffer);
        buffer.writeInt(recipe.getTotalProcessTime());
        buffer.writeInt(recipe.getTotalProcessEnergy());

    }
}
