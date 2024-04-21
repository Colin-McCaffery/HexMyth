package net.hexmyth.block;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.material.Material;
import net.hexmyth.world.feature.tree.CrystallineTree;

public class CrystallineSapling extends SaplingBlock {

  private static final AbstractTreeGrower CrystallineTree = new CrystallineTree();

  public CrystallineSapling() {
    super(CrystallineTree, Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
  }


}