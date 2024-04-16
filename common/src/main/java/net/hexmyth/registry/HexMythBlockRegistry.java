package net.hexmyth.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexmyth.HexMyth;
import net.hexmyth.block.CrystallineGrassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;

public class HexMythBlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(HexMyth.MOD_ID, Registry.BLOCK_REGISTRY);

  public static final RegistrySupplier<Block> CRYSTALLINE_GRASS_BLOCK;

  static {
    CRYSTALLINE_GRASS_BLOCK = BLOCKS.register("crystalline_grass", CrystallineGrassBlock::new);
  }

  public static void init() {
    BLOCKS.register();
  }
}