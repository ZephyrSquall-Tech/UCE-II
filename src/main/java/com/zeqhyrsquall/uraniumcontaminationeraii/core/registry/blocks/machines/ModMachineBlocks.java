package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blocks.machines;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 方块注册·机器类聚集类。
 *
 * <p>登记 104 台机器方块(设计文档 §七),按工程大类分组,实例引用 content 包中的 Block 类。
 * 机器方块不直接合成——玩家经蓝图搭建系统(core/blueprint)成型激活。</p>
 *
 * <p>规划条目(设计文档编号):</p>
 * <ul>
 *   <li>矿业 5 台(#1~5)/ 石油 5 台(#6~10)/ 化工 7 台(#11~17)</li>
 *   <li>冶金 6 台(#18~23)/ 材料科学 6 台(#24~29)/ 热能 6 台(#30~35)</li>
 *   <li>动力 5 台(#36~40)/ 核工程 8 台(#41~48)/ 电气 6 台(#49~54)</li>
 *   <li>电子 2 台(#55~56)/ 计算机 2 台(#57~58)/ 控制 6 台(#59~64)</li>
 *   <li>自动化 7 台(#65~71)/ 能源 7 台(#72~78)/ 建筑 4 台(#79~82)</li>
 *   <li>安全 5 台(#83~87)/ 环境 3 台(#88~90)/ 农业食品 3 台(#91~93)</li>
 *   <li>通用机械 5 台(#94~98)/ 终极 6 台(#99~104)</li>
 * </ul>
 */
public final class ModMachineBlocks {
    private ModMachineBlocks() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.8(样板机)起按工程大类分批登记,示例:
        // ModRegistries.BLOCKS.register("jaw_crusher", JawCrusherBlock::new);
    }
}
