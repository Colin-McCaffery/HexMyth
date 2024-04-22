package net.hexmyth.world.feature.tree;

import net.hexmyth.registry.HexMythBlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;

public class CrystallineTreeGrower extends AbstractTreeGrower {

  public static final Block LOG = HexMythBlockRegistry.CRYSTALLINE_WOOD_LOG.get();
  public static final Block LEAVES = HexMythBlockRegistry.CRYSTALLINE_LEAVES.get();
  public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CRYSTALLINE_TREE;

  public CrystallineTreeGrower() {
    super();
  }

  @Nullable
  @Override
  protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(
      RandomSource randomSource, boolean bl) {
    return CRYSTALLINE_TREE;
  }

  static {
    CRYSTALLINE_TREE = FeatureUtils.register("crystalline_tree", Feature.TREE, createCrystallineTree().build());
  }

  public static TreeConfiguration.TreeConfigurationBuilder createCrystallineTree() {
    return createStraightBlobTree(LOG, LEAVES, 5, 2, 0, 2).ignoreVines();
  }

  public static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block block, Block block2, int i, int j, int k, int l) {
    return new TreeConfiguration.TreeConfigurationBuilder(
        BlockStateProvider.simple(block), new StraightTrunkPlacer(i, j, k), BlockStateProvider.simple(block2), new BlobFoliagePlacer(ConstantInt.of(l), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
  }
}