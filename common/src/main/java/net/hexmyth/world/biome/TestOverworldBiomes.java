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

import java.util.Collections;
import java.util.List;
import net.hexmyth.world.feature.tree.CrystallineTreeFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;

import javax.annotation.Nullable;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class TestOverworldBiomes
{
  @Nullable
  private static final Music NORMAL_MUSIC = null;
  private static final TreeConfiguration CRYSTALLINE_TREE_CONFIG = CrystallineTreeFeature.CRYSTALLINE_TREE_CONFIG;

  protected static int calculateSkyColor(float color)
  {
    float $$1 = color / 3.0F;
    $$1 = Mth.clamp($$1, -1.0F, 1.0F);
    return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
  }

  private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
  {
    return biome(precipitation, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
  }

  private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
  {
    return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
  }

  private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
  {
    BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
    BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
    BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
    BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
    BiomeDefaultFeatures.addDefaultSprings(builder);
    BiomeDefaultFeatures.addSurfaceFreezing(builder);
  }

  public static Biome crystalline_forest()
  {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    // The below code is just to add a tree :(
    ConfiguredFeature<TreeConfiguration, TreeFeature> configuredFeature = new ConfiguredFeature<>(new CrystallineTreeFeature(), CRYSTALLINE_TREE_CONFIG);
    ResourceLocation resourceLocation = new ResourceLocation(TestMod.MOD_ID, "crystalline_tree");
    ResourceKey<ConfiguredFeature<?, ?>> key = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, resourceLocation);
    BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, key.location(), configuredFeature);
    Holder<ConfiguredFeature<?, ?>> featureHolder = Holder.Reference.createStandAlone(BuiltinRegistries.CONFIGURED_FEATURE, key);
    List<PlacementModifier> placementModifiers = Collections.singletonList(PlacementUtils.HEIGHTMAP_WORLD_SURFACE);
    new PlacedFeature(featureHolder, placementModifiers);
    Holder<PlacedFeature> placedFeatureHolder = Holder.Reference.createStandAlone(BuiltinRegistries.PLACED_FEATURE, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,  resourceLocation));
    biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, placedFeatureHolder);

    return biome(Precipitation.NONE, 0.7F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
  }
}