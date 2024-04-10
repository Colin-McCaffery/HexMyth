package net.hexmyth.world;

import net.hexmyth.world.biome.HexMythBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class HexMythSurfaceRuleData
{
  private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
  private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
  private static final SurfaceRules.RuleSource RED_TERRACOTTA = makeStateRule(Blocks.CRYSTALLINE_GRASS);

  protected static SurfaceRules.RuleSource makeRules()
  {
    SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
    SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

    return SurfaceRules.sequence(
        SurfaceRules.ifTrue(SurfaceRules.isBiome(HexMythBiomes.CRYSTALLINE_FOREST), CRYSTALLINE_GRASS),

        // Default to a grass and dirt surface
        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
    );
  }

  private static SurfaceRules.RuleSource makeStateRule(Block block)
  {
    return SurfaceRules.state(block.defaultBlockState());
  }
}