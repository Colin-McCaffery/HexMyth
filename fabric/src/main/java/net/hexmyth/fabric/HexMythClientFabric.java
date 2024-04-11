package net.hexmyth.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexmyth.HexMythClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexMythClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexMythClient.init();
    }
}
