package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.components;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·零部件类聚集类。
 *
 * <p>登记「零部件」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>马达四级(CtI 铜线圈+铁转子 / CtII 铸铁转子 / CtIII 铝转子 / CtIV 钛转子) —— §2.2.4</li>
 *   <li>电路板五级(基础/增强/精密/高性能/超导,陶瓦基板体系) —— §2.2.5</li>
 *   <li>线圈 / 电线(滚压器原生功能) —— §〇.3;齿轮/轴承/活塞/转子/螺丝 —— §2.2.2</li>
 *   <li>钉子三出口(造锤/修锤/修机器) —— §3.3.4</li>
 *   <li>电子元件 / 显示屏 —— §13.9.4;液压活塞 / 伺服控制器 —— §9.3</li>
 * </ul>
 */
public final class ModComponentItems {
    private ModComponentItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段1/3a:注册零部件条目
    }
}
