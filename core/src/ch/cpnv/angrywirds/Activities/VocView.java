package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Language;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.DisplayWord;
import ch.cpnv.angrywirds.Models.Stage.Scenery;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class VocView extends GameActivity {
    private Texture background;
    private Title title;
    private DisplayWord wordtoshow;
    private int h;
    private int l;
    private Vocabulary vocabulary; // The vocabulary we train
    private String currentword;

    private Scenery scenery;

    public VocView(Vocabulary vocabulary) {
        background = new Texture(Gdx.files.internal("background.png"));
        // title = new Title("Vocabulaire");
        // vocabulary = ;

        Gdx.app.log("HAHA",  vocabulary.getWords()+ "  voc ! ");

        scenery = new Scenery();
        wordtoshow = new DisplayWord("haha ", 100, 100);
    /*
        try {
            scenery.addDisplayWord(wordtoshow);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        for(Word word : vocabulary.getWords())
        {
            // currentword = word.getValue1();

            wordtoshow = new DisplayWord(word.getValue1(), 100, 900-h);

            try {
                scenery.addDisplayWord(wordtoshow);
                Gdx.app.log("ANGRY", "Tout est bon");
            } catch (Exception e) {
                e.printStackTrace();
                Gdx.app.log("ANGRY", "Could not add block to scenery");
            }

            h += 50;
            Gdx.app.log("HAHA",  wordtoshow+ "  MOtus ! ");

        }

        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        // title.draw(spriteBatch);
        // wordtoshow.draw(spriteBatch);
        scenery.drawWord(spriteBatch);
        spriteBatch.end();

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {


    }

    @Override
    public void render() {

    }

    public boolean keyDown(int keycode) {
    if(keycode == 50)
    {
        AngryWirds.gameActivityManager.pop(); // play
    }

        return false;
    }

}
