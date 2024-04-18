package net.hexmyth.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class TestRegion extends Region
{
  public TestRegion(ResourceLocation name, int weight)
  {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
  {
    VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
    new ParameterPointListBuilder()
        .temperature(Temperature.NEUTRAL)
        .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
        .continentalness(Continentalness.FAR_INLAND)
        .erosion(Erosion.EROSION_6)
        .depth(Depth.SURFACE, Depth.FLOOR)
        .weirdness(Weirdness.VALLEY)
        .build().forEach(point -> builder.add(point, TestBiomes.CRYSTALLINE_FOREST));
    builder.build().forEach(mapper);
  }
}