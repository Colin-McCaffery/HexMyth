package net.hexmyth.world;

import com.mojang.datafixers.util.Pair;
import net.hexmyth.world.biome.HexMythBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class HexMythRegion extends Region
{
  public HexMythRegion(ResourceLocation name, int weight)
  {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
  {
    this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
      // Simple example:
      // Replace the Vanilla desert with our hot_red biome
      builder.replaceBiome(Biomes.DESERT, HexMythBiomes.HOT_RED);
    });
  }
}