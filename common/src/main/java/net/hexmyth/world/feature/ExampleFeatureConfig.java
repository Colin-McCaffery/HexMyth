package net.hexmyth.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record ExampleFeatureConfig(int number, ResourceLocation blockId) implements FeatureConfiguration {
  public static final Codec<ExampleFeatureConfig> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
              Codec.INT.fieldOf("number").forGetter(ExampleFeatureConfig::number),
              ResourceLocation.CODEC.fieldOf("blockID").forGetter(ExampleFeatureConfig::blockId))
          .apply(instance, ExampleFeatureConfig::new));
}