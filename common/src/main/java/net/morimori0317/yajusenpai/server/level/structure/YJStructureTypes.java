package net.morimori0317.yajusenpai.server.level.structure;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJStructureTypes {
    private static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(YajuSenpai.MODID, Registry.STRUCTURE_TYPE_REGISTRY);
    public static final RegistrySupplier<StructureType<YJHouseStructure>> YJ_HOUSE = register("yj_house", () -> YJHouseStructure.CODEC);

    private static <S extends Structure> RegistrySupplier<StructureType<S>> register(String name, Supplier<Codec<S>> codec) {
        return STRUCTURE_TYPES.register(name, () -> codec::get);
    }

    public static void init() {
        STRUCTURE_TYPES.register();
    }
}
