package ch.cpnv.angrywirds.Models;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Contains all the static items to display in our world
 * Created by Xavier on 12.05.18.
 */

public final class Scenery {

    private ArrayList<PhysicalObject> scene;

    public Scenery() {
        scene = new ArrayList<PhysicalObject>();
    }

    public void addElement (PhysicalObject el) throws Exception
    {
        for (PhysicalObject o : scene)
            if (el.collidesWith(o))
                throw new Exception("No can do !!!!");
        scene.add(el);
    }

    public void draw(Batch batch)
    {
        for (PhysicalObject p : scene) p.draw(batch);
    }

    /**
     * Returns the object of the scenary that object o has hit (null if none)
     * @param o
     * @return
     */
    public PhysicalObject collidesWith(PhysicalObject o)
    {
        for (PhysicalObject el : scene)
            if (el.collidesWith(o))
                return el;
        return null;
    }
}
