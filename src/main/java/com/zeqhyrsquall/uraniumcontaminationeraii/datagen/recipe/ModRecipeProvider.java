// Ref: No.06 Data Generation · No.16 Recipes
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.recipe;

import java.util.concurrent.CompletableFuture;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe.EngineeringTableRecipeBuilder;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components.ModComponentItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

/**
 * Recipe generator.
 *
 * <p>M1-B scope:</p>
 * <ul>
 *   <li>§1.5: 5 ore nuggets -> furnace -> 5 ingots (copper/iron ingots use vanilla)</li>
 *   <li>§2.2.1: 5 plates (1 ingot -> 1 plate) + 5 rods (1 plate -> 2 rods) + 5 wires (1 rod -> 2 wires)</li>
 *   <li>§2.2.2: 2 alloy ingots (bronze = 3Cu+1Sn, brass = 2Cu+1Zn) — simplified M1-B crafting; M1-C moves to alloy furnace</li>
 *   <li>§1.4: 4 component recipes (clay substrate / electronic component / basic circuit board / CtI motor)</li>
 * </ul>
 *
 * <p>All plate/rod/wire/alloy/component recipes are routed through the custom ENGINEERING_TABLE RecipeType;
 * they are NOT craftable in the vanilla 3x3 crafting table.</p>
 */
