package com.zeqhyrsquall.uraniumcontaminationeraii;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UraniumContaminationEraII.MOD_ID)
public class UraniumContaminationEraII {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "uraniumcontaminationeraii";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public UraniumContaminationEraII(IEventBus modEventBus, ModContainer modContainer) {
        // Registry hub: all blocks/items/block entities/menus/creative tabs/sounds/particles/data components are submitted here (package structure §2.1)
        ModRegistries.register(modEventBus);

        // Client-only events such as mass tooltip are auto-registered via @EventBusSubscriber(value = Dist.CLIENT) (see core/mass/MassTooltip)

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
