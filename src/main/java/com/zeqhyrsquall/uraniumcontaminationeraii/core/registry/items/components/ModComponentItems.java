// Ref: No.02 Item Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassComponent;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassTier;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Item registration · components aggregator class.
 *
 * <p>Registers all items in the "components" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Four-tier motors (CtI copper coil + iron rotor / CtII cast-iron rotor / CtIII aluminum rotor / CtIV titanium rotor) — §2.2.4</li>
 *   <li>Five-tier circuit boards (basic/enhanced/precision/high-performance/superconducting, clay substrate system) — §2.2.5</li>
 *   <li>Coils / wires (roller native function) — §〇.3; gears/bearings/pistons/rotors/screws — §2.2.2</li>
 *   <li>Nail three-outlet (crafting hammer / repairing hammer / repairing machine) — §3.3.4</li>
 *   <li>Electronic components / displays — §13.9.4; hydraulic pistons / servo controllers — §9.3</li>
 * </ul>
 *
 * <p>M1-A shipped (§1.5): clay substrate + electronic component + basic circuit board + CtI motor.</p>
 */
public final class ModComponentItems {
    private ModComponentItems() {}

    /** Clay substrate (§2.2.5): circuit board crafting base, standard tier 1.0 kg. */
    public static final DeferredItem<Item> CLAY_SUBSTRATE = ModRegistries.ITEMS.register(
            "clay_substrate",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Electronic component (§13.9.4): basic circuit board crafting material, light tier 0.5 kg. */
    public static final DeferredItem<Item> ELECTRONIC_COMPONENT = ModRegistries.ITEMS.register(
            "electronic_component",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.LIGHT))));

    /** Basic circuit board (§2.2.5, Level 1/5): CtI machine crafting material, standard tier 1.0 kg. */
    public static final DeferredItem<Item> BASIC_CIRCUIT_BOARD = ModRegistries.ITEMS.register(
            "basic_circuit_board",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** CtI motor (§2.2.4, Level 1/4): CtI machine crafting material, heavy tier 2.0 kg. */
    public static final DeferredItem<Item> CTI_MOTOR = ModRegistries.ITEMS.register(
            "cti_motor",
            () -> new Item(new Item.Properties()
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.HEAVY))));

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
