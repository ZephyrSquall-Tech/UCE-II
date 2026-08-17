package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.sounds;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 音效注册聚集类。
 *
 * <p>登记全部 SoundEvent;规划条目(设计文档出处):</p>
 * <ul>
 *   <li>机器运转声——每类机器独有音色(破碎机「咔咔」/离心机「嗡——」/高炉「呼呼」等,§11.6)</li>
 *   <li>锤子敲击骨架声(§3.2)/ 蓝图成型闪光音</li>
 *   <li>气体告警蜂鸣(§13.9)/ 过载电流滋滋声(§1.0.1)</li>
 *   <li>爆炸/熔毁/防爆隔离装置炸毁声(§12.8)</li>
 * </ul>
 */
public final class ModSounds {
    private ModSounds() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2/3c/6:随机器与告警系统登记
    }
}
