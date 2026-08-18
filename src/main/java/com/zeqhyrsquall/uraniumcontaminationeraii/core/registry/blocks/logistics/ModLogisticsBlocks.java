package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.logistics;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Block registration · logistics aggregator class.
 *
 * <p>Registers all blocks of the conveyor belt system (design doc §4); instances reference
 * Block classes in the content/logistics package.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Conveyor belt (64-slot cap, natural L-shaped turning) — §4.1</li>
 *   <li>Logistics interface (input/output dual mode, wrench-switchable) — §4.2</li>
 *   <li>Sorter block (T-junction diverter) — §4.3</li>
 *   <li>Four-tier motor (basic/improved/high-speed/turbine, side-mounted on belt) — §4.4</li>
 *   <li>Charging pad (smart drone accessory) — §3.5.3</li>
 * </ul>
 */
public final class ModLogisticsBlocks {
    private ModLogisticsBlocks() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO phase 2.6: register conveyor belt system blocks
    }
}
