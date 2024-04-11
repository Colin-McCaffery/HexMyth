package net.hexmyth;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hexmyth.registry.HexmythIotaTypeRegistry;
import net.hexmyth.registry.HexmythItemRegistry;
import net.hexmyth.registry.HexmythPatternRegistry;
import net.hexmyth.networking.HexmythNetworking;
import net.hexmyth.world.HexMythRegion;
import net.hexmyth.world.HexMythSurfaceRuleData;
import net.hexmyth.world.biome.ModBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;
import net.minecraft.world.level.block.Block;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HexMyth implements ModInitializer, TerraBlenderApi {
    public static final String MOD_ID = "hexmyth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Block CRYSTALLINE_GRASS_BLOCK  = new Block(
        FabricBlockSettings.of(Material.GRASS).strength(4.0f));

    public static void init() {
        LOGGER.info("HexMyth says hello!");

        HexMythAbstractions.initPlatformSpecific();
        HexmythItemRegistry.init();
        HexmythIotaTypeRegistry.init();
        HexmythPatternRegistry.init();
		    HexmythNetworking.init();

        LOGGER.info(HexMythAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    @Override
    public void onInitialize()
    {
        ModBiomes.registerBiomes();
    }

    @Override
    public void onTerraBlenderInitialized()
    {
        Regions.register(new HexMythRegion(new ResourceLocation(MOD_ID, "overworld"), 20));

        // Register our surface rules
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, HexMythSurfaceRuleData.makeRules());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
