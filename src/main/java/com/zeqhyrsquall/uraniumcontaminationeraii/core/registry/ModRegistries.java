package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blockentities.ModBlockEntities;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure.ModInfrastructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.logistics.ModLogisticsBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.machines.ModMachineBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.creativetabs.ModCreativeTabs;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents.ModDataComponents;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components.ModComponentItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.food.ModFoodItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.gear.ModGearItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.medical.ModMedicalItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools.ModToolItems;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.menus.ModMenus;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles.ModParticles;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeSerializers;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeTypes;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.sounds.ModSounds;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Registration hub (Foundation layer F1) — sole holder of DeferredRegister instances in the mod.
 *
 * <p>Rule (package structure §1.2): other packages must not call DeferredRegister directly;
 * all registration goes through this class and the category aggregator classes
 * (ModXxxItems / ModXxxBlocks / ...).</p>
 *
 * <p>Registration order must be preserved: items/blocks are submitted first, so block
 * entities/menus/creative tabs can safely reference their entries (block entities are built
 * lazily via Supplier, see {@link ModBlockEntities}).</p>
 */
public final class ModRegistries {
    private ModRegistries() {}

    // ===== Eight registries =====

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, UraniumContaminationEraII.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, UraniumContaminationEraII.MOD_ID);

    /**
     * Called once by the main class constructor; registers all entries by category then submits all eight registries.
     */
    public static void register(IEventBus modEventBus) {
        // 1. Items (by category)
        ModMaterialItems.register();
        ModComponentItems.register();
        ModToolItems.register();
        ModGearItems.register();
        ModFoodItems.register();
        ModMedicalItems.register();

        // 2. Blocks (by category)
        ModMachineBlocks.register();
        ModInfrastructureBlocks.register();
        ModLogisticsBlocks.register();
        ModStructureBlocks.register();

        // 3. Block entities / menus (depend on the blocks above, must come after them)
        ModBlockEntities.register();
        ModMenus.register();

        // 4. Creative tabs (depend on item/block entries)
        ModCreativeTabs.register();

        // 5. Sounds / particles / data components
        ModSounds.register();
        ModParticles.register();
        ModDataComponents.register();

        // 6. Submit all eight registries at once
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        MENUS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
        SOUNDS.register(modEventBus);
        PARTICLES.register(modEventBus);
        DATA_COMPONENTS.register(modEventBus);

        // 7. Recipe types / serializers (M1-B engineering table custom RecipeType)
        // Touch the static fields to force class loading; register() bodies are empty by design
        Object ignoredRecipeType = ModRecipeTypes.ENGINEERING_TABLE;
        Object ignoredSerializer = ModRecipeSerializers.SHAPED;
        ModRecipeTypes.register();
        ModRecipeSerializers.register();

        // 8. Submit recipe registries
        RECIPE_TYPES.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
