// Ref: No.13 Menus & Screens
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools;

import com.zeqhyrsquall.uraniumcontaminationeraii.UraniumContaminationEraII;
import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.recipe.EngineeringTableRecipe;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure.ModStructureBlocks;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.menus.ModMenus;
import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.recipes.ModRecipeTypes;

import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Engineering table Menu (§2.2.3) — copied from vanilla {@code CraftingMenu} with three substitutions:
 * <ul>
 *   <li>{@code RecipeType.CRAFTING} → {@link ModRecipeTypes#ENGINEERING_TABLE} (so only Engineering
 *       Table recipes match in result slot computation)</li>
 *   <li>{@code Blocks.CRAFTING_TABLE} → {@link ModStructureBlocks#ENGINEERING_TABLE} (for stillValid check)</li>
 *   <li>{@code MenuType.CRAFTING} → {@link ModMenus#ENGINEERING_TABLE}</li>
 * </ul>
 *
 * <p>Extends {@link RecipeBookMenu} for future recipe-book integration; M1-B screen omits the recipe book pane.</p>
 */
public final class EngineeringTableMenu extends RecipeBookMenu<CraftingInput, EngineeringTableRecipe> {
    public static final int RESULT_SLOT = 0;
    private static final int CRAFT_SLOT_START = 1;
    private static final int CRAFT_SLOT_END = 10;
    private static final int INV_SLOT_START = 10;
    private static final int INV_SLOT_END = 37;
    private static final int USE_ROW_SLOT_START = 37;
    private static final int USE_ROW_SLOT_END = 46;

    private final CraftingContainer craftSlots = new TransientCraftingContainer(this, 3, 3);
    private final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;
    private boolean placingRecipe;

    public EngineeringTableMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ContainerLevelAccess.NULL);
    }

    public EngineeringTableMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(ModMenus.ENGINEERING_TABLE.get(), containerId);
        this.access = access;
        this.player = playerInventory.player;
        this.addSlot(new EngineeringTableResultSlot(playerInventory.player, this.craftSlots, this.resultSlots, 0, 124, 35));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlot(new Slot(this.craftSlots, col + row * 3, 30 + col * 18, 17 + row * 18));
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    private static void slotChangedCraftingGrid(AbstractContainerMenu menu, Level level, Player player,
                                                 CraftingContainer craftSlots, ResultContainer resultSlots,
                                                 @Nullable RecipeHolder<EngineeringTableRecipe> recipe) {
        if (!level.isClientSide) {
            CraftingInput input = craftSlots.asCraftInput();
            ServerPlayer serverPlayer = (ServerPlayer) player;
            ItemStack result = ItemStack.EMPTY;
            Optional<RecipeHolder<EngineeringTableRecipe>> optional = level.getServer().getRecipeManager()
                    .getRecipeFor(ModRecipeTypes.ENGINEERING_TABLE.get(), input, level, (RecipeHolder<EngineeringTableRecipe>) recipe);
            if (optional.isPresent()) {
                RecipeHolder<EngineeringTableRecipe> holder = optional.get();
                if (resultSlots.setRecipeUsed(level, serverPlayer, holder)) {
                    ItemStack assembled = holder.value().assemble(input, level.registryAccess());
                    if (assembled.isItemEnabled(level.enabledFeatures())) {
                        result = assembled;
                    }
                }
            }
            resultSlots.setItem(0, result);
            menu.setRemoteSlot(0, result);
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), 0, result));
        }
    }

    @Override
    public void slotsChanged(Container inventory) {
        if (!this.placingRecipe) {
            this.access.execute((level, pos) -> slotChangedCraftingGrid(this, level, this.player, this.craftSlots, this.resultSlots, null));
        }
    }

    @Override
    public void beginPlacingRecipe() {
        this.placingRecipe = true;
    }

    @Override
    public void finishPlacingRecipe(RecipeHolder<EngineeringTableRecipe> recipe) {
        this.placingRecipe = false;
        this.access.execute((level, pos) -> slotChangedCraftingGrid(this, level, this.player, this.craftSlots, this.resultSlots, recipe));
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedContents itemHelper) {
        this.craftSlots.fillStackedContents(itemHelper);
    }

    @Override
    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    @Override
    public boolean recipeMatches(RecipeHolder<EngineeringTableRecipe> recipe) {
        return recipe.value().matches(this.craftSlots.asCraftInput(), this.player.level());
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModStructureBlocks.ENGINEERING_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();
            if (index == 0) {
                this.access.execute((level, pos) -> stack.getItem().onCraftedBy(stack, level, player));
                if (!this.moveItemStackTo(stack, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, result);
            } else if (index >= 10 && index < 46) {
                if (!this.moveItemStackTo(stack, 1, 10, false)) {
                    if (index < 37) {
                        if (!this.moveItemStackTo(stack, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(stack, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(stack, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (stack.getCount() == result.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, stack);
            if (index == 0) {
                player.drop(stack, false);
            }
        }
        return result;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public int getResultSlotIndex() { return 0; }

    @Override
    public int getGridWidth() { return this.craftSlots.getWidth(); }

    @Override
    public int getGridHeight() { return this.craftSlots.getHeight(); }

    @Override
    public int getSize() { return 10; }

    @Override
    public RecipeBookType getRecipeBookType() { return RecipeBookType.CRAFTING; }

    @Override
    public boolean shouldMoveToInventory(int slotIndex) { return slotIndex != this.getResultSlotIndex(); }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute((level, pos) -> this.clearContainer(player, this.craftSlots));
    }
}
