package ch.cpnv.angrywirds.Models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Xavier on 06.05.18.
 */

public final class Bird extends MovingObject {

    private static final String PICNAME = "bird.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Bird(float positionX, float positionY, Vector2 speed) {
        super(positionX, positionY, WIDTH, HEIGHT, PICNAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        speed.y -= MovingObject.G * dt;
    }

}
