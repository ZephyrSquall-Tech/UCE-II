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
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.sounds.ModSounds;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 注册中枢(底层 F1)——全模组唯一持有 DeferredRegister 的类。
 *
 * <p>规则(包结构说明 §1.2):其余包禁止私自调用 DeferredRegister,
 * 一律经由本类与各类别聚集类(ModXxxItems / ModXxxBlocks / ...)完成注册。</p>
 *
 * <p>注册顺序必须保持:物品/方块先提交,方块实体/菜单/创造页引用其条目时才安全
 * (方块实体用 Supplier 延迟构建,见 {@link ModBlockEntities})。</p>
 */
public final class ModRegistries {
    private ModRegistries() {}

    // ===== 八大注册表 =====

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

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, UraniumContaminationEraII.MOD_ID);

    /**
     * 由主类构造函数调用一次;按类别登记全部条目后统一提交八大注册表。
     */
    public static void register(IEventBus modEventBus) {
        // 1. 物品(按类别)
        ModMaterialItems.register();
        ModComponentItems.register();
        ModToolItems.register();
        ModGearItems.register();
        ModFoodItems.register();
        ModMedicalItems.register();

        // 2. 方块(按类别)
        ModMachineBlocks.register();
        ModInfrastructureBlocks.register();
        ModLogisticsBlocks.register();
        ModStructureBlocks.register();

        // 3. 方块实体 / 菜单(依赖上方方块,必须在其后)
        ModBlockEntities.register();
        ModMenus.register();

        // 4. 创造页(依赖物品/方块条目)
        ModCreativeTabs.register();

        // 5. 音效 / 粒子 / 数据组件
        ModSounds.register();
        ModParticles.register();
        ModDataComponents.register();

        // 6. 统一提交八大注册表
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        MENUS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);
        SOUNDS.register(modEventBus);
        PARTICLES.register(modEventBus);
        DATA_COMPONENTS.register(modEventBus);
    }
}
