package net.hexmyth.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineLeaves extends Block {

  public CrystallineLeaves() {
    super(Properties.of(Material.LEAVES).noOcclusion().strength(0.3F).sound(SoundType.AMETHYST));
  }
}
