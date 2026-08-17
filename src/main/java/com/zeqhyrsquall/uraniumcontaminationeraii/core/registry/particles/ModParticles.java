package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 粒子注册聚集类。
 *
 * <p>登记全部 ParticleType;规划条目(设计文档出处):</p>
 * <ul>
 *   <li>气体闪现粒子(按 19 种气体标识色着色,§13.3.9)</li>
 *   <li>开放空间溢出烟柱(微漏 1 / 常规 2 / 大量 4 / 爆喷 8 条,§13.3.9)</li>
 *   <li>锤子敲击火花 / 骨架成型闪光(§3.2)/ 过载冒烟 / 浓缩机阵列光效</li>
 * </ul>
 */
public final class ModParticles {
    private ModParticles() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.3(敲击)/2.5(气体闪现)起登记
    }
}
