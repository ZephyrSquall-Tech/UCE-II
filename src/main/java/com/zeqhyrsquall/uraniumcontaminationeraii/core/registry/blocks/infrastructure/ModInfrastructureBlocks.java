package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.infrastructure;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 方块注册·基础设施类聚集类。
 *
 * <p>登记不占机器编号(104 台框架之外)的电力/流体基础方块与机器附件;
 * 实例引用 core 包内的 Block 类(无跨层引用问题)。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>裸线 / 绝缘线缆(五级材质,极薄碰撞箱) —— §1.3.1/§1.3.2</li>
 *   <li>电线杆(长距离架线) —— §3.6.2;瓷绝缘子(纯接线点) —— §3.6.1</li>
 *   <li>电能传输控制器(感知/限流) —— §3.6.3;机械状态管理器(温控降载) —— §3.6.4</li>
 *   <li>管道 / 气阀 / 储气罐(2.0 管网) —— §13.5.2</li>
 *   <li>通风口 / 排风扇(通风排散) —— §13.3.8</li>
 * </ul>
 */
public final class ModInfrastructureBlocks {
    private ModInfrastructureBlocks() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.2(线缆/绝缘子)/2.5(通风口)/4.1(管道管网)分批登记
    }
}
