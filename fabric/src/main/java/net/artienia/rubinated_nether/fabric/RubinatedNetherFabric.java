package net.artienia.rubinated_nether.fabric;

import net.fabricmc.api.ModInitializer;

import net.artienia.rubinated_nether.RubinatedNether;

public final class RubinatedNetherFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        // Run our common setup.
        RubinatedNether.init();
        RubinatedNether.setup();
    }
}
