package net.hexmyth.world;

import com.mojang.datafixers.util.Pair;
import net.hexmyth.world.biome.HexMythBiomes;
import net.hexmyth.world.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import org.intellij.lang.annotations.Identifier;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class HexMythRegion extends Region
{
  public HexMythRegion(ResourceLocation name, int weight) {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
    this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
      // Add your biome without replacing the existing forest biome
      modifiedVanillaOverworldBuilder.addBiome(ModBiomes.CRYSTALLINE_FOREST);
    });
  }
}