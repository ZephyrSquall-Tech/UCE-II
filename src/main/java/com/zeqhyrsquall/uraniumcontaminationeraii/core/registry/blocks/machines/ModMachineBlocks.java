package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.machines;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Block registration · machine aggregator class.
 *
 * <p>Registers the 104 machine blocks (design doc §7), grouped by engineering discipline;
 * instances reference Block classes in the content package. Machine blocks are not crafted
 * directly — players assemble them via the blueprint system (core/blueprint) and activate them.</p>
 *
 * <p>Planned entries (design doc numbering):</p>
 * <ul>
 *   <li>Mining 5 (#1~5) / Oil 5 (#6~10) / Chemical 7 (#11~17)</li>
 *   <li>Metallurgy 6 (#18~23) / Materials science 6 (#24~29) / Thermal 6 (#30~35)</li>
 *   <li>Power 5 (#36~40) / Nuclear 8 (#41~48) / Electrical 6 (#49~54)</li>
 *   <li>Electronics 2 (#55~56) / Computer 2 (#57~58) / Control 6 (#59~64)</li>
 *   <li>Automation 7 (#65~71) / Energy 7 (#72~78) / Construction 4 (#79~82)</li>
 *   <li>Safety 5 (#83~87) / Environment 3 (#88~90) / Agriculture & food 3 (#91~93)</li>
 *   <li>General machinery 5 (#94~98) / Ultimate 6 (#99~104)</li>
 * </ul>
 */
public final class ModMachineBlocks {
    private ModMachineBlocks() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO from phase 2.8 (sample machine) onward, register in batches by engineering discipline, e.g.:
        // ModRegistries.BLOCKS.register("jaw_crusher", JawCrusherBlock::new);
    }
}
