package net.hexmyth.block;

import net.hexmyth.world.feature.tree.CrystallineTreeGrower;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.material.Material;

public class CrystallineSapling extends SaplingBlock {

  private static final AbstractTreeGrower CrystallineTree = new CrystallineTreeGrower();

  public CrystallineSapling() {
    super(CrystallineTree, Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
  }


}