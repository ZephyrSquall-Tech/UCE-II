// Ref: No.02 Item Registration
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools;

import java.util.Map;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials.ModMaterialItems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Stone hammer (§〇.1 tier-0 manual tool): main hand holds hammer + offhand holds ore chunk → right click → consumes 1 chunk,
 * ejects 2~3 corresponding ore nuggets, doubled hunger exhaustion (exhaustion +0.5).
 *
 * <p>Supported chunk → nugget mappings:</p>
 * <ul>
 *   <li>Tin ore chunk → tin nugget</li>
 *   <li>Lead ore chunk → lead nugget</li>
 *   <li>Zinc ore chunk → zinc nugget</li>
 * </ul>
 *
 * <p>Uranium ore chunk (§0.1) currently has no corresponding nugget (to be added in the nuclear engineering stage), returns PASS on use.</p>
 *
 * <p>M1-A simplified: no durability, can be used infinitely; after tier-2 blueprint system goes online, switch to four-tier hammer (§3.3.1).</p>
 */
public class StoneHammerItem extends Item {
    /** Chunk → nugget mapping table. */
    private static final Map<Item, Item> CHUNK_TO_NUGGET = Map.of(
            ModMaterialItems.TIN_ORE_CHUNK.get(), ModMaterialItems.TIN_ORE_NUGGET.get(),
            ModMaterialItems.LEAD_ORE_CHUNK.get(), ModMaterialItems.LEAD_ORE_NUGGET.get(),
            ModMaterialItems.ZINC_ORE_CHUNK.get(), ModMaterialItems.ZINC_ORE_NUGGET.get());

    public StoneHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack mainHand = player.getItemInHand(hand);

        // Only triggered by main hand (to avoid duplicate triggers from both hands)
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResultHolder.pass(mainHand);
        }

        ItemStack offhand = player.getOffhandItem();
        Item nugget = CHUNK_TO_NUGGET.get(offhand.getItem());
        if (nugget == null) {
            return InteractionResultHolder.pass(mainHand);
        }

        if (level.isClientSide()) {
            return InteractionResultHolder.success(mainHand); // Client only plays animation
        }

        // Server: consumes 1 chunk from offhand (creative mode does not consume)
        if (!player.getAbilities().instabuild) {
            offhand.shrink(1);
            if (offhand.isEmpty()) {
                player.getInventory().setItem(40, ItemStack.EMPTY);
            }
            // Doubled hunger exhaustion: normal mining exhaustion 0.005, here 0.5 (about 100x, equivalent to ~25s of sprinting)
            player.causeFoodExhaustion(0.5F);
        }

        // Output 2~3 nuggets to player inventory (drops if inventory is full)
        int count = 2 + level.random.nextInt(2); // 2 or 3
        ItemStack nuggets = new ItemStack(nugget, count);
        if (!player.getInventory().add(nuggets)) {
            player.drop(nuggets, false);
        }

        return InteractionResultHolder.consume(mainHand);
    }
}
