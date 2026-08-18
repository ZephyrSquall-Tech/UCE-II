package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes;

import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe.EngineeringTableRecipe;
import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe.EngineeringTableRecipeSerializer;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Recipe serializer registry (M1-B).
 */
public final class ModRecipeSerializers {
    private ModRecipeSerializers() {}

    /** Serializer for shaped Engineering Table recipes (delegates to vanilla ShapedRecipe codec + xmap wrapper). */
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EngineeringTableRecipe>> SHAPED =
            ModRegistries.RECIPE_SERIALIZERS.register("engineering_table_shaped", () -> new EngineeringTableRecipeSerializer());

    public static void register() {
        // Touch the static field to force class initialization (DeferredRegister.register happens during static init)
        DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EngineeringTableRecipe>> ignored = SHAPED;
    }
}