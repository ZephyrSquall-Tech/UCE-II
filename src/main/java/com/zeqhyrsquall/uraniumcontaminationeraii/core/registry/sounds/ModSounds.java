package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.sounds;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Sound registration aggregator class.
 *
 * <p>Registers all SoundEvent; planned entries (design doc sources):</p>
 * <ul>
 *   <li>Machine operation sounds — each machine type has its own timbre (crusher "clack-clack" / centrifuge "hum" / blast furnace "whoosh" etc., §11.6)</li>
 *   <li>Hammer-on-skeleton sounds (§3.2) / blueprint-forming flash sounds</li>
 *   <li>Gas alarm buzzers (§13.9) / overload current crackle (§1.0.1)</li>
 *   <li>Explosion / meltdown / blast isolation device detonation sounds (§12.8)</li>
 * </ul>
 */
public final class ModSounds {
    private ModSounds() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO phase 2/3c/6: register along with machines and alarm systems
    }
}
