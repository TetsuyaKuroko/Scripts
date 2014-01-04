package Fisher.Jobs;

import Fisher.Node;
import org.powerbot.script.methods.Hud;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: PamontB
 * Date: 1/3/14
 * Time: 11:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dropping extends Node {

    public Dropping(MethodContext ctx) {
        super(ctx);
    }

    public boolean validate(){
        return ctx.backpack.select().count() == 28 &&
                !ctx.players.local().isInMotion() && Fisher.Constants.DROPPING;
    }

    public void execute(){

        if(!ctx.hud.view(Hud.Window.BACKPACK)){
            ctx.hud.view(Hud.Window.BACKPACK);
        }

        if(ctx.combatBar.select().id(Fisher.AIOFisher.fishOne).isEmpty()){
            for(Item item : ctx.backpack.select().id(Fisher.AIOFisher.fishOne).first()){
                Point slotPoint = new Point(ctx.widgets.get(1430, 18).getCenterPoint().x,
                        ctx.widgets.get(1430, 18).getCenterPoint().y);
                ctx.mouse.move(item);
                ctx.mouse.drag(slotPoint, true);
                sleep(1500);
            }
        }

        if(ctx.combatBar.select().id(Fisher.AIOFisher.fishTwo).isEmpty()){
            for(Item item : ctx.backpack.select().id(Fisher.AIOFisher.fishTwo).first()){
                Point slotPoint = new Point(ctx.widgets.get(1430, 17).getCenterPoint().x,
                        ctx.widgets.get(1430, 17).getCenterPoint().y);
                ctx.mouse.move(item);
                ctx.mouse.drag(slotPoint, true);
                sleep(1500);
            }
        }


        for(Item item : ctx.backpack.select().id(Fisher.AIOFisher.fishOne)){
            if(ctx.widgets.get(1186, 3).isVisible()){
                ctx.keyboard.send("{VK_SPACE down}");
                ctx.keyboard.send("{VK_SPACE up}");
            }
            if(ctx.backpack.contains(item)){
                for(int i=0; i<200 ; i++){
                ctx.keyboard.send("{VK_1 down}");
                ctx.keyboard.send("{VK_1 up}");
                }
            }
        }
        for(Item item : ctx.backpack.select().id(Fisher.AIOFisher.fishTwo)){
            if(ctx.widgets.get(1186, 3).isVisible()){
                ctx.keyboard.send("{VK_SPACE down}");
                ctx.keyboard.send("{VK_SPACE up}");
            }
            if(ctx.backpack.contains(item)){
                for(int i=0; i<200 ; i++){
                ctx.keyboard.send("{VK_2 down}");
                ctx.keyboard.send("{VK_2 up}");
                }
            }
        }
    }

    public String getStatus() {
        return "Dropping Fish...";
    }

}