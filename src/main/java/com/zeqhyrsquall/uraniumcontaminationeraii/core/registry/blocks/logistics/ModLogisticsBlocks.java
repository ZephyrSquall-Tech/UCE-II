package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.logistics;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 方块注册·物流类聚集类。
 *
 * <p>登记物流带系统(设计文档 §四)的全部方块;实例引用 content/logistics 包内的 Block 类。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>物流带(64 格上限,L 型自然拐弯) —— §4.1</li>
 *   <li>物流接口(输入/输出双模式,扳手切换) —— §4.2</li>
 *   <li>分类方块(T 型岔路分流) —— §4.3</li>
 *   <li>电机四级(基础/改进/高速/涡轮,贴带侧面) —— §4.4</li>
 *   <li>充电停机坪(智能无人机配套) —— §3.5.3</li>
 * </ul>
 */
public final class ModLogisticsBlocks {
    private ModLogisticsBlocks() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.6:登记物流带系统方块
    }
}
