// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.model;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Block state and block model generator: regular blocks use simpleBlockWithItem(cubeAll).
 *
 * <p>M1-A done: tin/lead/zinc ores + deepslate variants + engineering table (standard cubeAll model).</p>
 */
public final class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UraniumContaminationEraII.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModInfrastructureBlocks.TIN_ORE.get(),
                cubeAll(ModInfrastructureBlocks.TIN_ORE.get()));
        simpleBlockWithItem(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get(),
                cubeAll(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE.get()));
        simpleBlockWithItem(ModInfrastructureBlocks.LEAD_ORE.get(),
                cubeAll(ModInfrastructureBlocks.LEAD_ORE.get()));
        simpleBlockWithItem(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get(),
                cubeAll(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE.get()));
        simpleBlockWithItem(ModInfrastructureBlocks.ZINC_ORE.get(),
                cubeAll(ModInfrastructureBlocks.ZINC_ORE.get()));
        simpleBlockWithItem(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get(),
                cubeAll(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE.get()));

        // §1.4 Engineering table: placeholder stage uses a unified-color cubeAll; the final version should use a 6-face/multi-texture model
        simpleBlockWithItem(ModStructureBlocks.ENGINEERING_TABLE.get(),
                cubeAll(ModStructureBlocks.ENGINEERING_TABLE.get()));

        // §1.1 Ruin debris: gravel-like scattered industrial ruin block
        simpleBlockWithItem(ModStructureBlocks.RUIN_DEBRIS.get(),
                cubeAll(ModStructureBlocks.RUIN_DEBRIS.get()));

        // §七-1 Jaw Crusher: OBJ model — blockstate/model JSON hand-written in src/main/resources/
        // (loader: neoforge:obj), skip datagen to avoid overwriting the OBJ model JSON.
    }
}
