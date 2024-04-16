
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