// Ref: No.08 Data Components
package com.zeqhyrsquall.uraniumcontaminationeraii.core.mass;

import com.mojang.serialization.Codec;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/**
 * Mass data component (design doc §2.4): records a single item's weight, unified integer-gram storage.
 *
 * <p>Tooltip shows "Mass: 1.0 kg"; registration handle at {@code ModDataComponents.MASS};
 * iron rule: 64 items = 64x mass, cross-phase (solid/gas/liquid) accounting adds directly by kg, no conversion needed.</p>
 */
public record MassComponent(int grams) {

    public static final Codec<MassComponent> CODEC =
            Codec.INT.xmap(MassComponent::of, MassComponent::grams);

    public static final StreamCodec<ByteBuf, MassComponent> STREAM_CODEC =
            ByteBufCodecs.INT.map(MassComponent::of, MassComponent::grams);

    public MassComponent {
        if (grams <= 0) {
            throw new IllegalArgumentException("Mass must be a positive integer in grams: " + grams);
        }
    }

    /** Create from integer grams; the usual path is via {@link MassTier}. */
    public static MassComponent of(int grams) {
        return new MassComponent(grams);
    }

    /** Create from a mass tier (light 500 / standard 1000 / heavy 2000 g). */
    public static MassComponent of(MassTier tier) {
        return new MassComponent(tier.grams());
    }
}
