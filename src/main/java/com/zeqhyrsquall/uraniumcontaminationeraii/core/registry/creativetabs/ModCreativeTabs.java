package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.creativetabs;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 创造页注册聚集类。
 *
 * <p>规划 8 个类别分页:</p>
 * <ol>
 *   <li>原材料 —— 矿石/锭/板/线/合金/塑料等(items.materials)</li>
 *   <li>零部件 —— 马达/电路板/线圈/钉子等(items.components)</li>
 *   <li>工具 —— 锤子/蓝图/扳手/万用表/检测仪等(items.tools)</li>
 *   <li>装备 —— 眼镜/监测器/外骨骼/动力装甲/电池(items.gear)</li>
 *   <li>食物 —— 工业厨房食品(items.food)</li>
 *   <li>医疗 —— 抗辐射/急救用品(items.medical)</li>
 *   <li>机器 —— 104 台机器方块(blocks.machines)</li>
 *   <li>基础设施与物流 —— 线缆/管道/物流带/电机(blocks.infrastructure + blocks.logistics)</li>
 * </ol>
 */
public final class ModCreativeTabs {
    private ModCreativeTabs() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2/3:按类别创建创造页,示例:
        // MATERIALS_TAB = ModRegistries.CREATIVE_TABS.register("materials",
        //         () -> CreativeModeTab.builder()
        //                 .title(Component.translatable("itemGroup.uraniumcontaminationeraii.materials"))
        //                 .icon(() -> new ItemStack(Items.COPPER_INGOT))
        //                 .displayItems((params, output) -> output.acceptAll(...))
        //                 .build());
    }
}
