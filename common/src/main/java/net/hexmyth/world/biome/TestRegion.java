
/**
 * Copyright (C) Glitchfiend
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.hexmyth.world.biome;

import com.mojang.datafixers.util.Pair;
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

public class TestRegion extends Region
{
  public TestRegion(ResourceLocation name, int weight)
  {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
  {
    this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
      // Simple example:
      // Replace the Vanilla desert with our hot_red biome
      builder.replaceBiome(Biomes.DESERT, TestBiomes.HOT_RED);

      // More complex example:
      // Replace specific parameter points for the frozen peaks with our cold_blue biome
      List<Climate.ParameterPoint> frozenPeaksPoints = new ParameterPointListBuilder()
          .temperature(Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL)
          .humidity(Humidity.ARID, Humidity.DRY, Humidity.NEUTRAL, Humidity.WET, Humidity.HUMID)
          .continentalness(Continentalness.span(Continentalness.COAST, Continentalness.FAR_INLAND), Continentalness.span(Continentalness.MID_INLAND, Continentalness.FAR_INLAND))
          .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
          .depth(Depth.SURFACE, Depth.FLOOR)
          .weirdness(Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
          .build();

      frozenPeaksPoints.forEach(point -> builder.replaceBiome(point, TestBiomes.COLD_BLUE));
    });
  }
}
