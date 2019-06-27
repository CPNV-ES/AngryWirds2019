package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.Activities.Play;

/**
 * Created by Xavier on 06.05.18.
 */

public final class Bourd extends MovingObject {

    private enum BirdState { init, aim, fly }

    private static final String PICNAME = "bourd.png";
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private BirdState state = BirdState.init;
    public static boolean activated = false;

    public Bourd() {
        super(new Vector2(Play.TWEETY_START_X+120, Play.TWEETY_START_Y), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
    }

    @Override
    public void unFreeze() {
        super.unFreeze();
        state = BirdState.fly;
    }

    @Override
    public void accelerate(float dt) {

        if (state == BirdState.fly) speed.y -= MovingObject.G * dt;
    }

    public void reset() {
        setX(Play.TWEETY_START_X);
        setY(Play.TWEETY_START_Y);
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
