// Ref: No.16 Recipes
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;

/**
 * Builder for {@link EngineeringTableRecipe} — wraps vanilla {@link ShapedRecipeBuilder} and intercepts
 * {@link RecipeOutput#accept} to wrap the produced ShapedRecipe into an EngineeringTableRecipe.
 *
 * <p>API mirrors {@link ShapedRecipeBuilder#shaped(RecipeCategory, ItemLike, int)} so recipes can be
 * migrated with minimal diff.</p>
 */
public final class EngineeringTableRecipeBuilder {
    private final ShapedRecipeBuilder delegate;

    public static EngineeringTableRecipeBuilder shaped(RecipeCategory category, ItemLike result) {
        return shaped(category, result, 1);
    }

    public static EngineeringTableRecipeBuilder shaped(RecipeCategory category, ItemLike result, int count) {
        return new EngineeringTableRecipeBuilder(ShapedRecipeBuilder.shaped(category, result, count));
    }

    private EngineeringTableRecipeBuilder(ShapedRecipeBuilder delegate) {
        this.delegate = delegate;
    }

    public EngineeringTableRecipeBuilder pattern(String pattern) {
        delegate.pattern(pattern);
        return this;
    }

    public EngineeringTableRecipeBuilder define(char symbol, ItemLike item) {
        delegate.define(symbol, item);
        return this;
    }

    public EngineeringTableRecipeBuilder define(char symbol, TagKey<Item> tag) {
        delegate.define(symbol, tag);
        return this;
    }

    public EngineeringTableRecipeBuilder define(char symbol, Ingredient ingredient) {
        delegate.define(symbol, ingredient);
        return this;
    }

    public EngineeringTableRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        delegate.unlockedBy(name, criterion);
        return this;
    }

    public EngineeringTableRecipeBuilder group(String group) {
        delegate.group(group);
        return this;
    }

    public void save(RecipeOutput output, String id) {
        delegate.save(new WrappingRecipeOutput(output), ResourceLocation.parse(id));
    }

    public void save(RecipeOutput output, ResourceLocation id) {
        delegate.save(new WrappingRecipeOutput(output), id);
    }

    /** RecipeOutput wrapper that re-wraps ShapedRecipe as EngineeringTableRecipe before forwarding. */
    private static final class WrappingRecipeOutput implements RecipeOutput {
        private final RecipeOutput downstream;

        WrappingRecipeOutput(RecipeOutput downstream) {
            this.downstream = downstream;
        }

        @Override
        public void accept(ResourceLocation id, Recipe<?> recipe, @Nullable AdvancementHolder advancement, net.neoforged.neoforge.common.conditions.ICondition... conditions) {
            if (recipe instanceof ShapedRecipe shaped) {
                downstream.accept(id, new EngineeringTableRecipe(shaped), advancement, conditions);
            } else {
                downstream.accept(id, recipe, advancement, conditions);
            }
        }

        @Override
        public Advancement.Builder advancement() {
            return downstream.advancement();
        }
    }
}
