package net.hexmyth.forge;

import net.hexmyth.HexmythAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexmythAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexmythAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HexmythConfigForge.init();
    }
}
