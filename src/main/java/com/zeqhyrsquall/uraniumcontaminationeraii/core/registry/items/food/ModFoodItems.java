package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.food;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·食物类聚集类。
 *
 * <p>登记「食物」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>高饱食度合成食品(面粉/糖/肉/蔬菜 → 工业厨房 #92) —— §七-18</li>
 *   <li>酒精 / 醋 / 发酵饮品(发酵罐 #93,2.0) —— §七-18</li>
 * </ul>
 */
public final class ModFoodItems {
    private ModFoodItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段3c/4.4:注册食物条目
    }
}
