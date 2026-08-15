package net.simolclient.module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public abstract class Module {
    private final String id;
    private final String name;
    private final Category category;
    private boolean enabled;

    protected Module(String id, String name, Category category, boolean defaultEnabled) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.enabled = defaultEnabled;
    }

    public String id() { return id; }
    public String name() { return name; }
    public Category category() { return category; }
    public boolean enabled() { return enabled; }

    public void setEnabled(boolean value) {
        if (enabled == value) return;
        enabled = value;
        if (value) onEnable(); else onDisable();
    }

    public void toggle() { setEnabled(!enabled); }
    protected void onEnable() {}
    protected void onDisable() {}

    public void renderHud(Minecraft client, GuiGraphicsExtractor graphics, DeltaTracker delta) {}

    public enum Category { HUD, PERFORMANCE, VISUAL, MISC }
}
