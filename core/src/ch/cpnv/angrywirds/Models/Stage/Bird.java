package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.Activities.Play;

/**
 * Created by Xavier on 06.05.18.
 */

public final class Bird extends MovingObject {

    private enum BirdState { init, aim, fly }

    private static final String PICNAME = "bird.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private BirdState state = BirdState.init;
    public static boolean activated = false;
    public static boolean bounced = true;
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //public Bird()
     public Bird(String name, int id, float x, float y, String picname){
        super(new Vector2(x, y), WIDTH, HEIGHT, picname, new Vector2(0,0));
        // super(new Vector2(Play.TWEETY_START_X, Play.TWEETY_START_Y), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
         this.name = name;
         this.id = id;

    }

    @Override
    public void unFreeze() {
        super.unFreeze();
        state = BirdState.fly;
    }

    public void bouncX()
    {
        if (bounced)
        {
            speed.x -= (speed.x * 1.5); // bounced
            Gdx.app.log("HAHA", this.speed.x+"   Vitesse en X");
            bounced = false;
        }


    }

    public void rollY()
    {
        speed.y = 0; // bounced
    }


    @Override
    public void accelerate(float dt) {
        if (state == BirdState.fly) speed.y -= MovingObject.G * dt;
    }

    public void reset() {
        setX(Play.TWEETY_START_X);
        setY(Play.TWEETY_START_Y);
        bounced = true;
        freeze();
    }

    public void aim(float x, float y)
    {

    }

    public void activate()
    {
        this.activated = true;
    }

    public void desactivted()
    {
        this.activated = false;
    }
}
