package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.lang.reflect.Array;

import ch.cpnv.angrywirds.Activities.GameActivity;

public class Words {
    private static Array FoundWords;
    private BitmapFont font;

    public void Words() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
    }

    public void draw(Batch batch) {
        font.draw(batch, "Score: ", 200, 200);
        font.draw(batch, "Temps restant: ", 200, 240);
    }
}
