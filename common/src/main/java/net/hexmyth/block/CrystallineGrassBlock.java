package net.hexmyth.block;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrystallineGrassBlock extends Block {

  public CrystallineGrassBlock() {
    super(Properties.of(Material.DIRT).strength(1.0F).sound(SoundType.AMETHYST));
  }
}