package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class ArmorHudModule extends Module {
    public ArmorHudModule(){super("armor_hud","Armor",Category.HUD,true);}
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d){
        if(c.player==null)return;
        int y=8;
        for(var stack:c.player.getInventory().armor){
            if(stack.isEmpty())continue;
            String s=stack.getHoverName().getString()+" "+(stack.getMaxDamage()-stack.getDamageValue());
            GuiDraw.text(g,c.font,Component.literal(s),c.getWindow().getGuiScaledWidth()-180,y,0xFFFFFFFF);
            y+=16;
        }
    }
}
