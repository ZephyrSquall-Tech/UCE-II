package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.medical;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·医疗类聚集类(预留)。
 *
 * <p>登记「医疗」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(待设计文档补充):</p>
 * <ul>
 *   <li>抗辐射药物(降低辐射剂量/辐照累积) —— 联动 §9.2 环体征监测器与 radiation 规划子包</li>
 *   <li>急救 / 治疗用品(废土背景的生存医疗)</li>
 * </ul>
 */
public final class ModMedicalItems {
    private ModMedicalItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 设计文档补充医疗物品清单后注册
    }
}
