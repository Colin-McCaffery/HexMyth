package net.hexmyth.world;

import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.hexmyth.world.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.ParameterPointListBuilder;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class HexMythRegion extends Region
{
  public HexMythRegion(ResourceLocation name, int weight) {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
    List<ParameterPoint> crystallineForestPoints = new ParameterPointListBuilder()
        .temperature(Temperature.NEUTRAL)
        .humidity(Humidity.NEUTRAL)
        .continentalness(Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND))
        .erosion(Erosion.EROSION_0)
        .depth(Depth.SURFACE)
        .weirdness(Weirdness.PEAK_NORMAL)
        .build();
    mapper.accept(Pair.of(crystallineForestPoints.get(0), ModBiomes.CRYSTALLINE_FOREST));
  }
}