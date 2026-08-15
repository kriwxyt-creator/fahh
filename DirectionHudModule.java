package net.simolclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class SimolConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("simolclient.json");
    private static SimolConfig instance;

    public Map<String, Boolean> moduleStates = new HashMap<>();
    public boolean compactHud = false;

    public static SimolConfig get() {
        if (instance == null) instance = load();
        return instance;
    }

    private static SimolConfig load() {
        try {
            if (Files.exists(FILE)) {
                SimolConfig value = GSON.fromJson(Files.readString(FILE), SimolConfig.class);
                return value == null ? new SimolConfig() : value;
            }
        } catch (Exception e) {
            SimolClient.LOGGER.warn("Could not load config", e);
        }
        return new SimolConfig();
    }

    public void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(this));
        } catch (IOException e) {
            SimolClient.LOGGER.warn("Could not save config", e);
        }
    }

    public boolean isEnabled(String id, boolean def) {
        return moduleStates.getOrDefault(id, def);
    }

    public void setEnabled(String id, boolean enabled) {
        moduleStates.put(id, enabled);
        save();
    }
}
