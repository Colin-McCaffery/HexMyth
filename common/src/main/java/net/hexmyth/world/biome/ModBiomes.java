package net.hexmyth.world.biome;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
  public static final ResourceKey<Biome> CRYSTALLINE_FOREST = HexMythBiomes.register("crystalline_forest");
  public static void registerBiomes()
  {
    register(HexMythBiomes.CRYSTALLINE_FOREST, ModOverworldBiomes.crystallineForest());
  }

  private static void register(ResourceKey<Biome> key, Biome biome)
  {
    BuiltinRegistries.register(BuiltinRegistries.BIOME, key, biome);
  }
}