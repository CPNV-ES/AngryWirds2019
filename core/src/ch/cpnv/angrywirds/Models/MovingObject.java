package ch.cpnv.angrywirds.Models;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Xavier on 06.05.18.
 */

public abstract class MovingObject extends PhysicalObject {

    public final static float G = 10; // Gravity, for objects that fall

    protected Vector2 speed;

    public MovingObject(float positionX, float positionY, float width, float height, String picname, Vector2 speed) {
        super(positionX, positionY, width, height, picname);
        this.speed = speed;
    }

    // the accelerate method implements the speed change, which depends on the physics of the derived object, reason why it is abstract here
    public abstract void accelerate(float dt);

    // Make the object move according to its own speed
    public final void move(float dt)
    {
        translate(speed.x * dt,speed.y * dt);
    }

    @Override
    public final String toString()
    {
        return getClass().getSimpleName()+" at ("+this.getX()+","+this.getY()+"), moving at ("+speed.x+","+speed.y+")";
    }

}
