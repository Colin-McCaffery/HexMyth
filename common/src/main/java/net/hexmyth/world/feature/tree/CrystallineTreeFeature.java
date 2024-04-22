package net.hexmyth.world.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class CrystallineTreeFeature extends TreeFeature {

  public static final TreeConfiguration CRYSTALLINE_TREE_CONFIG = CrystallineTreeGrower.createCrystallineTree().build();
  public CrystallineTreeFeature() {
    super(Codec.unit(CRYSTALLINE_TREE_CONFIG));
  }
}
