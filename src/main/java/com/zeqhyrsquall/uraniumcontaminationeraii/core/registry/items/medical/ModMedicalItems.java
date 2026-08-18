package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.medical;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Item registration · medical aggregator class (reserved).
 *
 * <p>Registers all items in the "medical" category; instances are built here and submitted
 * via {@link ModRegistries#ITEMS}.</p>
 *
 * <p>Planned entries (pending design doc refinement):</p>
 * <ul>
 *   <li>Anti-radiation drugs (reduce radiation dose / cumulative exposure) — links to §9.2 biosign monitor and the radiation planning subpackage</li>
 *   <li>First aid / treatment supplies (wasteland survival medicine)</li>
 * </ul>
 */
public final class ModMedicalItems {
    private ModMedicalItems() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO register medical items after the design doc refines the medical item list
    }
}
