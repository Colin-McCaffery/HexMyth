package net.hexmyth.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexmyth.HexmythAbstractions;

import java.nio.file.Path;

public class HexmythAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexmythAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HexmythConfigFabric.init();
    }
}
