package net.simolclient.module.impl.hud;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.simolclient.module.Module;
import net.simolclient.util.GuiDraw;
public final class KeystrokesModule extends Module {
    public KeystrokesModule(){super("keystrokes","Keystrokes",Category.HUD,false);}
    public void renderHud(Minecraft c, GuiGraphicsExtractor g, DeltaTracker d){
        int x=c.getWindow().getGuiScaledWidth()-72,y=c.getWindow().getGuiScaledHeight()-58;
        key(g,c,"W",x+24,y,c.options.keyUp.isDown());
        key(g,c,"A",x,y+20,c.options.keyLeft.isDown());
        key(g,c,"S",x+24,y+20,c.options.keyDown.isDown());
        key(g,c,"D",x+48,y+20,c.options.keyRight.isDown());
    }
    private void key(GuiGraphicsExtractor g,Minecraft c,String s,int x,int y,boolean down){
        GuiDraw.fill(g,x,y,x+20,y+18,down?0xFF3E8BFF:0xCC202631);
        GuiDraw.centered(g,c.font,Component.literal(s),x+10,y+5,0xFFFFFFFF);
    }
}
