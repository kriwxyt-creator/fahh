package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class PingHudModule extends Module {
    public PingHudModule(){super("ping_hud","Ping",Category.HUD,false);}
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d){
        int ping=-1;
        try{
            if(c.getConnection()!=null && c.getUser()!=null && c.getConnection().getPlayerInfo(c.getUser().getProfileId())!=null)
                ping=c.getConnection().getPlayerInfo(c.getUser().getProfileId()).getLatency();
        }catch(Throwable ignored){}
        GuiDraw.text(g,c.font,Component.literal("Ping: "+(ping<0?"-":ping+" ms")),8,40,0xFFFFFFFF);
    }
}
