package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Language;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.DisplayWord;
import ch.cpnv.angrywirds.Models.Stage.Scenery;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class VocView extends GameActivity implements InputProcessor{
    private Texture background;
    private Title title;
    private DisplayWord wordtoshow;
    private DisplayWord wordlanguage2;

    private Sprite backbutton;

    private int h;
    private int l;
    private Vocabulary vocabulary; // The vocabulary we train
    private String currentword;

    private Scenery scenery;

    public VocView(Vocabulary vocabulary) {
        background = new Texture(Gdx.files.internal("background.png"));
        // title = new Title("Vocabulaire");
        // vocabulary = ;

        backbutton = new Sprite(new Texture("backbutton.png"));
        backbutton.setBounds(500, 0,100,100);
        backbutton.setOrigin(50,50);

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

            if (word.marked())
            {
             return;
            }else {
                wordtoshow = new DisplayWord(word.getValue1(), 100, 900-h);
                wordlanguage2 =  new DisplayWord(word.getValue2(), 400, 900-h);



                try {
                    scenery.addDisplayWord(wordtoshow);
                    scenery.addDisplayWord(wordlanguage2);
                    Gdx.app.log("ANGRY", "Tout est bon");
                } catch (Exception e) {
                    e.printStackTrace();
                    Gdx.app.log("ANGRY", "Could not add block to scenery");
                }

                h += 32;
                Gdx.app.log("HAHA",  wordtoshow+ "  MOtus ! ");
            }


        }
        Gdx.input.setInputProcessor(this);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        // title.draw(spriteBatch);
        // wordtoshow.draw(spriteBatch);
        scenery.drawWord(spriteBatch);
        backbutton.draw(spriteBatch);
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

    @Override
    public boolean keyDown(int keycode) {


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from screen coordinates to camera coordinates
        Gdx.app.log("HAHA",  "  Touched  ! ");
        if (pointTouched.x >= 500 && pointTouched.x <= 560 && pointTouched.y >= 0 && pointTouched.y <= 60 )
        {
            Gdx.app.log("HAHA",  "  Pop vocview");
            AngryWirds.gameActivityManager.pop();
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