public final class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // §1.2/§1.5 Ore nuggets -> furnace -> ingot (copper/iron ingots use vanilla; the rest are added by this mod)
        oreSmelting(output, ModMaterialItems.COPPER_ORE_NUGGET.get(), Items.COPPER_INGOT, "copper_ore_nugget");
        oreSmelting(output, ModMaterialItems.TIN_ORE_NUGGET.get(), ModMaterialItems.TIN_INGOT.get(), "tin_ore_nugget");
        oreSmelting(output, ModMaterialItems.IRON_ORE_NUGGET.get(), Items.IRON_INGOT, "iron_ore_nugget");
        oreSmelting(output, ModMaterialItems.LEAD_ORE_NUGGET.get(), ModMaterialItems.LEAD_INGOT.get(), "lead_ore_nugget");
        oreSmelting(output, ModMaterialItems.ZINC_ORE_NUGGET.get(), ModMaterialItems.ZINC_INGOT.get(), "zinc_ore_nugget");

        // §2.2 / §1.4 Engineering Table recipes (custom RecipeType; not available in vanilla crafting table)
        registerEngineeringTableRecipes(output);
    }

    /**
     * §2.2 / §1.4 Engineering Table shaped recipes — uses custom RecipeType,
     * recipes are NOT available in the vanilla crafting table.
     */
    private static void registerEngineeringTableRecipes(RecipeOutput output) {
        // ===== §2.2.1 Plates: 1 ingot -> 1 plate (engineering table hammering) =====
        registerPlateRecipe(output, "copper", ModMaterialItems.COPPER_PLATE.get(), Items.COPPER_INGOT);
        registerPlateRecipe(output, "tin", ModMaterialItems.TIN_PLATE.get(), ModMaterialItems.TIN_INGOT.get());
        registerPlateRecipe(output, "iron", ModMaterialItems.IRON_PLATE.get(), Items.IRON_INGOT);
        registerPlateRecipe(output, "lead", ModMaterialItems.LEAD_PLATE.get(), ModMaterialItems.LEAD_INGOT.get());
        registerPlateRecipe(output, "zinc", ModMaterialItems.ZINC_PLATE.get(), ModMaterialItems.ZINC_INGOT.get());

        // ===== §2.2.1 Rods: 1 plate -> 2 rods (engineering table rolling) =====
        registerRodRecipe(output, "copper", ModMaterialItems.COPPER_ROD.get(), ModMaterialItems.COPPER_PLATE.get());
        registerRodRecipe(output, "tin", ModMaterialItems.TIN_ROD.get(), ModMaterialItems.TIN_PLATE.get());
        registerRodRecipe(output, "iron", ModMaterialItems.IRON_ROD.get(), ModMaterialItems.IRON_PLATE.get());
        registerRodRecipe(output, "lead", ModMaterialItems.LEAD_ROD.get(), ModMaterialItems.LEAD_PLATE.get());
        registerRodRecipe(output, "zinc", ModMaterialItems.ZINC_ROD.get(), ModMaterialItems.ZINC_PLATE.get());

        // ===== §2.2.1 Wires: 1 rod -> 2 wires (engineering table drawing) =====
        registerWireRecipe(output, "copper", ModMaterialItems.COPPER_WIRE.get(), ModMaterialItems.COPPER_ROD.get());
        registerWireRecipe(output, "tin", ModMaterialItems.TIN_WIRE.get(), ModMaterialItems.TIN_ROD.get());
        registerWireRecipe(output, "iron", ModMaterialItems.IRON_WIRE.get(), ModMaterialItems.IRON_ROD.get());
        registerWireRecipe(output, "lead", ModMaterialItems.LEAD_WIRE.get(), ModMaterialItems.LEAD_ROD.get());
        registerWireRecipe(output, "zinc", ModMaterialItems.ZINC_WIRE.get(), ModMaterialItems.ZINC_ROD.get());

        // ===== §2.2.2 Alloy ingots (M1-B simplified: craft at engineering table; M1-C moves to alloy furnace) =====
        // Bronze = 3 copper + 1 tin -> 1 bronze ingot (§2.2.2)
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModMaterialItems.BRONZE_INGOT.get())
                .pattern("CCC")
                .pattern("CTC")
                .define('C', Items.COPPER_INGOT)
                .define('T', ModMaterialItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ModMaterialItems.TIN_INGOT.get()))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/bronze_ingot");

        // Brass = 2 copper + 1 zinc -> 1 brass ingot (§2.2.2)
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModMaterialItems.BRASS_INGOT.get())
                .pattern("CC")
                .pattern("Z ")
                .define('C', Items.COPPER_INGOT)
                .define('Z', ModMaterialItems.ZINC_INGOT.get())
                .unlockedBy("has_zinc_ingot", has(ModMaterialItems.ZINC_INGOT.get()))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/brass_ingot");

        // ===== §1.4 Components (migrated from vanilla crafting -> engineering table) =====
        // Clay substrate: 4 terracotta + 1 copper ingot
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModComponentItems.CLAY_SUBSTRATE.get())
                .pattern(" T ")
                .pattern("TCT")
                .pattern(" T ")
                .define('T', Items.TERRACOTTA)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_terracotta", has(Items.TERRACOTTA))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/clay_substrate");

        // Electronic component: 4 copper wire + 1 redstone + 1 tin plate (yields 2, reflecting processing value-add)
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModComponentItems.ELECTRONIC_COMPONENT.get(), 2)
                .pattern("WRW")
                .pattern("WSW")
                .define('W', ModMaterialItems.COPPER_WIRE.get())
                .define('R', Items.REDSTONE)
                .define('S', ModMaterialItems.TIN_PLATE.get())
                .unlockedBy("has_copper_wire", has(ModMaterialItems.COPPER_WIRE.get()))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/electronic_component");

        // Basic circuit board: 3 copper wire + 1 clay substrate + 1 electronic component
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModComponentItems.BASIC_CIRCUIT_BOARD.get())
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" E ")
                .define('W', ModMaterialItems.COPPER_WIRE.get())
                .define('S', ModComponentItems.CLAY_SUBSTRATE.get())
                .define('E', ModComponentItems.ELECTRONIC_COMPONENT.get())
                .unlockedBy("has_clay_substrate", has(ModComponentItems.CLAY_SUBSTRATE.get()))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/basic_circuit_board");

        // CtI motor: 4 copper wire (coil) + 1 iron rod (rotor) + 1 iron plate (base)
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, ModComponentItems.CTI_MOTOR.get())
                .pattern("W W")
                .pattern("WRW")
                .pattern(" B ")
                .define('W', ModMaterialItems.COPPER_WIRE.get())
                .define('R', ModMaterialItems.IRON_ROD.get())
                .define('B', ModMaterialItems.IRON_PLATE.get())
                .unlockedBy("has_iron_rod", has(ModMaterialItems.IRON_ROD.get()))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/cti_motor");
    }

    /** Plate recipe helper: 1 ingot -> 1 plate (single input, single output). */
    private static void registerPlateRecipe(RecipeOutput output, String metal, ItemLike plate, ItemLike ingot) {
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, plate)
                .pattern("I")
                .define('I', ingot)
                .unlockedBy("has_" + metal + "_ingot", has(ingot))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/" + metal + "_plate");
    }

    /** Rod recipe helper: 1 plate -> 2 rods (shearing). */
    private static void registerRodRecipe(RecipeOutput output, String metal, ItemLike rod, ItemLike plate) {
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, rod, 2)
                .pattern("P")
                .pattern("P")
                .define('P', plate)
                .unlockedBy("has_" + metal + "_plate", has(plate))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/" + metal + "_rod");
    }

    /** Wire recipe helper: 1 rod -> 2 wires (drawing). */
    private static void registerWireRecipe(RecipeOutput output, String metal, ItemLike wire, ItemLike rod) {
        EngineeringTableRecipeBuilder.shaped(RecipeCategory.MISC, wire, 2)
                .pattern("R")
                .pattern("R")
                .define('R', rod)
                .unlockedBy("has_" + metal + "_rod", has(rod))
                .save(output, UraniumContaminationEraII.MOD_ID + ":engineering_table/" + metal + "_wire");
    }

    /**
     * Ore nugget -> furnace -> ingot (200 ticks = 10 seconds, consistent with vanilla nugget smelting).
     */
    private static void oreSmelting(RecipeOutput output, ItemLike input, ItemLike outputItem, String group) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, outputItem, 0.7F, 200)
                .group(group)
                .unlockedBy("has_" + group, has(input))
                .save(output, UraniumContaminationEraII.MOD_ID + ":smelting/" + group);
    }
}
