package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.structure;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 方块注册·结构类聚集类。
 *
 * <p>登记非功能/中间态方块;实例引用 core/blueprint 与 content 包内的 Block 类。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>机器骨架(实体碰撞、不可穿人,填材→敲锤→激活) —— §3.2</li>
 *   <li>废土废墟结构方块(旧时代机器残骸/废弃管道,可拆解) —— §〇.1</li>
 * </ul>
 */
public final class ModStructureBlocks {
    private ModStructureBlocks() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段1.1(废墟结构)/2.3(机器骨架)登记
    }
}
