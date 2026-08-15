package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class CoordsHudModule extends Module {
    public CoordsHudModule(){super("coords_hud","Coordinates",Category.HUD,false);}
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d){
        if(c.player==null)return;
        String s=String.format("XYZ: %.1f %.1f %.1f",c.player.getX(),c.player.getY(),c.player.getZ());
        GuiDraw.text(g,c.font,Component.literal(s),8,56,0xFFFFFFFF);
    }
}
