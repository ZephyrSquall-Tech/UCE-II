// Ref: No.08 Data Components
package com.zeqhyrsquall.uraniumcontaminationeraii.core.mass;

import javax.annotation.Nullable;

/**
 * Mass three tiers (design doc §2.4.1): light 0.5 / standard 1.0 / heavy 2.0 kg.
 *
 * <p>The whole system has only these three tiers — no density factors, no form factors,
 * no material multipliers; storage is always integer grams, 1 kg = 1000 g, avoiding
 * floating-point error.</p>
 *
 * <p>Tier assignment (which items belong to which tier) is decided by the content package
 * when registering items; this package only defines the weighing rules.</p>
 */
public enum MassTier {
    /** Light tier 0.5 kg: powders, granules, wires, small parts (screws/gears/chips). */
    LIGHT(500),
    /** Standard tier 1.0 kg: ingots, plates, rods, ores, ore chunks, coils, circuit boards, plastics. */
    STANDARD(1000),
    /** Heavy tier 2.0 kg: alloy ingots, machine skeletons/shells, large parts (motors/rotors/pistons/core components). */
    HEAVY(2000);

    private final int grams;

    MassTier(int grams) {
        this.grams = grams;
    }

    /** Integer grams of this tier. */
    public int grams() {
        return grams;
    }

    /** Reverse-lookup tier by grams; returns {@code null} if not found (e.g. custom gram values). */
    @Nullable
    public static MassTier fromGrams(int grams) {
        for (MassTier tier : values()) {
            if (tier.grams == grams) {
                return tier;
            }
        }
        return null;
    }
}
