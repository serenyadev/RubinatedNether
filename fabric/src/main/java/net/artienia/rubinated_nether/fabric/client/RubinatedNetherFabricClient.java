package net.artienia.rubinated_nether.fabric.client;

import net.artienia.rubinated_nether.client.RubinatedNetherClient;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.entity.monster.piglin.PiglinAi;

public final class RubinatedNetherFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        RubinatedNetherClient.clientSetup();
    }
}
