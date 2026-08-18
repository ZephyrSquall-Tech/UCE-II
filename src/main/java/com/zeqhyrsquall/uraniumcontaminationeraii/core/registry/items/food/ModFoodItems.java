package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.food;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Item registration · food aggregator class.
 *
 * <p>Registers all items in the "food" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>High-saturation synthetic food (flour/sugar/meat/vegetables → industrial kitchen #92) — §7-18</li>
 *   <li>Alcohol / vinegar / fermented beverages (fermentation tank #93, 2.0) — §7-18</li>
 * </ul>
 */
public final class ModFoodItems {
    private ModFoodItems() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO phase 3c/4.4: register food entries
    }
}
