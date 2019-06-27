package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

import ch.cpnv.angrywirds.Activities.GameActivity;

public class Words {
    private ArrayList<String> frenchWords = new ArrayList<String>();
    private ArrayList<String> englishWords = new ArrayList<String>();
    private ArrayList<String> allWords = new ArrayList<String>();;
    private BitmapFont font;
    private final int LINE_HEIGHT = 40;
    private boolean vue = false;

    public Words() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        frenchWords.add("Voiture");
        englishWords.add("Car");
        frenchWords.add("Maison");
        englishWords.add("Home");
    }

    public void addWord(String frenchWord, String englishWord){
        frenchWords.add(frenchWord);
        englishWords.add(englishWord);
    }

    public void changeVue(){ //Switch boolean de vue
        if(vue){
            vue = false;
        } else {
            vue = true;
        }
    }

    public void draw(Batch batch) {
        if(vue){ //Vue tous les mots
            font.draw(batch, "Tous les mots", GameActivity.WORLD_WIDTH/2, GameActivity.WORLD_HEIGHT-50); // Français à 1/3 de l'écran
            font.draw(batch, "Français", GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-100); // Français à 1/3 de l'écran
            font.draw(batch, "Anglais", GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-100); // Anglais à 2/3 de l'écran

            //Rajouter la liste de mots
            //Comparer avec les mots trouvés et les mettre en rouge si trouvé
        } else { //Vue mots trouvés
            font.draw(batch, "Mots trouvés", GameActivity.WORLD_WIDTH/2, GameActivity.WORLD_HEIGHT-50); // Français à 1/3 de l'écran
            font.draw(batch, "Français", GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-100); // Français à 1/3 de l'écran
            font.draw(batch, "Anglais", GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-100); // Anglais à 2/3 de l'écran

            for (String s : frenchWords){
                font.draw(batch, s, GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-200-frenchWords.indexOf(s)*LINE_HEIGHT);
            }

            for (String s : englishWords){
                font.draw(batch, s, GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-200-englishWords.indexOf(s)*LINE_HEIGHT);
            }
        }
    }
}
