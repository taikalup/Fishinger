package dev.taikalup.fishinger.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;

public class RightClickUtil {

    public static void rightClick() {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null || client.gameMode == null) return;

        client.gameMode.useItem(client.player, InteractionHand.MAIN_HAND);
    }
}