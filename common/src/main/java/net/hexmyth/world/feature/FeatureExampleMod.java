package net.hexmyth.world.feature;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class FeatureExampleMod implements ModInitializer {

  public static final ResourceLocation EXAMPLE_FEATURE_ID = new ResourceLocation("tutorial", "example_feature");
  public static final ExampleFeature EXAMPLE_FEATURE = new ExampleFeature(ExampleFeatureConfig.CODEC);

  public static final ConfiguredFeature<ExampleFeatureConfig, ExampleFeature> EXAMPLE_FEATURE_CONFIGURED = new ConfiguredFeature<>(
      EXAMPLE_FEATURE,
      new ExampleFeatureConfig(10, new ResourceLocation("minecraft", "netherite_block")));

  @Override
  public void onInitialize() {
    Registry.register(Registry.FEATURE, EXAMPLE_FEATURE_ID, EXAMPLE_FEATURE);
    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, EXAMPLE_FEATURE_ID, EXAMPLE_FEATURE_CONFIGURED);
  }
}