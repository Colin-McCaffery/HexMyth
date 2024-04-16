package net.hexmyth.world.biome;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
  public static void registerBiomes()
  {
    register(TestBiomes.CRYSTALLINE_FOREST, TestOverworldBiomes.crystalline_forest());
  }

  private static void register(ResourceKey<Biome> key, Biome biome)
  {
    BuiltinRegistries.register(BuiltinRegistries.BIOME, key, biome);
  }
}