// Ref: No.06 Data Generation · No.20 Loot Tables
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.loot;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.Set;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

/**
 * Loot table generator.
 *
 * <p>M1-A done (§1.2): breaking tin/lead/zinc ores drops an "ore chunk" (not the vanilla raw ore); fixed count of 1, fortune/silk touch not handled yet.</p>
 *
 * <p>Note: copper/iron/coal/quartz ores use vanilla blocks; this provider does not modify their drops. M1-C will replace them via LootModifier.</p>
 */
public final class ModLootTableProvider {
    private ModLootTableProvider() {}

    /**
     * Creates a LootTableProvider: registers only the Block loot sub-provider (1.21.1 accepts HolderLookup.Provider for enchantment references).
     */
    public static LootTableProvider create(PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(
                        ctx -> new ModBlockLoot(ctx),
                        LootContextParamSets.BLOCK)
        ), lookupProvider);
    }

    /**
     * Block loot sub-provider: tin/lead/zinc ores drop a chunk (fixed count of 1).
     */
    private static final class ModBlockLoot extends BlockLootSubProvider {
        protected ModBlockLoot(HolderLookup.Provider lookupProvider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
        }

        @Override
        protected void generate() {
            // Tin ore / deepslate tin ore -> tin ore chunk x1
            add(ModInfrastructureBlocks.TIN_ORE.get(), dropChunk(ModMaterialItems.TIN_ORE_CHUNK.get()));
            add(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get(), dropChunk(ModMaterialItems.TIN_ORE_CHUNK.get()));
            // Lead ore / deepslate lead ore -> lead ore chunk x1
            add(ModInfrastructureBlocks.LEAD_ORE.get(), dropChunk(ModMaterialItems.LEAD_ORE_CHUNK.get()));
            add(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get(), dropChunk(ModMaterialItems.LEAD_ORE_CHUNK.get()));
            // Zinc ore / deepslate zinc ore -> zinc ore chunk x1
            add(ModInfrastructureBlocks.ZINC_ORE.get(), dropChunk(ModMaterialItems.ZINC_ORE_CHUNK.get()));
            add(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get(), dropChunk(ModMaterialItems.ZINC_ORE_CHUNK.get()));

            // §1.1 Ruin debris: salvage drops (iron ingot common, copper wire medium, broken motor rare)
            add(ModStructureBlocks.RUIN_DEBRIS.get(), ruinDebrisLoot());
        }

        /** Builds a LootTable that drops a fixed 1 chunk; fortune/silk touch logic deferred to M1-C. */
        private static LootTable.Builder dropChunk(Item chunkItem) {
            return LootTable.lootTable()
                    .withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .add(LootItem.lootTableItem(chunkItem)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))));
        }

        /**
         * Ruin debris loot (§1.1): three-tier salvage pool — common iron ingot (1-2, 70%),
         * medium copper wire bunch (1, 25%), rare broken motor (1, 5%).
         * Tiered via LootItemRandomChanceCondition in separate pools.
         */
        private static LootTable.Builder ruinDebrisLoot() {
            return LootTable.lootTable()
                    // Pool 1: common iron ingot (1-2), 70% chance
                    .withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .when(LootItemRandomChanceCondition.randomChance(0.70F))
                            .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))
                    // Pool 2: medium copper wire bunch x1, 25% chance
                    .withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .when(LootItemRandomChanceCondition.randomChance(0.25F))
                            .add(LootItem.lootTableItem(ModMaterialItems.COPPER_WIRE_BUNCH.get())
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                    // Pool 3: rare broken motor x1, 5% chance
                    .withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .when(LootItemRandomChanceCondition.randomChance(0.05F))
                            .add(LootItem.lootTableItem(ModMaterialItems.BROKEN_MOTOR.get())
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return List.of(
                    ModInfrastructureBlocks.TIN_ORE.get(),
                    ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get(),
                    ModInfrastructureBlocks.LEAD_ORE.get(),
                    ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get(),
                    ModInfrastructureBlocks.ZINC_ORE.get(),
                    ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get(),
                    ModStructureBlocks.RUIN_DEBRIS.get()
            );
        }
    }
}
