package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.materials;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·原材料类聚集类。
 *
 * <p>登记「原材料」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>矿石碎块 / 矿粒 —— §〇 零级手动工具</li>
 *   <li>金属锭 / 板 / 棍 / 粒 / 粉 / 线(25 种金属矿物) —— §2.1/§2.2.1 材料形态链</li>
 *   <li>合金锭(铸铁/青铜/黄铜/钢/不锈钢/锆-铌) —— §2.2.2</li>
 *   <li>塑料 / 橡胶 —— §2.3.1;硅晶圆 —— §2.3.2;超导陶瓷基板 / 超导基板 —— §2.3.3</li>
 * </ul>
 */
public final class ModMaterialItems {
    private ModMaterialItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段1/3a:注册原材料条目,示例:
        // COPPER_INGOT = ModRegistries.ITEMS.register("copper_ingot",
        //         () -> new Item(new Item.Properties()));
    }
}
