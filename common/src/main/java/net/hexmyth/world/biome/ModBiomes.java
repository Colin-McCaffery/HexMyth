package net.hexmyth.world.biome;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
  public static void registerBiomes()
  {
    register(HexMythBiomes.HOT_RED, HexMythOverworldBiomes.hotRed());
  }

  private static void register(ResourceKey<Biome> key, Biome biome)
  {
    BuiltinRegistries.register(BuiltinRegistries.BIOME, key, biome);
  }
}