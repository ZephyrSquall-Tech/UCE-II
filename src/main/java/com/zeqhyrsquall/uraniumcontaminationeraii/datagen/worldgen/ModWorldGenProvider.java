// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.worldgen;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

/**
 * Worldgen datagen (infra F2 extension): configured_feature + placed_feature.
 *
 * <p>M1-A done (§1.2): tin/lead/zinc ores generate naturally in the overworld (shallow stone + deepslate auto-switch).</p>
 *
 * <p>M1-C done (§1.1): ruin debris scatter generation — single ruin_debris block placed ~5% per chunk
 * (RarityFilter.onAverageOnceEvery(20)). Three ruin shapes (small/medium/large) deferred to M2
 * where Structure + Jigsaw + NBT files will replace this simple placeholder.</p>
 *
 * <p>Generation parameters follow vanilla copper/iron ores: tin (like copper, medium), lead/zinc (slightly rarer). Height uses triangle(-64, 64),
 * distributed triangularly between y=-64 and y=64, overlapping the vanilla deepslate layer.</p>
 *
 * <p>Note: biome_modifier JSON files live in {@code src/main/resources/data/<modid>/neoforge/biome_modifier/}
 * (hand-written, not datagen); see {@code add_*.json}.</p>
 */
public final class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModWorldGenProvider::bootstrapConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, ModWorldGenProvider::bootstrapPlacedFeatures);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(UraniumContaminationEraII.MOD_ID));
    }

    /** Configured feature bootstrap: ores + ruin debris variants. */
    private static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // §1.2 Ores: dual-target (stone/deepslate auto-switch)
        registerOre(context, "tin_ore", 9,
                ModInfrastructureBlocks.TIN_ORE.get().defaultBlockState(),
                ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState());
        registerOre(context, "lead_ore", 8,
                ModInfrastructureBlocks.LEAD_ORE.get().defaultBlockState(),
                ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState());
        registerOre(context, "zinc_ore", 8,
                ModInfrastructureBlocks.ZINC_ORE.get().defaultBlockState(),
                ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState());

        // §1.1 Ruin debris: single-block scatter placeholder.
        // M2 will replace this with a proper Structure + Jigsaw system using NBT files (3 ruin shapes:
        // small debris pile, damaged machinery wreckage, abandoned pipe cluster).
        BlockState ruinDebris = ModStructureBlocks.RUIN_DEBRIS.get().defaultBlockState();
        SimpleBlockConfiguration ruinConfig = new SimpleBlockConfiguration(BlockStateProvider.simple(ruinDebris));
        context.register(configuredKey("ruin_debris"),
                new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, ruinConfig));
    }

    /** Placed feature bootstrap: ores (count+triangle) + ruin debris (rarity 5% per chunk). */
    private static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // §1.2 Ores
        registerOrePlaced(context, "tin_ore", configuredFeatures.getOrThrow(configuredKey("tin_ore")),
                20, VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64));
        registerOrePlaced(context, "lead_ore", configuredFeatures.getOrThrow(configuredKey("lead_ore")),
                14, VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64));
        registerOrePlaced(context, "zinc_ore", configuredFeatures.getOrThrow(configuredKey("zinc_ore")),
                14, VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(64));

        // §1.1 Ruin debris: rarity 1/20 (~5% per chunk), surface level (y 63~100), biome-filtered
        context.register(placedKey("ruin_debris"), new PlacedFeature(
                configuredFeatures.getOrThrow(configuredKey("ruin_debris")),
                List.of(
                        RarityFilter.onAverageOnceEvery(20),  // ~5% per chunk (one every 20 chunks avg)
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(63), VerticalAnchor.absolute(100)),
                        BiomeFilter.biome())));
    }

    /** Registers an ore configured_feature (dual target: stone/deepslate auto-switch). */
    private static void registerOre(BootstrapContext<ConfiguredFeature<?, ?>> context,
            String name, int size, BlockState stoneState, BlockState deepslateState) {
        List<OreConfiguration.TargetBlockState> targets = List.of(
                OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), stoneState),
                OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), deepslateState));
        context.register(configuredKey(name),
                new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, size)));
    }

    /** Registers an ore placed_feature. */
    private static void registerOrePlaced(BootstrapContext<PlacedFeature> context,
            String name, Holder<ConfiguredFeature<?, ?>> feature,
            int count, VerticalAnchor min, VerticalAnchor max) {
        context.register(placedKey(name), new PlacedFeature(feature, List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                HeightRangePlacement.triangle(min, max),
                BiomeFilter.biome())));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> configuredKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(UraniumContaminationEraII.MOD_ID, name));
    }

    private static ResourceKey<PlacedFeature> placedKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(UraniumContaminationEraII.MOD_ID, name));
    }
}
