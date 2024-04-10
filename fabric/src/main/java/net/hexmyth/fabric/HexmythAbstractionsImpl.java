package net.hexmyth.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexmyth.HexMythAbstractions;

import java.nio.file.Path;

public class HexmythAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexMythAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HexmythConfigFabric.init();
    }
}
