package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.datacomponents;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 数据组件注册聚集类。
 *
 * <p>登记全部 DataComponentType;规划条目(设计文档出处):</p>
 * <ul>
 *   <li>质量组件(三档 kg + tooltip,§2.4)——类型定义在 core/mass,注册条目在此提交</li>
 *   <li>机器蓝图模板组件(机型+材料清单+完整度,§3.3.6)</li>
 *   <li>电池电量组件(§1.4.1)/ 锤子耐久组件(§3.3)</li>
 * </ul>
 */
public final class ModDataComponents {
    private ModDataComponents() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段0.3(质量组件)/2.3(模板组件)起登记
    }
}
