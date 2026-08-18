package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Particle registration aggregator class.
 *
 * <p>Registers all ParticleType; planned entries (design doc sources):</p>
 * <ul>
 *   <li>Gas flash particles (colored by the 19 gas identifier colors, §13.3.9)</li>
 *   <li>Open-space spill smoke columns (seep 1 / normal 2 / heavy 4 / blowout 8 streams, §13.3.9)</li>
 *   <li>Hammer strike sparks / skeleton forming flashes (§3.2) / overload smoke / concentrator array glow</li>
 * </ul>
 */
public final class ModParticles {
    private ModParticles() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO register from phase 2.3 (hammer strike) / 2.5 (gas flash) onward
    }
}
