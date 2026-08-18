// Ref: No.13 Menus & Screens
package com.zeqhyrsquall.uraniumcontaminationeraii.client.screen;

import com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools.EngineeringTableMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * Engineering table Screen — M1-B simplified version, no recipe book pane.
 *
 * <p>Reuses the vanilla 3x3 crafting table texture for now; a dedicated texture will be added later
 * at {@code assets/uraniumcontaminationeraii/textures/gui/engineering_table.png}.</p>
 *
 * <p>The recipe book pane is intentionally omitted in M1-B because the menu uses a custom RecipeType
 * while the vanilla RecipeBookComponent is bound to CRAFTING — showing it would mislead players
 * into thinking they could craft these recipes in a vanilla crafting table.</p>
 */
public final class EngineeringTableScreen extends AbstractContainerScreen<EngineeringTableMenu> {
    private static final ResourceLocation BACKGROUND =
            ResourceLocation.withDefaultNamespace("textures/gui/container/crafting_table.png");

    public EngineeringTableScreen(EngineeringTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Move the title slightly to align with the 3x3 grid (matches vanilla crafting table)
        this.titleLabelX = 29;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
