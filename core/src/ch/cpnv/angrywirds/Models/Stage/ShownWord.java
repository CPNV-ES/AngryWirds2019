package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.angrywirds.Activities.GameActivity;
import ch.cpnv.angrywirds.AngryWirds;

/**
 * Created by Xavier on 12.05.18.
 */

public final class ShownWord {

    public enum ShowMode { Primary, Secondary, SecondaryTrained}

    private static final String PICNAME = "slate.png";
    private static final int WIDTH = 260;
    private static final int HEIGHT = 40;
    private static final int TEXT_OFFSET_X = 40; // to place the text inside the slate
    private static final int TEXT_OFFSET_Y = 100;
    private static final int LEFT_COLUMN_X = GameActivity.WORLD_WIDTH / 3;
    private static final int RIGHT_COLUMN_X = 2* GameActivity.WORLD_WIDTH / 3;
    private static final int ROW_HEIGHT = 50;


    private String word;
    private ShowMode mode;
    private Sprite sprite;
    private BitmapFont font;

    /**
     * Bubble will appear for the pig located at x,y
     *
     * @param row
     * @param word
     */
    public ShownWord(int row, String word, ShowMode mode) {
        this.word = word;
        this.mode = mode;
        sprite = new Sprite(new Texture(PICNAME));
        font= new BitmapFont();
        font.getData().setScale(2);
        switch (mode) {
            case Primary:
                sprite.setBounds(LEFT_COLUMN_X, GameActivity.WORLD_HEIGHT - row * ROW_HEIGHT, WIDTH, HEIGHT);
                font.setColor(Color.BLACK);
                break;
            case Secondary:
                sprite.setBounds(RIGHT_COLUMN_X, GameActivity.WORLD_HEIGHT - row * ROW_HEIGHT, WIDTH, HEIGHT);
                font.setColor(Color.BLACK);
                break;
            case SecondaryTrained:
                sprite.setBounds(RIGHT_COLUMN_X, GameActivity.WORLD_HEIGHT - row * ROW_HEIGHT, WIDTH, HEIGHT);
                font.setColor(Color.LIGHT_GRAY);
                break;
        }
    }

    public void draw(Batch batch)
    {
        sprite.draw(batch);
        font.draw(batch, word, sprite.getX()+TEXT_OFFSET_X, sprite.getY()+TEXT_OFFSET_Y);
    }
}
