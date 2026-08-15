package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class CpsHudModule extends Module {
    private long lastClick;
    private int clicks;
    private int cps;
    public CpsHudModule(){super("cps_hud","CPS",Category.HUD,false);}
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d){
        long now=System.currentTimeMillis();
        if(c.mouseHandler.isLeftPressed() && now-lastClick>90){ clicks++; lastClick=now; }
        if(now-lastClick>1000){ cps=clicks; clicks=0; lastClick=now; }
        GuiDraw.text(g,c.font,Component.literal("CPS: "+cps),8,24,0xFFFFFFFF);
    }
}
