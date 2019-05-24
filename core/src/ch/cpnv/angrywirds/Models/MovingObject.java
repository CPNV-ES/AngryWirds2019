package ch.cpnv.angrywirds.Models;

import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.AngryWirds;

/**
 * Created by Xavier on 06.05.18.
 */

public abstract class MovingObject extends PhysicalObject {

    public final static float G = 100; // Gravity, for objects that fall

    protected Vector2 speed;
    protected boolean frozen; // Allows to temporarily freeze the movement

    public MovingObject(Vector2 position, float width, float height, String picname, Vector2 speed) {
        super(position, width, height, picname);
        this.speed = speed;
    }

    // the accelerate method implements the speed change, which depends on the physics of the derived object, reason why it is abstract here
    public abstract void accelerate(float dt);

    // Make the object move according to its own speed
    public final void move(float dt)
    {
        if (!frozen) this.translate(speed.x * dt, speed.y * dt);
    }

    public void update(float dt)
    {
        if (!frozen)
        {
            accelerate(dt);
            move(dt);
        }
    }

    public void freeze() {
        this.frozen = true;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void unFreeze() {
        this.frozen = false;
    }

    public final void stop()
    {
        speed.x = 0; // Calm down
        speed.y = 0;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    @Override
    public final String toString()
    {
        return getClass().getSimpleName()+" at ("+this.getX()+","+this.getY()+"), moving at ("+speed.x+","+speed.y+")";
    }

}
