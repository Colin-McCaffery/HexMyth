package net.hexmyth.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Optional;

public class ExampleFeature extends Feature<ExampleFeatureConfig> {
  public ExampleFeature(Codec<ExampleFeatureConfig> configCodec) {
    super(configCodec);
  }

  @Override
  public boolean place(FeaturePlaceContext<ExampleFeatureConfig> context) {
    WorldGenLevel world = context.level();
    BlockPos origin = context.origin();
    ExampleFeatureConfig config = context.config();

    int number = config.number();
    String blockId = String.valueOf(config.blockId());

    Optional<Block> blockOptional = Registry.BLOCK.getOptional(ResourceLocation.tryParse(blockId));
    if (blockOptional.isEmpty()) throw new IllegalStateException(blockId + " could not be parsed to a valid block identifier!");

    BlockState blockState = blockOptional.get().defaultBlockState();

    BlockPos testPos = new BlockPos(origin);
    for (int y = 0; y < world.getHeight(); y++) {
      testPos = testPos.above();
      if (world.getBlockState(testPos).is(BlockTags.DIRT)) {
        if (world.getBlockState(testPos.above()).is(Blocks.AIR)) {
          for (int i = 0; i < number; i++) {
            world.setBlock(testPos, blockState, 0x10);
            testPos = testPos.above();
            if (testPos.getY() >= world.getMaxBuildHeight()) break;
          }
          return true;
        }
      }
    }
    return false;
  }
}