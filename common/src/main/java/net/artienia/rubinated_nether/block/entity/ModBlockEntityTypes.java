package net.artienia.rubinated_nether.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.artienia.rubinated_nether.RubinatedNether;
import net.artienia.rubinated_nether.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(RubinatedNether.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<FreezerBlockEntity>> FREEZER = BLOCK_ENTITY_TYPES.register("freezer", () ->
            BlockEntityType.Builder.of(FreezerBlockEntity::new, ModBlocks.FREEZER.get()).build(null));

    public static void register() {
        BLOCK_ENTITY_TYPES.register();
    }

}
