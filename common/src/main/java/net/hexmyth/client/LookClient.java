package net.hexmyth.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;

/**
 * This class is created to separate client-only code into a dedicated package.
 */
@Environment(EnvType.CLIENT)
public class LookClient {
    /**
     * Alters the tilt of the player's head.
     * @param pitch New pitch or {@code null}
     */
    public static void setLookPitch(float pitch) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setXRot(pitch);
    }
}
