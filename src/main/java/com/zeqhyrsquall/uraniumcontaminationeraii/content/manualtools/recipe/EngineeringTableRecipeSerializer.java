package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

/**
 * Serializer for {@link EngineeringTableRecipe} — delegates JSON/network encoding to
 * vanilla {@link ShapedRecipe.Serializer}, wrapping each decoded ShapedRecipe into
 * an EngineeringTableRecipe via xmap.
 */
public final class EngineeringTableRecipeSerializer implements RecipeSerializer<EngineeringTableRecipe> {
    public static final MapCodec<EngineeringTableRecipe> CODEC =
            ShapedRecipe.Serializer.CODEC.xmap(EngineeringTableRecipe::new, EngineeringTableRecipe::delegate);

    public static final StreamCodec<RegistryFriendlyByteBuf, EngineeringTableRecipe> STREAM_CODEC =
            ShapedRecipe.Serializer.STREAM_CODEC.map(EngineeringTableRecipe::new, EngineeringTableRecipe::delegate);

    @Override
    public MapCodec<EngineeringTableRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, EngineeringTableRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
