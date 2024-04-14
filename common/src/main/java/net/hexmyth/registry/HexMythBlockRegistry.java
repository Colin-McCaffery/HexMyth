package net.hexmyth.registry;

import dev.architectury.registry.registries.DeferredRegister;
import net.hexmyth.HexMyth;
import net.hexmyth.block.HexMythBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;

public class HexMythBlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(HexMyth.MOD_ID, Registry.BLOCK_REGISTRY);

  public static void init() {
    HexMythBlocks.BLOCKS.values().forEach(block -> BLOCKS.register(HexMythBlocks.getBlockName(block), () -> block));
    BLOCKS.register();
  }
}