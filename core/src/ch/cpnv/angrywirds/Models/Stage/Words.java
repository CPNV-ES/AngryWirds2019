package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;

import ch.cpnv.angrywirds.Activities.GameActivity;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class Words {
    private ArrayList<String> frenchWords = new ArrayList<String>();
    private ArrayList<String> englishWords = new ArrayList<String>();
    private BitmapFont font;
    private final int LINE_HEIGHT = 40;
    private boolean vue = false;
    private Vocabulary vocabulary; // The vocabulary we train

    public Words() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);
        vocabulary = VocProvider.vocabularies.get(0); // hardcoded for now

//        frenchWords.add("Voiture");
//        englishWords.add("Car");
//        frenchWords.add("Maison");
//        englishWords.add("Home");
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
            for (Word w : vocabulary.getWords()){
                for (String s : frenchWords){
                    if(w.getValue1() == s) //Mot trouvé
                    {
                        font.draw(batch, "Trouvé", GameActivity.WORLD_WIDTH/4, GameActivity.WORLD_HEIGHT-200-vocabulary.getWords().indexOf(w)*LINE_HEIGHT);
                        font.draw(batch, w.getValue1(), GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-200-vocabulary.getWords().indexOf(w)*LINE_HEIGHT);
                        font.draw(batch, w.getValue2(), GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-200-vocabulary.getWords().indexOf(w)*LINE_HEIGHT);
                    } else if(frenchWords.size()-1 == frenchWords.indexOf(s)) { // Si c'est le dernier mot, il n'as pas été trouvé
                        font.draw(batch, w.getValue1(), GameActivity.WORLD_WIDTH/3, GameActivity.WORLD_HEIGHT-200-vocabulary.getWords().indexOf(w)*LINE_HEIGHT);
                        font.draw(batch, w.getValue2(), GameActivity.WORLD_WIDTH/3*2, GameActivity.WORLD_HEIGHT-200-vocabulary.getWords().indexOf(w)*LINE_HEIGHT);
                    }
                }
            }

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
