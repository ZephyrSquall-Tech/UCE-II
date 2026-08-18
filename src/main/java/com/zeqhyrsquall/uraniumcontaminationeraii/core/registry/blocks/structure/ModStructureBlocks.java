// Ref: No.03 Block Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure;

import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.EngineeringTableBlock;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Block registration · structure aggregator class.
 *
 * <p>Registers non-functional / intermediate-state blocks; instances reference Block classes
 * in core/blueprint and content packages.</p>
 *
 * <p>Planned entries (design doc sources):</p>
 * <ul>
 *   <li>Engineering table (tier-0 ~ CtII crafting location, reuses vanilla workbench) — §1.4/§2.2.3</li>
 *   <li>Machine skeleton (entity collision, non-passable, fill material → hammer → activate) — §3.2</li>
 *   <li>Wasteland ruin structure blocks (old-era machine wreckage / abandoned pipes, salvageable) — §〇.1</li>
 * </ul>
 *
 * <p>M1-A shipped (§1.4): engineering table block (anvil-like properties, reuses vanilla CraftingMenu).</p>
 */
public final class ModStructureBlocks {
    private ModStructureBlocks() {}

    /** Engineering table (§1.4): tier-0 ~ CtII crafting station, anvil-like properties (metal, blast-resistant, requires pickaxe). */
    public static final DeferredBlock<Block> ENGINEERING_TABLE = ModRegistries.BLOCKS.register(
            "engineering_table",
            () -> new EngineeringTableBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredItem<Item> ENGINEERING_TABLE_ITEM = ModRegistries.ITEMS.register(
            "engineering_table",
            () -> new BlockItem(ENGINEERING_TABLE.get(), new Item.Properties()));

    /**
     * Ruin debris (§1.1): old-era industrial ruin block scatter-generated in the overworld.
     * Stone-like hardness, requires pickaxe; breaking drops salvage loot (iron ingot / copper wire / broken motor).
     */
    public static final DeferredBlock<Block> RUIN_DEBRIS = ModRegistries.BLOCKS.register(
            "ruin_debris",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)));

    public static final DeferredItem<Item> RUIN_DEBRIS_ITEM = ModRegistries.ITEMS.register(
            "ruin_debris",
            () -> new BlockItem(RUIN_DEBRIS.get(), new Item.Properties()));

    /**
     * Jaw Crusher (§七-1): M1-C placeholder — registered as OBJ model loading test vehicle.
     * Full machine logic (BlockEntity + power + blueprint + recipes) deferred to stage 2/3a.
     */
    public static final DeferredBlock<Block> JAW_CRUSHER = ModRegistries.BLOCKS.register(
            "jaw_crusher",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredItem<Item> JAW_CRUSHER_ITEM = ModRegistries.ITEMS.register(
            "jaw_crusher",
            () -> new BlockItem(JAW_CRUSHER.get(), new Item.Properties()));

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // Registration already done via static fields at class load; this method is just an explicit trigger point
    }
}
