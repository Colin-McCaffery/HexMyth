package net.hexmyth.world.biome;

import net.hexmyth.registry.HexMythBlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class TestSurfaceRuleData
{
  public static SurfaceRules.RuleSource getCrystallineGrass() {
    return makeStateRule(HexMythBlockRegistry.CRYSTALLINE_GRASS_BLOCK.get());
  }

  public static SurfaceRules.RuleSource makeRules() {
    SurfaceRules.ConditionSource isTopSurface = SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR);
    return SurfaceRules.ifTrue(isTopSurface, getCrystallineGrass());
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block) {
    return SurfaceRules.state(block.defaultBlockState());
  }
}