package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.menus;

import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.EngineeringTableMenu;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Menu registration aggregator class.
 *
 * <p>Registers all MenuType; each machine gets a standard GUI (5 status lights:
 * voltage/power/temperature/gas/purity, §11.5), plus a blueprint machine-selection GUI (§3.1.2)
 * and the central console four-panel (§11.4, 2.0).</p>
 */
public final class ModMenus {
    private ModMenus() {}

    /** Engineering table MenuType (M1-B §2.2.3): opens the custom 3x3 Engineering Table Menu. */
    public static final DeferredHolder<MenuType<?>, MenuType<EngineeringTableMenu>> ENGINEERING_TABLE =
            ModRegistries.MENUS.register("engineering_table",
                    () -> new MenuType<>(EngineeringTableMenu::new, FeatureFlags.VANILLA_SET));

    /** Called centrally by {@link ModRegistries#register}; do not call directly. */
    public static void register() {
        // Static fields above complete registration at class load; this method is an explicit trigger point
    }
}
