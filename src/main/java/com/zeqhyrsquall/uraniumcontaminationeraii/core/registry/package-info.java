/**
 * Foundation layer F1 registry framework: the mod's single registration entry layer (difficulty ★ P0).
 *
 * <p>Structure: {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries} = registration hub (eight DeferredRegister);
 * items/ and blocks/ are sub-packaged by category — items 6 categories (raw materials/components/tools/gear/food/medical),
 * blocks 4 categories (machines/infrastructure/logistics/structure);
 * the rest are blockentities/ menus/ creativetabs/ sounds/ particles/ datacomponents.</p>
 *
 * <p>Rules: other packages must not call DeferredRegister directly; all submissions go through ModRegistries and the category aggregator classes;
 * the sole exception: registration aggregator classes may reference classes in the content package (registration-time references only, runtime methods must not be called).</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry;
