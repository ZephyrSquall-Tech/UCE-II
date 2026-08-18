/**
 * Foundation layer F3 item mass system: the mod's unified kg weighing rules (design doc §2.4, difficulty ★★ P0).
 *
 * <p>Iron rule: how many kg one item weighs, 64 of them weigh 64x — no density/form/material factors, no loss calculation;
 * solids (this system) / gases (§13, 1 slot = 1 kg) / liquid slurries (§13.5.1, 1 slot = 1 kg) all use unified kg; cross-phase accounting needs no conversion.</p>
 *
 * <p>Core classes:
 * {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassTier} (three-tier enum, integer-gram storage),
 * {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassComponent} (data component, registration handle in registry/datacomponents),
 * {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassMath} (integer arithmetic / inventory stats),
 * {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassTooltip} (client tooltip).</p>
 *
 * <p>Dependency rules: may reference the registry handle in registry/datacomponents (core rule: registry ← everything else);
 * MassTooltip is registered to the game bus automatically via @EventBusSubscriber(value = Dist.CLIENT) (bus auto-detection, skill lib E02/Rule B),
 * and this class is not loaded during server scanning (client never enters the server).</p>
 *
 * <p>Later: from phase 2.1, MassInventory (mass-based caching 32/64/128 kg, §3.7) will land in this package.</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.core.mass;
