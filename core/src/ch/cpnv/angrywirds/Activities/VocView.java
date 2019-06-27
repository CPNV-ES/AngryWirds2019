package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Language;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class VocView extends GameActivity {
    private Texture background;
    private Title title;
    private Vocabulary vocabulary; // The vocabulary we train

    public VocView(Vocabulary vocabulary) {
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Vocabulaire");
        // vocabulary = ;


        Gdx.app.log("HAHA",  vocabulary.getWords()+ "  voc ! ");
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
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
