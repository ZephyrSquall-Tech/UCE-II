// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.lang.ModEnglishLangProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.loot.ModLootTableProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.model.ModBlockStateProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.model.ModItemModelProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.recipe.ModRecipeProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.tags.ModBlockTagsProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.tags.ModItemTagsProvider;
import com.zeqhyrsquall.uraniumcontaminationeraii.datagen.worldgen.ModWorldGenProvider;

import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

/**
 * DataGen entry (infra F2, phase 0.4): single source of truth for all JSON resources.
 *
 * <p>GatherDataEvent implements IModBusEvent; the bus auto-detects registration to the mod bus (skill library E02/Rule B, no bus argument needed).</p>
 */
@EventBusSubscriber(modid = UraniumContaminationEraII.MOD_ID)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        var output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Client resources: language (en_us only), item models, block states/models
        generator.addProvider(event.includeClient(), new ModEnglishLangProvider(output));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));

        // Server data: block tags -> item tags (contentsGetter chain dependency) -> recipes -> loot tables -> worldgen
        var blockTags = new ModBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(),
                new ModItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(output, lookupProvider));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(output, lookupProvider));
    }
}
