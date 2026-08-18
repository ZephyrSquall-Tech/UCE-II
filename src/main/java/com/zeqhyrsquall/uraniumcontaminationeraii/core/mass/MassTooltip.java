// Ref: No.11 Events + No.08 Data Components
package com.zeqhyrsquall.uraniumcontaminationeraii.core.mass;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

/**
 * Mass tooltip (design doc §2.4.2): items with a mass component show "Mass: 1.0 kg" on hover;
 * holding Shift appends "Total load: 42.0 kg".
 *
 * <p>Client-only: registered to the game bus automatically via {@code @EventBusSubscriber(value = Dist.CLIENT)}
 * (bus auto-detection — ItemTooltipEvent does not implement IModBusEvent → NeoForge.EVENT_BUS, skill lib E02/Rule B);
 * this class is not loaded during server scanning, so referencing Minecraft/Screen is safe (E03/Rule C).</p>
 */
@EventBusSubscriber(modid = UraniumContaminationEraII.MOD_ID, value = Dist.CLIENT)
public final class MassTooltip {
    private MassTooltip() {}

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        var stack = event.getItemStack();
        var mass = stack.get(ModDataComponents.MASS);
        if (mass == null) {
            return;
        }
        event.getToolTip().add(
                Component.literal("Mass: " + MassMath.formatKg(mass.grams()) + " kg")
                        .withStyle(ChatFormatting.GRAY));
        // Hold Shift to show total inventory load (§2.4.2 inventory stats)
        if (Screen.hasShiftDown()) {
            var player = Minecraft.getInstance().player;
            if (player != null) {
                event.getToolTip().add(
                        Component.literal("Total load: " + MassMath.formatKg(MassMath.inventoryGrams(player)) + " kg")
                                .withStyle(ChatFormatting.DARK_GRAY));
            }
        }
    }
}
