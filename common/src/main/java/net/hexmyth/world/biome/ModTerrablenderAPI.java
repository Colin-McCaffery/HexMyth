package net.hexmyth.world.biome;

import net.hexmyth.HexMyth;
import org.intellij.lang.annotations.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
      Regions.register(new ModOverworldRegion(new Identifier(HexMyth.MOD_ID, "overworld"), 4));

      SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, HexMyth.MOD_ID, ModMaterialRules.makeRules());
    }
}