package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker; import net.minecraft.client.Minecraft; import net.minecraft.client.gui.GuiGraphicsExtractor; import net.minecraft.network.chat.Component;
import net.simolclient.module.Module; import net.simolclient.util.GuiDraw;
public final class PotionHudModule extends Module {
 public PotionHudModule(){super("potion_hud","Potion Effects",Category.HUD,false);}
 public void renderHud(Minecraft c,GuiGraphicsExtractor g,DeltaTracker d){if(c.player==null)return; int y=120; for(var e:c.player.getActiveEffects()){String s=e.getEffect().value().getDisplayName().getString()+" "+(e.getAmplifier()+1); GuiDraw.text(g,c.font,Component.literal(s),8,y,0xFFFFFFFF); y+=14;}}
}
