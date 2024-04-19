package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineWood extends RotatedPillarBlock {

  public CrystallineWood() {
    super(Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.AMETHYST));
  }
}
