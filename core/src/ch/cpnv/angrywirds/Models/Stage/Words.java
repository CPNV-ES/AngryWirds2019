package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.cpnv.angrywirds.Activities.GameActivity;

public class Words {
    private ArrayList<String> frenchWords = new ArrayList<String>();;
    private ArrayList<String> englishWords = new ArrayList<String>();;
    private BitmapFont font;
    private final int LINE_HEIGHT = 40;

    public Words() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        frenchWords.add("test");
    }

    public void addWord(String frenchWord, String englishWord){
        frenchWords.add(frenchWord);
        englishWords.add(englishWord);
    }

    public void draw(Batch batch) {
        font.draw(batch, "Mots trouvés", GameActivity.WORLD_WIDTH/2, GameActivity.WORLD_HEIGHT-50); // Français à 1/3 de l'écran
        font.draw(batch, "Français", GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-100); // Français à 1/3 de l'écran
        font.draw(batch, "Anglais", GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-100); // Anglais à 2/3 de l'écran

        for (String s : frenchWords){
            font.draw(batch, s, GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-150);
        }

        for (String s : englishWords){
            font.draw(batch, s, GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-150);
        }
    }
}
