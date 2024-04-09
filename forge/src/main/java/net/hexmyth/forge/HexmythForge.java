package net.hexmyth.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexmyth.Hexmyth;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(Hexmyth.MOD_ID)
public class HexmythForge {
    public HexmythForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Hexmyth.MOD_ID, bus);
        bus.addListener(HexmythClientForge::init);
        Hexmyth.init();
    }
}
