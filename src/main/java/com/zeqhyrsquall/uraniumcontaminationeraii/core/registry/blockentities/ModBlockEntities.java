package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.blockentities;

import com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.ModRegistries;

/**
 * Block entity registration aggregator class.
 *
 * <p>Registers all BlockEntityType; one per machine (extends AbstractMachineBlockEntity in
 * core/machine); conveyor belts / logistics interfaces / pipes (2.0) are registered as needed.</p>
 *
 * <p>Safe creation pattern (block entities reference blocks, so they must be deferred until
 * after block registration is complete):</p>
 * <pre>{@code
 * ModRegistries.BLOCK_ENTITIES.register("jaw_crusher",
 *         () -> BlockEntityType.Builder.of(JawCrusherBlockEntity::new, ModMachineBlocks.JAW_CRUSHER.get()).build(null));
 * }</pre>
 */
public final class ModBlockEntities {
    private ModBlockEntities() {}

    /** Called centrally by {@link ModRegistries#register(IEventBus)}; do not call directly. */
    public static void register() {
        // TODO register along with machines from phase 2.8 (sample machine) onward; see class javadoc for example
    }
}
