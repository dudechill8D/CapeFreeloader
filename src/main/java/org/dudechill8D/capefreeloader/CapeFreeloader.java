package org.dudechill8D.capefreeloader;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapeFreeloader implements ModInitializer {
    public static final String MOD_ID = "capefreeloader";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Cape Freeloader");
    }
}