package ch.cpnv.angrywirds.Models;


import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.AngryWirds;

/**
 * Created by Xavier on 06.05.18.
 */

public final class Wasp extends MovingObject {

    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Wasp(float positionX, float positionY, Vector2 speed) {
        super(positionX, positionY, WIDTH, HEIGHT, PICNAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        // The wasp only slightly alters its speed at random. It is subject to gravity, but it counters it with its flight
        speed.x += (AngryWirds.alea.nextFloat()*2-1);
        speed.y += (AngryWirds.alea.nextFloat()*2-1);
    }

}
