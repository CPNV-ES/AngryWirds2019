package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Xavier on 12.05.18.
 */

public final class ShownWord {

    private static final String PICNAME = "slate.png";
    private static final int WIDTH = 260;
    private static final int HEIGHT = 160;
    private static final int TEXT_OFFSET_X = 40; // to place the text inside the bubble
    private static final int TEXT_OFFSET_Y = 100;
    private static final int SHRINKING_TIME = 1;

    private String word;
    private float scale; // for shrinking
    private Sprite sprite;
    private BitmapFont font;

    /**
     * Bubble will appear for the pig located at x,y
     *
     * @param x
     * @param y
     * @param word
     */
    public ShownWord(float x, float y, String word) {
        this.word = word;
        this.scale = SHRINKING_TIME*1000;
        sprite = new Sprite(new Texture(PICNAME));
        sprite.setBounds(x, y, WIDTH, HEIGHT);
        font= new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void shrink(float dt)
    {
        if (this.scale > 0)
            this.scale -= dt;
        else
            this.scale = 0;
    }

    public void draw(Batch batch)
    {
        sprite.draw(batch);
        font.draw(batch, word, sprite.getX()+TEXT_OFFSET_X, sprite.getY()+TEXT_OFFSET_Y);
    }
}
