package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineSapling extends Block {

  public CrystallineSapling() {
    super(Properties.of(Material.PLANT).strength(0.1F).sound(SoundType.AMETHYST));
  }
}
