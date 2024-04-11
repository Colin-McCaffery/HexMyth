package net.hexmyth.forge;

import net.hexmyth.HexMythClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexMythClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexMythClient.init();
    }
}
