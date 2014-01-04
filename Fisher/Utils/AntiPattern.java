package Fisher.Utils;
import Fisher.Node;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;


public class AntiPattern extends Node {

    public AntiPattern(MethodContext ctx) {
        super(ctx);
    }

    public boolean validate(){
        return ctx.game.isLoggedIn();
    }

    public void execute() {
        int anti = Random.nextInt(0, 30);
        switch(anti) {

            case 1:

                ctx.camera.setAngle(Random.nextInt(5, 150));
                sleep(800, 1500);
                break;

            case 2:

                ctx.camera.setPitch(Random.nextInt(45, 80));
                sleep(800, 1700);
                break;

            case 3:

                ctx.mouse.move(Random.nextInt(5, 200), Random.nextInt(40, 400));
                sleep(900, 1600);
                ctx.mouse.move(Random.nextInt(3, 500), Random.nextInt(5, 400));
                break;

            case 4:

                sleep(1000, 4000);
                break;

            case 5:
                for(GameObject object : ctx.objects.select().first()) {
                    if(object.isOnScreen()) {

                        object.hover();
                        sleep(750, 1500);
                    }
                }
                break;
        }
    }

    public String getStatus() {
        return "AntiPattern...";
    }
}
