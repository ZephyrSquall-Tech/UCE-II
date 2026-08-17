package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.gear;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·装备类聚集类。
 *
 * <p>登记「装备」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>科技工程师眼镜(CtII 头盔栏) —— §9.1</li>
 *   <li>环体征监测器(CtII 基础 / CtIII 进阶,胸甲栏) —— §9.2</li>
 *   <li>外骨骼框架(CtIII,腿部增强 + 装甲结构基础) —— §9.3</li>
 *   <li>动力装甲四件套(CtIV,头盔/胸甲/腿甲/靴子) —— §9.4</li>
 *   <li>电池三级(小型 5k / 中型 25k / 大型 100k Ct) —— §1.4.1</li>
 *   <li>降噪耳机(§11.6 声景系统配套) —— 亦可归工具类,待定</li>
 * </ul>
 */
public final class ModGearItems {
    private ModGearItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段3c~4:注册装备条目
    }
}
