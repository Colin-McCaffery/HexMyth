package net.hexmyth;

import net.hexmyth.registry.HexmythIotaTypeRegistry;
import net.hexmyth.registry.HexmythItemRegistry;
import net.hexmyth.registry.HexmythPatternRegistry;
import net.hexmyth.networking.HexmythNetworking;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class Hexmyth {
    public static final String MOD_ID = "hexmyth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Hexmyth says hello!");

        HexmythAbstractions.initPlatformSpecific();
        HexmythItemRegistry.init();
        HexmythIotaTypeRegistry.init();
        HexmythPatternRegistry.init();
		HexmythNetworking.init();

        LOGGER.info(HexmythAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
