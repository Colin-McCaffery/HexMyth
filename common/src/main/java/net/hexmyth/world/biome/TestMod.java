package net.hexmyth.world.biome;

import net.fabricmc.api.ModInitializer;
import net.hexmyth.client.RegisterClient;
import net.hexmyth.registry.HexMythBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class TestMod implements ModInitializer, TerraBlenderApi
{
  public static final String MOD_ID = "hexmyth";
  public static boolean terraBlenderInitialized = false;

  @Override
  public void onInitialize() {}

  @Override
  public void onTerraBlenderInitialized() {
    terraBlenderInitialized = true;
  }

  public static void init() {
    Regions.register(new TestRegion(new ResourceLocation(MOD_ID, "overworld"), 2));
    SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, TestSurfaceRuleData.makeRules());
    System.out.println("Registered Regions");
  }
}