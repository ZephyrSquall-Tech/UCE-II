// Ref: No.16 Recipes
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeSerializers;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeTypes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

/**
 * Engineering table recipe (§2.2.3): wraps a vanilla {@link ShapedRecipe} via composition,
 * overriding {@link #getType()} and {@link #getSerializer()} so the recipe is recognized only
 * by the Engineering Table Menu (not by the vanilla 3x3 crafting table).
 *
 * <p>Composition (not inheritance) is required because ShapedRecipe's {@code result/group/category}
 * fields are package-private in {@code net.minecraft.world.item.crafting} and inaccessible from
 * outside that package.</p>
 */
public final class EngineeringTableRecipe implements CraftingRecipe {
    private final ShapedRecipe delegate;

    public EngineeringTableRecipe(ShapedRecipe delegate) {
        this.delegate = delegate;
    }

    /** The wrapped vanilla ShapedRecipe; used by serializer xmap. */
    public ShapedRecipe delegate() {
        return this.delegate;
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        return this.delegate.matches(input, level);
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        return this.delegate.assemble(input, registries);
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.delegate.getResultItem(registries);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.delegate.getIngredients();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return this.delegate.canCraftInDimensions(width, height);
    }

    @Override
    public String getGroup() {
        return this.delegate.getGroup();
    }

    @Override
    public CraftingBookCategory category() {
        return this.delegate.category();
    }

    @Override
    public ItemStack getToastSymbol() {
        return this.delegate.getToastSymbol();
    }

    @Override
    public boolean showNotification() {
        return this.delegate.showNotification();
    }

    @Override
    public boolean isSpecial() {
        return this.delegate.isSpecial();
    }

    @Override
    public boolean isIncomplete() {
        return this.delegate.isIncomplete();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.ENGINEERING_TABLE.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SHAPED.get();
    }
}