package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker; import net.minecraft.client.Minecraft; import net.minecraft.client.gui.GuiGraphicsExtractor; import net.minecraft.network.chat.Component;
import net.simolclient.module.Module; import net.simolclient.util.GuiDraw;
public final class DirectionHudModule extends Module {
 public DirectionHudModule(){super("direction_hud","Direction",Category.HUD,false);}
 public void renderHud(Minecraft c,GuiGraphicsExtractor g,DeltaTracker d){if(c.player==null)return; String s=c.player.getDirection().getName().toUpperCase(); GuiDraw.text(g,c.font,Component.literal(s),8,88,0xFFFFFFFF);}
}
