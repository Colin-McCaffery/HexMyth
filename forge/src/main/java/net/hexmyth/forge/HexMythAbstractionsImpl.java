package net.hexmyth.forge;

import net.hexmyth.HexMythAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexMythAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexMythAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HexMythConfigForge.init();
    }
}
