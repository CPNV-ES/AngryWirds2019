package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.angrywirds.Models.Data.Word;

public class WordProgress {
    private static final String PICNAME = "word.png";
    private static final int WIDTH = 260;
    private static final int HEIGHT = 150;
    private static final int TEXT_OFFSET_X = 40; // to place the text inside the bubble
    private static final int TEXT_OFFSET_Y = 50;

    private String value1;
    private String value2;
    private Sprite sprite;
    private BitmapFont font;
    public String picname;

    public WordProgress(float x, float y, String value1, String value2, String picname) {
        this.value1 = value1;
        this.value2 = value2;
        this.picname = picname;
        sprite = new Sprite(new Texture(picname));
        sprite.setBounds(x, y, WIDTH, HEIGHT);
        font= new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
    }
    public void draw(Batch batch)
    {
        String message = value1+ " - " + value2;
        sprite.draw(batch);
        font.draw(batch, message, sprite.getX()+TEXT_OFFSET_X, sprite.getY()+TEXT_OFFSET_Y+50);

    }

    public Sprite getSprite() {
        return sprite;
    }

}
