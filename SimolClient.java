package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker; import net.minecraft.client.Minecraft; import net.minecraft.client.gui.GuiGraphicsExtractor; import net.minecraft.network.chat.Component;
import net.simolclient.module.Module; import net.simolclient.util.GuiDraw;
public final class SprintHudModule extends Module {
 public SprintHudModule(){super("sprint_hud","Sprint",Category.HUD,false);}
 public void renderHud(Minecraft c,GuiGraphicsExtractor g,DeltaTracker d){if(c.player==null)return; GuiDraw.text(g,c.font,Component.literal(c.player.isSprinting()?"SPRINTING":"WALKING"),8,104,c.player.isSprinting()?0xFF66FF99:0xFFB0B8C4);}
}
