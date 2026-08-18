// Ref: No.13 Menus & Screens
package com.zeqhyrsquall.uraniumcontaminationeraii.client;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.client.screen.EngineeringTableScreen;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.menus.ModMenus;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

/**
 * Client-side setup — registers Screens for our MenuTypes.
 *
 * <p>Bound to {@link UraniumContaminationEraII#MOD_ID} on the MOD event bus, client-side only.</p>
 */
@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class ClientSetup {
    private ClientSetup() {}

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenus.ENGINEERING_TABLE.get(), EngineeringTableScreen::new);
    }
}
