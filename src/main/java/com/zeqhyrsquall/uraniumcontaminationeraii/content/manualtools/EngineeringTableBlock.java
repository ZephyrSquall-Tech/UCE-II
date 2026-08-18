// Ref: No.03 Block Registration · No.13 Menus & Screens
package com.zeqhyrsquall.uraniumcontaminationeraii.content.manualtools;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Engineering table (§2.2.3 / §1.4): tier-0 to CtII crafting station.
 *
 * <p>M1-B: right-click opens the custom {@link EngineeringTableMenu}, which restricts matching recipes
 * to {@code ENGINEERING_TABLE} RecipeType (plates / rods / wires / alloys / components).</p>
 *
 * <p>Tier-2 future: add hammer-slot + tool-durability consumption inside the Menu.</p>
 */
public class EngineeringTableBlock extends Block {
    private static final Component CONTAINER_TITLE =
            Component.translatable("container.uraniumcontaminationeraii.engineering_table");

    public EngineeringTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                            Player player, BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        MenuProvider provider = new SimpleMenuProvider(
                (id, inv, p) -> new EngineeringTableMenu(id, inv, ContainerLevelAccess.create(level, pos)),
                CONTAINER_TITLE);
        player.openMenu(provider);
        return InteractionResult.CONSUME;
    }
}
