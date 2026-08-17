/**
 * 底层 F1 注册表框架:全模组唯一的注册入口层(难度★ P0)。
 *
 * <p>结构:{@link com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries} = 注册中枢(八大 DeferredRegister);
 * items/ 与 blocks/ 按类别分包——物品 6 类(原材料/零部件/工具/装备/食物/医疗),
 * 方块 4 类(机器/基础设施/物流/结构);
 * 其余为 blockentities/ menus/ creativetabs/ sounds/ particles/ datacomponents。</p>
 *
 * <p>规则:其余包禁止私自调用 DeferredRegister,一律经 ModRegistries 与各类别聚集类提交;
 * 唯一例外:注册聚集类允许引用 content 包的类(仅注册期引用,禁止调用运行时方法)。</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry;
