package net.hexmyth.client;

import at.petrak.hexcasting.xplat.IClientXplatAbstractions;
import net.minecraft.client.renderer.RenderType;
import net.hexmyth.registry.HexMythBlockRegistry;

public class RegisterClient {

  public static void init() {
    var x = IClientXplatAbstractions.INSTANCE;
    x.setRenderLayer(HexMythBlockRegistry.CRYSTALLINE_LEAVES.get(), RenderType.translucent());
    x.setRenderLayer(HexMythBlockRegistry.CRYSTALLINE_SAPLING.get(), RenderType.cutoutMipped());
  }
}