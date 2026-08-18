// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Block tags generator.
 *
 * <p>M1-A done: mining levels for tin/lead/zinc ores + vanilla ore tags (for vanilla/mod recognition).</p>
 *
 * <p>Note: in 1.21.1 the {@code BlockTags.ORES_IN_GROUND_STONE/DEEPSLATE} constants are not directly exposed;
 * use {@link TagKey#create} to manually construct the same tag keys.</p>
 */
public final class ModBlockTagsProvider extends BlockTagsProvider {
    /** Vanilla "stone-layer ore" tag (1.21.1 BlockTags does not expose the constant; constructed manually). */
    private static final TagKey<Block> ORES_IN_GROUND_STONE =
            TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("ores_in_ground/stone"));
    /** Vanilla "deepslate-layer ore" tag (1.21.1 BlockTags does not expose the constant; constructed manually). */
    private static final TagKey<Block> ORES_IN_GROUND_DEEPSLATE =
            TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("ores_in_ground/deepslate"));

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UraniumContaminationEraII.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Mining levels: tin/lead/zinc ores = stone pickaxe (1), deepslate = iron pickaxe (2) (consistent with vanilla copper/iron)
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModInfrastructureBlocks.TIN_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModInfrastructureBlocks.LEAD_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModInfrastructureBlocks.ZINC_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModInfrastructureBlocks.TIN_ORE.get())
                .add(ModInfrastructureBlocks.LEAD_ORE.get())
                .add(ModInfrastructureBlocks.ZINC_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get());

        // Vanilla ore base tags: lets mod ores be recognized by vanilla silk_touch / fortune / vein detection
        tag(ORES_IN_GROUND_STONE)
                .add(ModInfrastructureBlocks.TIN_ORE.get())
                .add(ModInfrastructureBlocks.LEAD_ORE.get())
                .add(ModInfrastructureBlocks.ZINC_ORE.get());

        tag(ORES_IN_GROUND_DEEPSLATE)
                .add(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get());

        // Ore-replaceable base tags: tells the world generator this block can replace stone/deepslate during generation
        tag(BlockTags.STONE_ORE_REPLACEABLES)
                .add(ModInfrastructureBlocks.TIN_ORE.get())
                .add(ModInfrastructureBlocks.LEAD_ORE.get())
                .add(ModInfrastructureBlocks.ZINC_ORE.get());

        tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .add(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get());
    }
}
