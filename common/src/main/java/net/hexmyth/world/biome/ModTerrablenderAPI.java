package net.hexmyth.world.biome;

import org.intellij.lang.annotations.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

  public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
      Regions.register(new ModOverworldRegion(new Identifier("hexmyth", "overworld"), 4));

      SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "hexmyth", ModMaterialRules.makeRules());
    }
  }
}