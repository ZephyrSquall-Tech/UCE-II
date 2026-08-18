// Ref: No.03 Block Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Block registration · infrastructure aggregator class.
 *
 * <p>Registers power/fluid base blocks and machine attachments that do not occupy machine
 * numbers (outside the 104-machine framework); instances reference Block classes within the
 * core package (no cross-layer reference issues).</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Bare wire / insulated cable (5 material tiers, ultra-thin collision box) — §1.3.1/§1.3.2</li>
 *   <li>Power pole (long-distance wiring) — §3.6.2; porcelain insulator (pure junction point) — §3.6.1</li>
 *   <li>Power transfer controller (sensing/current limiting) — §3.6.3; mechanical state manager (thermal load shedding) — §3.6.4</li>
 *   <li>Pipes / gas valves / gas tanks (2.0 pipe network) — §13.5.2</li>
 *   <li>Vents / exhaust fans (ventilation dispersion) — §13.3.8</li>
 * </ul>
 *
 * <p>M1-A shipped (§1.2): tin/lead/zinc ores + deepslate variants (copper/iron/coal/quartz use vanilla).</p>
 */
public final class ModInfrastructureBlocks {
    private ModInfrastructureBlocks() {}

    // ===== §1.2 Ore blocks (tin/lead/zinc, including deepslate variants) =====

    /** Tin ore: shallow layer. */
    public static final DeferredBlock<Block> TIN_ORE = ModRegistries.BLOCKS.register(
            "tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    /** Deepslate tin ore: deepslate base. */
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = ModRegistries.BLOCKS.register(
            "deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    /** Lead ore: shallow layer. */
    public static final DeferredBlock<Block> LEAD_ORE = ModRegistries.BLOCKS.register(
            "lead_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    /** Deepslate lead ore: deepslate base. */
    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = ModRegistries.BLOCKS.register(
            "deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    /** Zinc ore: shallow layer. */
    public static final DeferredBlock<Block> ZINC_ORE = ModRegistries.BLOCKS.register(
            "zinc_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    /** Deepslate zinc ore: deepslate base. */
    public static final DeferredBlock<Block> DEEPSLATE_ZINC_ORE = ModRegistries.BLOCKS.register(
            "deepslate_zinc_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    // ===== Corresponding BlockItems (to make blocks obtainable) =====

    public static final DeferredItem<Item> TIN_ORE_ITEM = ModRegistries.ITEMS.register(
            "tin_ore",
            () -> new BlockItem(TIN_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> DEEPSLATE_TIN_ORE_ITEM = ModRegistries.ITEMS.register(
            "deepslate_tin_ore",
            () -> new BlockItem(DEEPSLATE_TIN_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> LEAD_ORE_ITEM = ModRegistries.ITEMS.register(
            "lead_ore",
            () -> new BlockItem(LEAD_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> DEEPSLATE_LEAD_ORE_ITEM = ModRegistries.ITEMS.register(
            "deepslate_lead_ore",
            () -> new BlockItem(DEEPSLATE_LEAD_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> ZINC_ORE_ITEM = ModRegistries.ITEMS.register(
            "zinc_ore",
            () -> new BlockItem(ZINC_ORE.get(), new Item.Properties()));

    public static final DeferredItem<Item> DEEPSLATE_ZINC_ORE_ITEM = ModRegistries.ITEMS.register(
            "deepslate_zinc_ore",
            () -> new BlockItem(DEEPSLATE_ZINC_ORE.get(), new Item.Properties()));

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
