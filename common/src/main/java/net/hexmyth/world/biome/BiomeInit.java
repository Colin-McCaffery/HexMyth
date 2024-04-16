package net.hexmyth.world.biome;

import net.fabricmc.api.ModInitializer;
import net.hexmyth.world.HexMythRegion;
import net.hexmyth.world.HexMythSurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class BiomeInit implements ModInitializer, TerraBlenderApi
{
  public static final String MOD_ID = "test";

  @Override
  public void onInitialize()
  {
    ModBiomes.registerBiomes();
  }

  @Override
  public void onTerraBlenderInitialized()
  {
    // Given we only add two biomes, we should keep our weight relatively low.
    Regions.register(new HexMythRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

    // Register our surface rules
    SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, HexMythSurfaceRuleData.makeRules());
  }
}