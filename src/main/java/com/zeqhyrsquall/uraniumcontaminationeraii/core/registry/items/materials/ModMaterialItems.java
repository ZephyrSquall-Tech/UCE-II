// Ref: No.02 Item Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassComponent;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassTier;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Item registration · raw materials aggregator class.
 *
 * <p>Registers all items in the "raw materials" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Ore chunks / ore nuggets — §〇 tier-0 manual tools</li>
 *   <li>Metal ingots / plates / rods / nuggets / powder / wires (25 metal ores) — §2.1/§2.2.1 material form chain</li>
 *   <li>Alloy ingots (cast iron/bronze/brass/steel/stainless steel/zirconium-niobium) — §2.2.2</li>
 *   <li>Plastics / rubber — §2.3.1; silicon wafers — §2.3.2; superconducting ceramic substrate / superconducting substrate — §2.3.3</li>
 * </ul>
 *
 * <p>M1-A shipped (design doc §1.2 + §1.5): tin/lead/zinc ores + chunks/nuggets/ingots + 5-metal plates/rods/wires + 2 alloys + iron nails + ruin salvage.</p>
 */
public final class ModMaterialItems {
    private ModMaterialItems() {}

    // ===== Uranium ore (phase 0.4 test item, retained) =====

    /** Uranium ore chunk (§〇.1): dropped by pickaxe on uranium ore, cannot be smelted directly, must be hammered into nuggets; standard tier 1.0 kg. */
    public static final DeferredItem<Item> URANIUM_ORE_CHUNK = ModRegistries.ITEMS.register(
            "uranium_ore_chunk",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    // ===== §1.2 Ore chunk system (tin/lead/zinc; copper/iron use vanilla) =====

    /** Tin ore chunk: standard tier 1.0 kg. */
    public static final DeferredItem<Item> TIN_ORE_CHUNK = ModRegistries.ITEMS.register(
            "tin_ore_chunk",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Lead ore chunk: standard tier 1.0 kg. */
    public static final DeferredItem<Item> LEAD_ORE_CHUNK = ModRegistries.ITEMS.register(
            "lead_ore_chunk",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Zinc ore chunk: standard tier 1.0 kg. */
    public static final DeferredItem<Item> ZINC_ORE_CHUNK = ModRegistries.ITEMS.register(
            "zinc_ore_chunk",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    // ===== §1.2 Ore nuggets (copper/tin/iron/lead/zinc, 5 kinds; obtained by hammering ore chunks) =====

    /** Copper ore nugget: light tier 0.5 kg. */
    public static final DeferredItem<Item> COPPER_ORE_NUGGET = ModRegistries.ITEMS.register(
            "copper_ore_nugget",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Tin ore nugget: light tier 0.5 kg. */
    public static final DeferredItem<Item> TIN_ORE_NUGGET = ModRegistries.ITEMS.register(
            "tin_ore_nugget",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Iron ore nugget: light tier 0.5 kg. */
    public static final DeferredItem<Item> IRON_ORE_NUGGET = ModRegistries.ITEMS.register(
            "iron_ore_nugget",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Lead ore nugget: light tier 0.5 kg. */
    public static final DeferredItem<Item> LEAD_ORE_NUGGET = ModRegistries.ITEMS.register(
            "lead_ore_nugget",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Zinc ore nugget: light tier 0.5 kg. */
    public static final DeferredItem<Item> ZINC_ORE_NUGGET = ModRegistries.ITEMS.register(
            "zinc_ore_nugget",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    // ===== §1.5 Metal ingots (copper/iron use vanilla copper_ingot/iron_ingot; tin/lead/zinc added) =====

    /** Tin ingot: standard tier 1.0 kg. */
    public static final DeferredItem<Item> TIN_INGOT = ModRegistries.ITEMS.register(
            "tin_ingot",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Lead ingot: standard tier 1.0 kg. */
    public static final DeferredItem<Item> LEAD_INGOT = ModRegistries.ITEMS.register(
            "lead_ingot",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Zinc ingot: standard tier 1.0 kg. */
    public static final DeferredItem<Item> ZINC_INGOT = ModRegistries.ITEMS.register(
            "zinc_ingot",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    // ===== §1.5 Alloy ingots (bronze/brass) =====

    /** Bronze ingot (copper + tin): heavy tier 2.0 kg. */
    public static final DeferredItem<Item> BRONZE_INGOT = ModRegistries.ITEMS.register(
            "bronze_ingot",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.HEAVY))));

    /** Brass ingot (copper + zinc): heavy tier 2.0 kg. */
    public static final DeferredItem<Item> BRASS_INGOT = ModRegistries.ITEMS.register(
            "brass_ingot",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.HEAVY))));

    // ===== §2.2.1 Material form chain: plates (copper/tin/iron/lead/zinc, 5 kinds) =====

    /** Copper plate: standard tier 1.0 kg. */
    public static final DeferredItem<Item> COPPER_PLATE = ModRegistries.ITEMS.register(
            "copper_plate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Tin plate: standard tier 1.0 kg. */
    public static final DeferredItem<Item> TIN_PLATE = ModRegistries.ITEMS.register(
            "tin_plate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Iron plate: standard tier 1.0 kg. */
    public static final DeferredItem<Item> IRON_PLATE = ModRegistries.ITEMS.register(
            "iron_plate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Lead plate: standard tier 1.0 kg. */
    public static final DeferredItem<Item> LEAD_PLATE = ModRegistries.ITEMS.register(
            "lead_plate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Zinc plate: standard tier 1.0 kg. */
    public static final DeferredItem<Item> ZINC_PLATE = ModRegistries.ITEMS.register(
            "zinc_plate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    // ===== §2.2.1 Material form chain: rods (copper/tin/iron/lead/zinc, 5 kinds) =====

    /** Copper rod: standard tier 1.0 kg. */
    public static final DeferredItem<Item> COPPER_ROD = ModRegistries.ITEMS.register(
            "copper_rod",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Tin rod: standard tier 1.0 kg. */
    public static final DeferredItem<Item> TIN_ROD = ModRegistries.ITEMS.register(
            "tin_rod",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Iron rod: standard tier 1.0 kg. */
    public static final DeferredItem<Item> IRON_ROD = ModRegistries.ITEMS.register(
            "iron_rod",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Lead rod: standard tier 1.0 kg. */
    public static final DeferredItem<Item> LEAD_ROD = ModRegistries.ITEMS.register(
            "lead_rod",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Zinc rod: standard tier 1.0 kg. */
    public static final DeferredItem<Item> ZINC_ROD = ModRegistries.ITEMS.register(
            "zinc_rod",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    // ===== §2.2.1 Material form chain: wires (copper/tin/iron/lead/zinc, 5 kinds) =====

    /** Copper wire: light tier 0.5 kg. */
    public static final DeferredItem<Item> COPPER_WIRE = ModRegistries.ITEMS.register(
            "copper_wire",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Tin wire: light tier 0.5 kg. */
    public static final DeferredItem<Item> TIN_WIRE = ModRegistries.ITEMS.register(
            "tin_wire",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Iron wire: light tier 0.5 kg. */
    public static final DeferredItem<Item> IRON_WIRE = ModRegistries.ITEMS.register(
            "iron_wire",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Lead wire: light tier 0.5 kg. */
    public static final DeferredItem<Item> LEAD_WIRE = ModRegistries.ITEMS.register(
            "lead_wire",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Zinc wire: light tier 0.5 kg. */
    public static final DeferredItem<Item> ZINC_WIRE = ModRegistries.ITEMS.register(
            "zinc_wire",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    // ===== §3.3.4 Nails (crafting hammer / repairing hammer / repairing machine share one iron nail) =====

    /** Iron nail: light tier 0.5 kg. */
    public static final DeferredItem<Item> IRON_NAIL = ModRegistries.ITEMS.register(
            "iron_nail",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    // ===== §1.1 Ruin salvage (M1-C implements ruin generation; this phase registers items first) =====

    /** Broken motor (ruin salvage): heavy tier 2.0 kg; salvageable into iron rod + copper wire + basic circuit board. */
    public static final DeferredItem<Item> BROKEN_MOTOR = ModRegistries.ITEMS.register(
            "broken_motor",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.HEAVY))));

    /** Copper wire bunch (ruin salvage): light tier 0.5 kg; salvageable into copper wire. */
    public static final DeferredItem<Item> COPPER_WIRE_BUNCH = ModRegistries.ITEMS.register(
            "copper_wire_bunch",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
