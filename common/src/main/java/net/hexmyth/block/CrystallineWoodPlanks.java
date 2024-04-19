package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineWoodPlanks extends Block {

  public CrystallineWoodPlanks() {
    super(Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.AMETHYST));
  }
}
