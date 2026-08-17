package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blockentities;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * 方块实体注册聚集类。
 *
 * <p>登记全部 BlockEntityType;每台机器一个(继承 core/machine 的 AbstractMachineBlockEntity),
 * 物流带/物流接口/管道(2.0)各按需登记。</p>
 *
 * <p>安全创建模式(方块实体引用方块,必须延迟到方块注册完成之后):</p>
 * <pre>{@code
 * ModRegistries.BLOCK_ENTITIES.register("jaw_crusher",
 *         () -> BlockEntityType.Builder.of(JawCrusherBlockEntity::new, ModMachineBlocks.JAW_CRUSHER.get()).build(null));
 * }</pre>
 */
public final class ModBlockEntities {
    private ModBlockEntities() {}

    /** 由 {@link ModRegistries#register(IEventBus)} 统一调用,请勿单独调用。 */
    public static void register() {
        // TODO 阶段2.8(样板机)起随机器登记,示例见类注释
    }
}
