package net.hexmyth;


import net.hexmyth.client.RegisterClient;
import net.hexmyth.networking.HexmythNetworking;
import net.hexmyth.registry.HexMythFeatureRegistry;
import net.hexmyth.registry.HexMythBlockRegistry;
import net.hexmyth.registry.HexMythIotaTypeRegistry;
import net.hexmyth.registry.HexMythItemRegistry;
import net.hexmyth.registry.HexMythPatternRegistry;
import net.hexmyth.world.biome.ModBiomes;
import net.hexmyth.world.biome.TestMod;
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
    public static boolean terraBlenderInitialized = false;

    public static void init() {
        LOGGER.info("HexMyth says hello!");

        HexMythAbstractions.initPlatformSpecific();
        HexMythBlockRegistry.init();
        HexMythItemRegistry.init();
        HexMythIotaTypeRegistry.init();
        HexMythPatternRegistry.init();
		    HexmythNetworking.init();
        RegisterClient.init();
        HexMythFeatureRegistry.init();
        ModBiomes.registerBiomes();
        // Look I know this looks really scuffed BUT it's the only way I could think of to make sure that the blocks are registered before the terraBlender stuff is initialized
        // Basically otherwise it will try to register the crystalline forest but since it uses the crystalline grass block it shits itself if that hasn't been registered yet
        new Thread(() -> {
            while (!terraBlenderInitialized) {
                if (TestMod.terraBlenderInitialized) {
                    TestMod.init();
                    terraBlenderInitialized = true;
                }
                else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
