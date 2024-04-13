package net.hexmyth;


import net.hexmyth.block.CrystallineGrassBlock;
import net.hexmyth.networking.HexmythNetworking;
import net.hexmyth.registry.HexMythBlockRegistry;
import net.hexmyth.registry.HexMythIotaTypeRegistry;
import net.hexmyth.registry.HexMythItemRegistry;
import net.hexmyth.registry.HexMythPatternRegistry;
//import net.hexmyth.world.HexMythRegion;
//import net.hexmyth.world.HexMythSurfaceRuleData;
//import net.hexmyth.world.biome.ModBiomes;
import net.hexmyth.world.biome.ModBiomes;
import net.hexmyth.world.biome.TestRegion;
import net.hexmyth.world.biome.TestSurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

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
        HexMythBlockRegistry.init();
        HexMythItemRegistry.init();
        HexMythIotaTypeRegistry.init();
        HexMythPatternRegistry.init();
		    HexmythNetworking.init();
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
