package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Button {
    private String message;
    private Sprite sprite;
    private BitmapFont font;
    private static final String PICNAME = "button.png";
    public static final int WIDTH = 200;
    public static final int HEIGHT = 60;
    private int id;

    public Button(float x, float y, String message, int id)
    {
        this.id = id;
        sprite = new Sprite(new Texture(PICNAME));
        sprite.setBounds(x, y, WIDTH, HEIGHT);
        this.message = message;
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
    }

    /*public Button(float width, float height, String message, Vector2 position)
    {
        super(position, width, height, PICNAME);
        //sprite = new Sprite(new Texture(PICNAME));
        //sprite.setBounds(x, y, WIDTH, HEIGHT);
        this.message = message;
        //font = new BitmapFont();
        //font.setColor(Color.WHITE);
        //font.getData().setScale(2);
    }*/

    public void draw(Batch batch)
    {
        sprite.draw(batch);
        font.draw(batch, message, sprite.getX() + 50, sprite.getY() + 50);
    }

    public Sprite getSprite () {return sprite;}
    public int getId() { return id; }
}
