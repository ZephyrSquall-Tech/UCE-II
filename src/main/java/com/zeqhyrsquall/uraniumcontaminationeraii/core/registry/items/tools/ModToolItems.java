package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.items.tools;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 物品注册·工具类聚集类。
 *
 * <p>登记「工具」类别下的全部物品;实例在本类构建,经 {@link ModRegistries#ITEMS} 提交。</p>
 *
 * <p>规划条目(设计文档出处):</p>
 * <ul>
 *   <li>碎石锤(矿石碎块→矿粒×2~3) —— §〇</li>
 *   <li>四级锤子(木 64 / 铁 300 / 钢 500 / 锆合金 800 耐久) —— §3.3.1</li>
 *   <li>扳手(物流带方向/接口模式/附件拆卸) —— §四/§3.6</li>
 *   <li>万用表(中央控制台/检测仪配对) —— §11.3/§13.9.3</li>
 *   <li>通用蓝图(开局赠送) / 机器蓝图模板 —— §3.1/§3.3.6</li>
 *   <li>手持气体检测仪 —— §13.9.1;辐射扫描仪 —— §七-16 #83;工业诊断终端 —— §七-12 #64</li>
 *   <li>降噪耳机(§11.6) —— 归入装备类亦可,待定</li>
 * </ul>
 */
public final class ModToolItems {
    private ModToolItems() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段1/2:注册工具条目
    }
}
