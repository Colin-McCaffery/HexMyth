package net.hexmyth.world.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class CrystallineTreeFeature extends TreeFeature {

  public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CRYSTALLINE_TREE_CONFIGURED_FEATURE = FeatureUtils.register("crystalline_tree", Feature.TREE, CrystallineTreeGrower.createCrystallineTree().build());
  public static final TreeConfiguration CRYSTALLINE_TREE_CONFIG = CrystallineTreeGrower.createCrystallineTree().build();
  public CrystallineTreeFeature() {
    super(Codec.unit(CRYSTALLINE_TREE_CONFIG));
  }
}
