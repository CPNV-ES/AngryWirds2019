package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Button {

    private Sprite sprite;

    public Button(Texture texture, float x, float y, float width, float height) {
        sprite = new Sprite(texture);
        sprite.setPosition(x,y);
        sprite.setSize(width,height);
    }

    public void draw(Batch batch)
    {
        sprite.draw(batch);
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }
}
