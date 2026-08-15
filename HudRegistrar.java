package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class FpsHudModule extends Module {
    public FpsHudModule() { super("fps_hud","FPS",Category.HUD,true); }
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d) {
        int fps = invokeInt(c, "getFps", "getCurrentFps");
        GuiDraw.text(g,c.font,Component.literal(fps+" FPS"),8,8,0xFFFFFFFF);
    }
    static int invokeInt(Object o, String... names) {
        for (String n:names) try { Object v=o.getClass().getMethod(n).invoke(o); if(v instanceof Number) return ((Number)v).intValue(); } catch(Throwable ignored){}
        return 0;
    }
}
