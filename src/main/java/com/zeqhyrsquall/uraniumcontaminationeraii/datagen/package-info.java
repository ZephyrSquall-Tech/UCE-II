/**
 * Infra F2 DataGen foundation (difficulty ★★ P0): single source of truth for all JSON resources (package structure note §4.3).
 *
 * <p>Entry {@link com.zeqhyrsquall.uraniumcontaminationeraii.datagen.DataGenerators} (GatherDataEvent, bus auto-detected);
 * sub-packages: lang/ (zh_cn + en_us), model/ (item models + block states), recipe/ (recipes), tags/ (block + item tags), loot/ (loot tables, phase 2).</p>
 *
 * <p>Run: ./gradlew runData -> outputs to src/generated/resources/ (srcDir configured in build.gradle);
 * hand-written JSON is forbidden (except mixins.json, mods.toml).</p>
 *
 * <p>Dependency: datagen -> content (reads registry names to generate JSON; reverse references are forbidden).</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.datagen;
