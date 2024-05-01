package net.hexmyth.world.feature.tree;

import at.petrak.hexcasting.api.HexAPI;
import at.petrak.hexcasting.common.lib.HexBlocks;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.OptionalInt;
import net.hexmyth.HexMyth;
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
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration.TreeConfigurationBuilder;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;

public class CrystallineTreeGrower extends AbstractTreeGrower {

  public static final Block LOG = HexMythBlockRegistry.CRYSTALLINE_WOOD_LOG.get();
  public static final Block LEAVES = HexMythBlockRegistry.CRYSTALLINE_LEAVES.get();

  public CrystallineTreeGrower() {
    super();
  }

  @Nullable
  @Override
  protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
    return GROWERS.get(pRandom.nextInt(GROWERS.size()));
  }

  public static void init() {
    GROWERS.add(buildCrystallineTree());
  }

  public static final List<Holder<ConfiguredFeature<TreeConfiguration, ?>>> GROWERS = Lists.newArrayList();

  public static TreeConfigurationBuilder createCrystallineTree() {
    return createStraightBlobTree(LOG, LEAVES, 5, 2, 0, 2).ignoreVines();
  }

  public static TreeConfigurationBuilder createStraightBlobTree(Block block, Block block2, int i, int j, int k, int l) {
    return new TreeConfigurationBuilder(
        BlockStateProvider.simple(block), new StraightTrunkPlacer(i, j, k), BlockStateProvider.simple(block2), new BlobFoliagePlacer(ConstantInt.of(l), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
  }

  private static Holder<ConfiguredFeature<TreeConfiguration, ?>> buildCrystallineTree() {
    return FeatureUtils.register("crystalline_tree", Feature.TREE,
        new TreeConfigurationBuilder(
            BlockStateProvider.simple(LOG),
            // baseHeight, heightRandA, heightRandB
            new StraightTrunkPlacer(5, 2, 0),
            BlockStateProvider.simple(LEAVES),
            // radius, offset, height
            new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(5), 5),
            // limit, lower size, upper size, minclippedheight
            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(6))
        ).build());
  }
}