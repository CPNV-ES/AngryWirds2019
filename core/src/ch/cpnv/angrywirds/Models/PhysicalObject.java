package ch.cpnv.angrywirds.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Xavier on 03.05.18.
 */

public class PhysicalObject extends Sprite{

    public PhysicalObject(float positionX, float positionY, float width, float height, String picname) {
        super(new Texture(picname));
        setBounds(positionX, positionY, width, height);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName()+" at ("+this.getX()+","+this.getY()+")";
    }

}
