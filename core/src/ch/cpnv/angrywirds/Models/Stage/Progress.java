package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

import ch.cpnv.angrywirds.Activities.GameActivity;

public class Progress {

    private BitmapFont font;
    private ArrayList<String> frenchWord = new ArrayList<String>();
    private ArrayList<String> englishWord = new ArrayList<String>();

    public Progress () {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        addFrenchWord("toto");
        addEnglishWord("tata");
    }

    public void addFrenchWord(String french){
        frenchWord.add(french);
    }

    public void addEnglishWord(String english){
        englishWord.add(english);
    }

    public void draw(Batch batch)
    {
        font.draw(batch, "Français", GameActivity.WORLD_WIDTH-1200, GameActivity.WORLD_HEIGHT-300);
        font.draw(batch, "Anglais", GameActivity.WORLD_WIDTH-500, GameActivity.WORLD_HEIGHT-300);

        for(String s: frenchWord){
            font.draw(batch, ""+s, GameActivity.WORLD_WIDTH-1200, GameActivity.WORLD_HEIGHT-220);
        }

        for(String s: englishWord){
            font.draw(batch, ""+s, GameActivity.WORLD_WIDTH-500, GameActivity.WORLD_HEIGHT-220);
        }
    }
}
