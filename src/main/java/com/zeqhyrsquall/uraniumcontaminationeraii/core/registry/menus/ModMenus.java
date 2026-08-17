package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.menus;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 菜单注册聚集类。
 *
 * <p>登记全部 MenuType;每台机器一个标准 GUI(状态五灯:电压/功率/温度/气体/纯度,§11.5),
 * 另有蓝图选机 GUI(§3.1.2)与中央控制台四面板(§11.4,2.0)。</p>
 */
public final class ModMenus {
    private ModMenus() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.8(样板机)起随机器登记
    }
}
