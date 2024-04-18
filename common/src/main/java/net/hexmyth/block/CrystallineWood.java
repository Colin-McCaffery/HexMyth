package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineWood extends Block {

  public CrystallineWood() {
    super(Properties.of(Material.WOOD).strength(1.4F).sound(SoundType.AMETHYST));
  }
}
