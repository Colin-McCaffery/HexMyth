package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

import java.util.HashMap;
import java.util.Map;

public class HexMythBlocks {

  public static final Block CRYSTALLINE_GRASS_BLOCK = new Block(Properties.of(Material.DIRT).strength(1.0F).sound(SoundType.AMETHYST));
  public static final Map<String, Block> BLOCKS = new HashMap<>();

  static {
    BLOCKS.put("crystalline_grass_block", CRYSTALLINE_GRASS_BLOCK);
  }

  public static String getBlockName(Block block) {
    for (Map.Entry<String, Block> entry : BLOCKS.entrySet()) {
      if (entry.getValue().equals(block)) {
        return entry.getKey();
      }
    }
    return null;
  }
}