// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.lang;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components.ModComponentItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools.ModToolItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/**
 * English language file generator (assets/.../lang/en_us.json).
 * Append one line in addTranslations for each newly registered item/block (keep the zh_cn side in sync).
 */
public final class ModEnglishLangProvider extends LanguageProvider {
    public ModEnglishLangProvider(PackOutput output) {
        super(output, UraniumContaminationEraII.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative tab title
        add("itemGroup.uraniumcontaminationeraii.main", "Uranium Contamination Era II");

        // §0.1 Uranium ore
        addItem(ModMaterialItems.URANIUM_ORE_CHUNK, "Uranium Ore Chunk");

        // §1.2 Ore chunks
        addItem(ModMaterialItems.TIN_ORE_CHUNK, "Tin Ore Chunk");
        addItem(ModMaterialItems.LEAD_ORE_CHUNK, "Lead Ore Chunk");
        addItem(ModMaterialItems.ZINC_ORE_CHUNK, "Zinc Ore Chunk");

        // §1.2 Ore nuggets
        addItem(ModMaterialItems.COPPER_ORE_NUGGET, "Copper Ore Nugget");
        addItem(ModMaterialItems.TIN_ORE_NUGGET, "Tin Ore Nugget");
        addItem(ModMaterialItems.IRON_ORE_NUGGET, "Iron Ore Nugget");
        addItem(ModMaterialItems.LEAD_ORE_NUGGET, "Lead Ore Nugget");
        addItem(ModMaterialItems.ZINC_ORE_NUGGET, "Zinc Ore Nugget");

        // §1.5 Ingots (copper/iron use vanilla)
        addItem(ModMaterialItems.TIN_INGOT, "Tin Ingot");
        addItem(ModMaterialItems.LEAD_INGOT, "Lead Ingot");
        addItem(ModMaterialItems.ZINC_INGOT, "Zinc Ingot");

        // §1.5 Alloy ingots
        addItem(ModMaterialItems.BRONZE_INGOT, "Bronze Ingot");
        addItem(ModMaterialItems.BRASS_INGOT, "Brass Ingot");

        // §2.2.1 Plates
        addItem(ModMaterialItems.COPPER_PLATE, "Copper Plate");
        addItem(ModMaterialItems.TIN_PLATE, "Tin Plate");
        addItem(ModMaterialItems.IRON_PLATE, "Iron Plate");
        addItem(ModMaterialItems.LEAD_PLATE, "Lead Plate");
        addItem(ModMaterialItems.ZINC_PLATE, "Zinc Plate");

        // §2.2.1 Rods
        addItem(ModMaterialItems.COPPER_ROD, "Copper Rod");
        addItem(ModMaterialItems.TIN_ROD, "Tin Rod");
        addItem(ModMaterialItems.IRON_ROD, "Iron Rod");
        addItem(ModMaterialItems.LEAD_ROD, "Lead Rod");
        addItem(ModMaterialItems.ZINC_ROD, "Zinc Rod");

        // §2.2.1 Wires
        addItem(ModMaterialItems.COPPER_WIRE, "Copper Wire");
        addItem(ModMaterialItems.TIN_WIRE, "Tin Wire");
        addItem(ModMaterialItems.IRON_WIRE, "Iron Wire");
        addItem(ModMaterialItems.LEAD_WIRE, "Lead Wire");
        addItem(ModMaterialItems.ZINC_WIRE, "Zinc Wire");

        // §3.3.4 Nails
        addItem(ModMaterialItems.IRON_NAIL, "Iron Nail");

        // §1.1 Ruin salvage
        addItem(ModMaterialItems.BROKEN_MOTOR, "Broken Motor");
        addItem(ModMaterialItems.COPPER_WIRE_BUNCH, "Copper Wire Bunch");

        // §1.5 Components
        addItem(ModComponentItems.CLAY_SUBSTRATE, "Clay Substrate");
        addItem(ModComponentItems.ELECTRONIC_COMPONENT, "Electronic Component");
        addItem(ModComponentItems.BASIC_CIRCUIT_BOARD, "Basic Circuit Board");
        addItem(ModComponentItems.CTI_MOTOR, "CtI Motor");

        // §〇.1 Tier-0 hand tools
        addItem(ModToolItems.STONE_HAMMER, "Stone Hammer");

        // §1.2 Ore blocks
        addBlock(ModInfrastructureBlocks.TIN_ORE, "Tin Ore");
        addBlock(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        addBlock(ModInfrastructureBlocks.LEAD_ORE, "Lead Ore");
        addBlock(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE, "Deepslate Lead Ore");
        addBlock(ModInfrastructureBlocks.ZINC_ORE, "Zinc Ore");
        addBlock(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE, "Deepslate Zinc Ore");

        // §1.4 Engineering Table
        addBlock(ModStructureBlocks.ENGINEERING_TABLE, "Engineering Table");
        add("container.uraniumcontaminationeraii.engineering_table", "Engineering Table");

        // §1.1 Ruin blocks
        addBlock(ModStructureBlocks.RUIN_DEBRIS, "Ruin Debris");

        // §七-1 Jaw Crusher (OBJ model test vehicle)
        addBlock(ModStructureBlocks.JAW_CRUSHER, "Jaw Crusher");
    }
}
