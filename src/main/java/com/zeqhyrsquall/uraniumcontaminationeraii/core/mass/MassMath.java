// Ref: No.08 Data Components
package com.zeqhyrsquall.uraniumcontaminationeraii.core.mass;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * Mass integer arithmetic and statistics utility: the whole system uses kg, internally always
 * integer grams (1 kg = 1000 g), no floating-point.
 *
 * <p>This class references the registry handle {@code ModDataComponents.MASS} from registry/datacomponents —
 * allowed by the core rules (registry ← everything else); items without a mass component return 0 and are skipped.</p>
 *
 * <p>Later (phase 2.1) the mass-based caching of {@code MassInventory} (32/64/128 kg, §3.7) will reuse this class's arithmetic.</p>
 */
public final class MassMath {
    private MassMath() {}

    /** Grams per 1 kg: the single constant for all mass conversions. */
    public static final int GRAMS_PER_KG = 1000;

    /** Total mass of a single stack (per-item grams × count); returns 0 if no mass component. */
    public static int stackGrams(ItemStack stack) {
        MassComponent mass = stack.get(ModDataComponents.MASS);
        return mass == null ? 0 : mass.grams() * stack.getCount();
    }

    /** Player inventory total mass: main inventory 36 slots + armor 4 slots + offhand 1 slot (§2.4.2 inventory Shift stats). */
    public static int inventoryGrams(Player player) {
        Inventory inv = player.getInventory();
        int total = 0;
        for (ItemStack stack : inv.items) {
            total += stackGrams(stack);
        }
        for (ItemStack stack : inv.armor) {
            total += stackGrams(stack);
        }
        total += stackGrams(inv.offhand.getFirst());
        return total;
    }

    /**
     * Grams → display kg string (pure integer arithmetic, always one decimal): 500 → "0.5", 1000 → "1.0", 42500 → "42.5".
     * Sub-100 g fractions are floored (display only, does not affect any arithmetic).
     */
    public static String formatKg(int grams) {
        if (grams <= 0) {
            return "0.0";
        }
        return (grams / GRAMS_PER_KG) + "." + (grams % GRAMS_PER_KG) / 100;
    }
}
