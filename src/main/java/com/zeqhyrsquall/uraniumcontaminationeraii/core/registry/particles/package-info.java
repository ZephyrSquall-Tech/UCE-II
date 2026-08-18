/**
 * Particle registration: hammer-strike sparks, gas flash particles (design doc §13.3.9, colored by gas identifier), open-space smoke columns, concentrator glows, etc.
 * <p>Concurrency budget ≤768 (regular 512 + smoke columns 256, dev workflow doc §7);
 * aggregator class {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles.ModParticles}.</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles;
