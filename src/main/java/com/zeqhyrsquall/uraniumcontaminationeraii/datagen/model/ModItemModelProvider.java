// Ref: No.06 Data Generation
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen.model;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components.ModComponentItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools.ModToolItems;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Item model generator: regular items use basicItem (texture must exist at textures/item/<registry_name>.png);
 * block items point to their block model (registered in {@link ModBlockStateProvider}).
 */
public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UraniumContaminationEraII.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // §0.1 Uranium ore
        basicItem(ModMaterialItems.URANIUM_ORE_CHUNK.get());

        // §1.2 Ore chunks
        basicItem(ModMaterialItems.TIN_ORE_CHUNK.get());
        basicItem(ModMaterialItems.LEAD_ORE_CHUNK.get());
        basicItem(ModMaterialItems.ZINC_ORE_CHUNK.get());

        // §1.2 Ore nuggets
        basicItem(ModMaterialItems.COPPER_ORE_NUGGET.get());
        basicItem(ModMaterialItems.TIN_ORE_NUGGET.get());
        basicItem(ModMaterialItems.IRON_ORE_NUGGET.get());
        basicItem(ModMaterialItems.LEAD_ORE_NUGGET.get());
        basicItem(ModMaterialItems.ZINC_ORE_NUGGET.get());

        // §1.5 Ingots
        basicItem(ModMaterialItems.TIN_INGOT.get());
        basicItem(ModMaterialItems.LEAD_INGOT.get());
        basicItem(ModMaterialItems.ZINC_INGOT.get());

        // §1.5 Alloy ingots
        basicItem(ModMaterialItems.BRONZE_INGOT.get());
        basicItem(ModMaterialItems.BRASS_INGOT.get());

        // §2.2.1 Plates
        basicItem(ModMaterialItems.COPPER_PLATE.get());
        basicItem(ModMaterialItems.TIN_PLATE.get());
        basicItem(ModMaterialItems.IRON_PLATE.get());
        basicItem(ModMaterialItems.LEAD_PLATE.get());
        basicItem(ModMaterialItems.ZINC_PLATE.get());

        // §2.2.1 Rods
        basicItem(ModMaterialItems.COPPER_ROD.get());
        basicItem(ModMaterialItems.TIN_ROD.get());
        basicItem(ModMaterialItems.IRON_ROD.get());
        basicItem(ModMaterialItems.LEAD_ROD.get());
        basicItem(ModMaterialItems.ZINC_ROD.get());

        // §2.2.1 Wires
        basicItem(ModMaterialItems.COPPER_WIRE.get());
        basicItem(ModMaterialItems.TIN_WIRE.get());
        basicItem(ModMaterialItems.IRON_WIRE.get());
        basicItem(ModMaterialItems.LEAD_WIRE.get());
        basicItem(ModMaterialItems.ZINC_WIRE.get());

        // §3.3.4 Nails
        basicItem(ModMaterialItems.IRON_NAIL.get());

        // §1.1 Ruin salvage
        basicItem(ModMaterialItems.BROKEN_MOTOR.get());
        basicItem(ModMaterialItems.COPPER_WIRE_BUNCH.get());

        // §1.5 Components
        basicItem(ModComponentItems.CLAY_SUBSTRATE.get());
        basicItem(ModComponentItems.ELECTRONIC_COMPONENT.get());
        basicItem(ModComponentItems.BASIC_CIRCUIT_BOARD.get());
        basicItem(ModComponentItems.CTI_MOTOR.get());

        // §〇.1 Tier-0 hand tools (handheld texture)
        withExistingParent("stone_hammer", mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/stone_hammer"));
    }
}
