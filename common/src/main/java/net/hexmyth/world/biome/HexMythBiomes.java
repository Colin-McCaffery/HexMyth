package net.hexmyth.world.biome;

import net.hexmyth.HexMyth;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class HexMythBiomes
{
  public static final ResourceKey<Biome> CRYSTALLINE_FOREST = register("crystalline_forest");

  public static ResourceKey<Biome> register(String name)
  {
    return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(HexMyth.MOD_ID, name));
  }
}