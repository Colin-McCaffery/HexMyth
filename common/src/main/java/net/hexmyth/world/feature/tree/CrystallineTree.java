//package net.hexmyth.world.feature.tree;
//
//import com.mojang.serialization.Codec;
//import net.hexmyth.registry.HexMythBlockRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.WorldGenLevel;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
//import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
//import net.hexmyth.block.CrystallineWoodLog;
//
//public class CrystallineTree extends Feature<NoneFeatureConfiguration> {
//
//  private static final BlockState LOG = CrystallineWoodLog.block.defaultBlockState();
//  private static final BlockState LEAVES = HexMythBlockRegistry.CRYSTALLINE_LEAVES.defaultBlockState();
//
//  public CrystallineTree(Codec<NoneFeatureConfiguration> codec) {
//    super(codec);
//  }
//
//  @Override
//  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
//    WorldGenLevel world = context.level();
//    BlockPos pos = context.origin();
//
//    // Simple tree generation logic
//    for (int y = 0; y < 5; y++) {
//      world.setBlock(pos.above(y), LOG, 2);
//    }
//
//    for (int x = -2; x <= 2; x++) {
//      for (int z = -2; z <= 2; z++) {
//        for (int y = 5; y <= 6; y++) {
//          if (Math.abs(x) + Math.abs(z) < 3) {
//            world.setBlock(pos.offset(x, y, z), LEAVES, 2);
//          }
//        }
//      }
//    }
//
//    return true;
//  }
//}