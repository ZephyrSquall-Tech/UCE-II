// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.tags;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider.TagLookup;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Item tags generator (copies block tags via contentsGetter).
 *
 * <p>M1-A: no new item tags (tin/lead/zinc ingots do not yet register vanilla-compat tags like BEACON_PAYMENT; deferred to phase 3a metallurgy).</p>
 */
public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagLookup<Block>> blockTags,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, UraniumContaminationEraII.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // M1-A: no new item tags
        // TODO phase 3a: BEACON_PAYMENT / ORES_COPPER and other vanilla-compat tags
    }
}
