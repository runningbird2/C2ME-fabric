package com.ishland.c2me.rewrites.chunksystem;

import com.ishland.c2me.rewrites.chunksystem.common.Config;
import net.fabricmc.loader.api.FabricLoader;

public class ModuleEntryPoint {

    /**
     * Worldthreader and C2ME chunk-system rewrite both alter chunk/POI threading behavior.
     * Disable this module when worldthreader is present to avoid POI storage races.
     */
    private static final boolean enabled = !FabricLoader.getInstance().isModLoaded("worldthreader");

    static {
        if (enabled) {
            Config.init();
        }
    }

}
