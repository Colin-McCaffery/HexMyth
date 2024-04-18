package net.hexmyth;


import net.hexmyth.client.RegisterClient;
import net.hexmyth.networking.HexmythNetworking;
//import net.hexmyth.registry.HexMythFeatureRegistry;
import net.hexmyth.registry.HexMythIotaTypeRegistry;
import net.hexmyth.registry.HexMythItemRegistry;
import net.hexmyth.registry.HexMythPatternRegistry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HexMyth {
    public static final String MOD_ID = "hexmyth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("HexMyth says hello!");

        HexMythAbstractions.initPlatformSpecific();
        HexMythItemRegistry.init();
        HexMythIotaTypeRegistry.init();
        HexMythPatternRegistry.init();
		    HexmythNetworking.init();
        RegisterClient.init();
//        HexMythFeatureRegistry.init();
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
