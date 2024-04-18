package net.hexmyth.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hexmyth.HexMyth;
import net.hexmyth.block.CrystallineGrassBlock;
import net.hexmyth.block.CrystallineWoodLog;
import net.hexmyth.block.CrystallineWood;
import net.hexmyth.block.CrystallineWoodPlanks;
import net.hexmyth.block.StrippedCrystallineWoodLog;
import net.hexmyth.block.StrippedCrystallineWood;
import net.hexmyth.block.CrystallineLeaves;
import net.hexmyth.block.CrystallineSapling;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;

public class HexMythBlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(HexMyth.MOD_ID, Registry.BLOCK_REGISTRY);

  public static final RegistrySupplier<Block> CRYSTALLINE_GRASS_BLOCK = BLOCKS.register("crystalline_grass", CrystallineGrassBlock::new);
  public static final RegistrySupplier<Block> CRYSTALLINE_WOOD_LOG = BLOCKS.register("crystalline_wood_log", CrystallineWoodLog::new);
  public static final RegistrySupplier<Block> CRYSTALLINE_WOOD = BLOCKS.register("crystalline_wood", CrystallineWood::new);
  public static final RegistrySupplier<Block> CRYSTALLINE_WOOD_PLANKS = BLOCKS.register("crystalline_wood_planks", CrystallineWoodPlanks::new);
  public static final RegistrySupplier<Block> STRIPPED_CRYSTALLINE_WOOD_LOG = BLOCKS.register("stripped_crystalline_wood_log", StrippedCrystallineWoodLog::new);
  public static final RegistrySupplier<Block> STRIPPED_CRYSTALLINE_WOOD = BLOCKS.register("stripped_crystalline_wood", StrippedCrystallineWood::new);
  public static final RegistrySupplier<Block> CRYSTALLINE_LEAVES = BLOCKS.register("crystalline_leaves", CrystallineLeaves::new);
  public static final RegistrySupplier<Block> CRYSTALLINE_SAPLING = BLOCKS.register("crystalline_sapling", CrystallineSapling::new);

  public static void init() {
    BLOCKS.register();
  }
}