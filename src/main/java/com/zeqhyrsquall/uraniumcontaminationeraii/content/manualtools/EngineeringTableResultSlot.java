// Ref: No.13 Menus & Screens
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeTypes;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.neoforged.neoforge.common.CommonHooks;

/**
 * Result slot for the Engineering Table — copied from vanilla {@code ResultSlot} with one change:
 * queries {@link ModRecipeTypes#ENGINEERING_TABLE} instead of {@code RecipeType.CRAFTING} when
 * computing remaining items in {@link #onTake(Player, ItemStack)}.
 *
 * <p>Standalone {@link Slot} subclass (not extending {@code ResultSlot}) so we can hold our own
 * {@code craftSlots} reference and avoid private-field access issues.</p>
 */
public final class EngineeringTableResultSlot extends Slot {
    private final CraftingContainer craftSlots;
    private final Player player;
    private int removeCount;

    public EngineeringTableResultSlot(Player player, CraftingContainer craftSlots, Container container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.player = player;
        this.craftSlots = craftSlots;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }
        return super.remove(amount);
    }

    @Override
    protected void onQuickCraft(ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    @Override
    protected void onSwapCraft(int numItemsCrafted) {
        this.removeCount += numItemsCrafted;
    }

    @Override
    protected void checkTakeAchievements(ItemStack stack) {
        if (this.removeCount > 0) {
            stack.onCraftedBy(this.player.level(), this.player, this.removeCount);
            net.neoforged.neoforge.event.EventHooks.firePlayerCraftingEvent(this.player, stack, this.craftSlots);
        }
        if (this.container instanceof net.minecraft.world.inventory.RecipeCraftingHolder holder) {
            holder.awardUsedRecipes(this.player, this.craftSlots.getItems());
        }
        this.removeCount = 0;
    }

    @Override
    public void onTake(Player player, ItemStack stack) {
        this.checkTakeAchievements(stack);
        CraftingInput.Positioned positioned = this.craftSlots.asPositionedCraftInput();
        CraftingInput input = positioned.input();
        int offsetX = positioned.left();
        int offsetY = positioned.top();
        CommonHooks.setCraftingPlayer(player);
        NonNullList<ItemStack> remaining = player.level().getRecipeManager()
                .getRemainingItemsFor(ModRecipeTypes.ENGINEERING_TABLE.get(), input, player.level());
        CommonHooks.setCraftingPlayer(null);

        for (int row = 0; row < input.height(); row++) {
            for (int col = 0; col < input.width(); col++) {
                int slotIndex = col + offsetX + (row + offsetY) * this.craftSlots.getWidth();
                ItemStack current = this.craftSlots.getItem(slotIndex);
                ItemStack leftover = remaining.get(col + row * input.width());
                if (!current.isEmpty()) {
                    this.craftSlots.removeItem(slotIndex, 1);
                    current = this.craftSlots.getItem(slotIndex);
                }
                if (!leftover.isEmpty()) {
                    if (current.isEmpty()) {
                        this.craftSlots.setItem(slotIndex, leftover);
                    } else if (ItemStack.isSameItemSameComponents(current, leftover)) {
                        leftover.grow(current.getCount());
                        this.craftSlots.setItem(slotIndex, leftover);
                    } else if (!this.player.getInventory().add(leftover)) {
                        this.player.drop(leftover, false);
                    }
                }
            }
        }
    }

    @Override
    public boolean isFake() {
        return true;
    }
}
