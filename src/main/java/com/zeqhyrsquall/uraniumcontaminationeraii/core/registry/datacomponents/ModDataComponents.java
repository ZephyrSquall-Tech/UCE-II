// Ref: No.08 Data Components
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents;

import java.util.function.Supplier;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.mass.MassComponent;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.minecraft.core.component.DataComponentType;

/**
 * Data component registration aggregator class.
 *
 * <p>Registers all DataComponentType; planned entries (design doc sources):</p>
 * <ul>
 *   <li>Mass component (three tiers in kg + tooltip, §2.4) — type defined in core/mass, registration handle {@link #MASS}</li>
 *   <li>Machine blueprint template component (model + material list + completeness, §3.3.6) — TODO phase 2.3</li>
 *   <li>Battery charge component (§1.4.1) / hammer durability component (§3.3) — TODO from phase 2 onward</li>
 * </ul>
 */
public final class ModDataComponents {
    private ModDataComponents() {}

    /** Mass component: unified kg system (§2.4), integer-gram storage; see MassMath/MassTooltip in core/mass for reads. */
    public static final Supplier<DataComponentType<MassComponent>> MASS =
            ModRegistries.DATA_COMPONENTS.register("mass",
                    () -> DataComponentType.<MassComponent>builder()
                            .persistent(MassComponent.CODEC)
                            .networkSynchronized(MassComponent.STREAM_CODEC)
                            .build());

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Phase 0.3: mass component shipped; TODO register from phase 2.3 (blueprint template component) onward
    }
}
