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

    private static final int LEFT_COLUMN_X = GameActivity.WORLD_WIDTH / 2;
    private static final int RIGHT_COLUMN_X = 3* GameActivity.WORLD_WIDTH / 4;
    private static final int ROW_HEIGHT = 40;
    private static final int TOP_MARGIN = 100;


    private String word;
    private ShowMode mode;
    private int row;
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
        this.row = row;
        font= new BitmapFont();
        font.getData().setScale(1.5f);
        switch (mode) {
            case Primary:
                font.setColor(Color.LIGHT_GRAY);
                break;
            case Secondary:
                font.setColor(Color.LIGHT_GRAY);
                break;
            case SecondaryTrained:
                font.setColor(Color.BLACK);
                break;
        }
    }

    public void draw(Batch batch)
    {
        switch (this.mode) {
            case Primary:
                font.draw(batch, word, LEFT_COLUMN_X, GameActivity.WORLD_HEIGHT-this.row*ROW_HEIGHT-TOP_MARGIN);
                break;
            case Secondary:
            case SecondaryTrained:
                font.draw(batch, word, RIGHT_COLUMN_X, GameActivity.WORLD_HEIGHT-this.row*ROW_HEIGHT-TOP_MARGIN);
                break;
        }
    }
}
