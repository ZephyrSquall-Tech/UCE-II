// Ref: No.02 Item Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools;

import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.StoneHammerItem;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassComponent;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassTier;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Item registration · tools aggregator class.
 *
 * <p>Registers all items in the "tools" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Stone hammer (ore chunk → 2~3 ore nuggets) — §〇</li>
 *   <li>Four-tier hammers (wood 64 / iron 300 / steel 500 / zirconium-alloy 800 durability) — §3.3.1</li>
 *   <li>Wrench (conveyor direction / interface mode / attachment removal) — §4/§3.6</li>
 *   <li>Multimeter (central console / detector pairing) — §11.3/§13.9.3</li>
 *   <li>Universal blueprint (starter gift) / machine blueprint template — §3.1/§3.3.6</li>
 *   <li>Handheld gas detector — §13.9.1; radiation scanner — §7-16 #83; industrial diagnostic terminal — §7-12 #64</li>
 *   <li>Noise-canceling headphones (§11.6) — may also be classified as gear, TBD</li>
 * </ul>
 *
 * <p>M1-A shipped (§〇.1): stone hammer (main hand + off-hand chunk → right-click → 2~3 nuggets, double hunger cost).</p>
 */
public final class ModToolItems {
    private ModToolItems() {}

    /** Stone hammer (§〇.1): tier-0 manual tool, standard tier 1.0 kg, no durability (M1-A simplification). */
    public static final DeferredItem<Item> STONE_HAMMER = ModRegistries.ITEMS.register(
            "stone_hammer",
            () -> new StoneHammerItem(new Item.Properties()
                    .stacksTo(1)
                    .component(ModDataComponents.MASS.get(), MassComponent.of(MassTier.STANDARD))));

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
