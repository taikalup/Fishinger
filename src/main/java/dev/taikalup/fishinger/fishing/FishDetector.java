package dev.taikalup.fishinger.fishing;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ArmorStand;

public class FishDetector {

    public static boolean hasFishBite(Minecraft client) {

        if (client.player == null ||
                client.player.fishing == null ||
                client.level == null) {
            return false;
        }

        for (Entity entity : client.level.entitiesForRendering()) {

            if (!(entity instanceof ArmorStand stand)) {
                continue;
            }

            if (!stand.isInvisible()) {
                continue;
            }

            if (!stand.hasCustomName()) {
                continue;
            }

            if (!stand.isCustomNameVisible()) {
                continue;
            }
            if (!client.player.fishing
                    .getBoundingBox()
                    .inflate(4.0D)
                    .contains(stand.position())) {
                continue;
            }

            String name = stand.getCustomName().getString();

            if (name.equals("!!!")) {
                return true;
            }
        }

        return false;
    }
}