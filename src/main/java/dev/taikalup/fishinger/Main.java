package dev.taikalup.fishinger;

import dev.taikalup.fishinger.fishing.FishingManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("template");
    public static final String VERSION = /*$ mod_version*/ "0.1.0";
    public static final String MINECRAFT = /*$ minecraft*/ "26.2";

    public static final FishingManager FISHING_MANAGER = new FishingManager();

    @Override
    public void onInitialize() {
        LOGGER.info("Fishinger version: " + VERSION);

        ClientTickEvents.END_CLIENT_TICK.register((Minecraft client) -> {
            if (client.player == null || client.level == null) return;
            FISHING_MANAGER.tick(client);
        });
    }

    /**
     * Adapts to the {@link Identifier} changes introduced in 1.21.
     */
    public static Identifier id(String namespace, String path) {
        //? if <1.21 {
        /*return new Identifier(namespace, path);
        *///?} else
        return Identifier.fromNamespaceAndPath(namespace, path);
    }
}