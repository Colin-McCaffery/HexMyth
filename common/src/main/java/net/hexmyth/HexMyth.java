package net.hexmyth;


import net.hexmyth.networking.HexmythNetworking;
import net.hexmyth.registry.HexmythIotaTypeRegistry;
import net.hexmyth.registry.HexmythItemRegistry;
import net.hexmyth.registry.HexmythPatternRegistry;
import net.hexmyth.world.HexMythRegion;
import net.hexmyth.world.HexMythSurfaceRuleData;
import net.hexmyth.world.biome.ModBiomes;
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
    public static final Block CRYSTALLINE_GRASS_BLOCK  = new Block(Block.Properties.of(Material.DIRT).strength(0.6F).sound(net.minecraft.world.level.block.SoundType.AMETHYST));

    public static void init() {
        LOGGER.info("HexMyth says hello!");

        HexMythAbstractions.initPlatformSpecific();
        HexmythItemRegistry.init();
        HexmythIotaTypeRegistry.init();
        HexmythPatternRegistry.init();
		    HexmythNetworking.init();
        ModBiomes.registerBiomes();

        Regions.register(new HexMythRegion(new ResourceLocation(MOD_ID, "overworld"), 20));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, HexMythSurfaceRuleData.makeRules());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
