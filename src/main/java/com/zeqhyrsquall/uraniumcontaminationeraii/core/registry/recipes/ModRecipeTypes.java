package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes;


import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe.EngineeringTableRecipe;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Recipe type registry (M1-B §2.2.3).
 *
 * <p>Only ENGINEERING_TABLE exists in M1-B; future phases add PART_ASSEMBLY / CIRCUIT_BOARD_ASSEMBLY etc.</p>
 */
public class ModRecipeTypes {
    private ModRecipeTypes() {}

    /** Custom recipe type: recipes only craftable in the Engineering Table Menu. */
    public static final DeferredHolder<RecipeType<?>, RecipeType<EngineeringTableRecipe>> ENGINEERING_TABLE =
            ModRegistries.RECIPE_TYPES.register("engineering_table", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "ENGINEERING_TABLE";
                }
            });


    /** Called centrally by {@link ModRegistries#register}; do not call directly. */
    public static void register() {
        // Touch the static field to force class initialization (DeferredRegister.register happens during static init)
        DeferredHolder<RecipeType<?>, RecipeType<EngineeringTableRecipe>> ignored = ENGINEERING_TABLE;
    }
}
