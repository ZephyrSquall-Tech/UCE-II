package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.gear;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Item registration · gear aggregator class.
 *
 * <p>Registers all items in the "gear" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Tech engineer glasses (CtII helmet slot) — §9.1</li>
 *   <li>Biosign monitor (CtII basic / CtIII advanced, chest slot) — §9.2</li>
 *   <li>Exoskeleton frame (CtIII, leg enhancement + armor structure base) — §9.3</li>
 *   <li>Power armor four-piece set (CtIV, helmet/chestplate/leggings/boots) — §9.4</li>
 *   <li>Three-tier batteries (small 5k / medium 25k / large 100k Ct) — §1.4.1</li>
 *   <li>Noise-canceling headphones (§11.6 soundscape system accessory) — may also be classified as tools, TBD</li>
 * </ul>
 */
public final class ModGearItems {
    private ModGearItems() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO phase 3c~4: register gear entries
    }
}
