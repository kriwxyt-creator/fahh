package net.simolclient.module.impl.hud;
import java.time.LocalTime; import java.time.format.DateTimeFormatter;
import net.minecraft.client.DeltaTracker; import net.minecraft.client.Minecraft; import net.minecraft.client.gui.GuiGraphicsExtractor; import net.minecraft.network.chat.Component;
import net.simolclient.module.Module; import net.simolclient.util.GuiDraw;
public final class ClockHudModule extends Module {
 public ClockHudModule(){super("clock_hud","Clock",Category.HUD,false);}
 public void renderHud(Minecraft c,GuiGraphicsExtractor g,DeltaTracker d){GuiDraw.text(g,c.font,Component.literal(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))),8,72,0xFFFFFFFF);}
}
