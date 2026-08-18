// Ref: No.05 Creative Tab
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.creativetabs;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components.ModComponentItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools.ModToolItems;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Creative tab registration aggregator class.
 *
 * <p>Planned 8 category tabs (phase 2/3 refinement):</p>
 * <ol>
 *   <li>Raw materials — ores/ingots/plates/wires/alloys/plastics etc. (items.materials)</li>
 *   <li>Components — motors/circuit boards/coils/nails etc. (items.components)</li>
 *   <li>Tools — hammers/blueprints/wrenches/multimeters/detectors etc. (items.tools)</li>
 *   <li>Gear — glasses/monitors/exoskeletons/power armor/batteries (items.gear)</li>
 *   <li>Food — industrial kitchen food (items.food)</li>
 *   <li>Medical — anti-radiation/first aid supplies (items.medical)</li>
 *   <li>Machines — 104 machine blocks (blocks.machines)</li>
 *   <li>Infrastructure & logistics — cables/pipes/conveyor belts/motors (blocks.infrastructure + blocks.logistics)</li>
 * </ol>
 *
 * <p>M1-A shipped: a unified "main" tab (MAIN_TAB) that loads all registered items/blocks in category order;
 * will be split into 8 sub-tabs once phase 2 machines come online.</p>
 */
public final class ModCreativeTabs {
    private ModCreativeTabs() {}

    /** Main creative tab (M1-A unified page): icon = uranium ore chunk. */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = ModRegistries.CREATIVE_TABS.register(
            "main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.uraniumcontaminationeraii.main"))
                    .icon(() -> new ItemStack(ModMaterialItems.URANIUM_ORE_CHUNK.get()))
                    .displayItems((params, output) -> {
                        // §0.1 Uranium ore
                        output.accept(ModMaterialItems.URANIUM_ORE_CHUNK.get());

                        // §1.2 Ore chunks
                        output.accept(ModMaterialItems.TIN_ORE_CHUNK.get());
                        output.accept(ModMaterialItems.LEAD_ORE_CHUNK.get());
                        output.accept(ModMaterialItems.ZINC_ORE_CHUNK.get());

                        // §1.2 Ore nuggets
                        output.accept(ModMaterialItems.COPPER_ORE_NUGGET.get());
                        output.accept(ModMaterialItems.TIN_ORE_NUGGET.get());
                        output.accept(ModMaterialItems.IRON_ORE_NUGGET.get());
                        output.accept(ModMaterialItems.LEAD_ORE_NUGGET.get());
                        output.accept(ModMaterialItems.ZINC_ORE_NUGGET.get());

                        // §1.5 Ingots (copper/iron use vanilla, not duplicated)
                        output.accept(ModMaterialItems.TIN_INGOT.get());
                        output.accept(ModMaterialItems.LEAD_INGOT.get());
                        output.accept(ModMaterialItems.ZINC_INGOT.get());

                        // §1.5 Alloy ingots
                        output.accept(ModMaterialItems.BRONZE_INGOT.get());
                        output.accept(ModMaterialItems.BRASS_INGOT.get());

                        // §2.2.1 Plates
                        output.accept(ModMaterialItems.COPPER_PLATE.get());
                        output.accept(ModMaterialItems.TIN_PLATE.get());
                        output.accept(ModMaterialItems.IRON_PLATE.get());
                        output.accept(ModMaterialItems.LEAD_PLATE.get());
                        output.accept(ModMaterialItems.ZINC_PLATE.get());

                        // §2.2.1 Rods
                        output.accept(ModMaterialItems.COPPER_ROD.get());
                        output.accept(ModMaterialItems.TIN_ROD.get());
                        output.accept(ModMaterialItems.IRON_ROD.get());
                        output.accept(ModMaterialItems.LEAD_ROD.get());
                        output.accept(ModMaterialItems.ZINC_ROD.get());

                        // §2.2.1 Wires
                        output.accept(ModMaterialItems.COPPER_WIRE.get());
                        output.accept(ModMaterialItems.TIN_WIRE.get());
                        output.accept(ModMaterialItems.IRON_WIRE.get());
                        output.accept(ModMaterialItems.LEAD_WIRE.get());
                        output.accept(ModMaterialItems.ZINC_WIRE.get());

                        // §3.3.4 Nails
                        output.accept(ModMaterialItems.IRON_NAIL.get());

                        // §1.1 Ruin salvage
                        output.accept(ModMaterialItems.BROKEN_MOTOR.get());
                        output.accept(ModMaterialItems.COPPER_WIRE_BUNCH.get());

                        // §1.5 Components
                        output.accept(ModComponentItems.CLAY_SUBSTRATE.get());
                        output.accept(ModComponentItems.ELECTRONIC_COMPONENT.get());
                        output.accept(ModComponentItems.BASIC_CIRCUIT_BOARD.get());
                        output.accept(ModComponentItems.CTI_MOTOR.get());

                        // §〇.1 Tier-0 manual tools
                        output.accept(ModToolItems.STONE_HAMMER.get());

                        // §1.2 Ore blocks
                        output.accept(ModInfrastructureBlocks.TIN_ORE_ITEM.get());
                        output.accept(ModInfrastructureBlocks.DEEPSLATE_TIN_ORE_ITEM.get());
                        output.accept(ModInfrastructureBlocks.LEAD_ORE_ITEM.get());
                        output.accept(ModInfrastructureBlocks.DEEPSLATE_LEAD_ORE_ITEM.get());
                        output.accept(ModInfrastructureBlocks.ZINC_ORE_ITEM.get());
                        output.accept(ModInfrastructureBlocks.DEEPSLATE_ZINC_ORE_ITEM.get());

                        // §1.4 Functional blocks
                        output.accept(ModStructureBlocks.ENGINEERING_TABLE_ITEM.get());

                        // §1.1 Ruin blocks
                        output.accept(ModStructureBlocks.RUIN_DEBRIS_ITEM.get());

                        // §七-1 Jaw Crusher (OBJ model test vehicle)
                        output.accept(ModStructureBlocks.JAW_CRUSHER_ITEM.get());
                    })
                    .build());

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
