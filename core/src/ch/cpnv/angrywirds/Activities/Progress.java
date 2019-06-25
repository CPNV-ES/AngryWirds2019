package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

/**
 * Created by Xavier on 10.06.18.
 */

public class Progress extends GameActivity {

    private Texture background;
    private Title title;
    private Vocabulary vocabulary;

    public Progress() {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Progrès");
        vocabulary = VocProvider.vocabularies.get(0); // hardcoded for now
        for (Word word : vocabulary.getWords())
            if (word.isTrained())
                Gdx.app.log("ANGRY", word.getValue1() + " is trained");
            else
                Gdx.app.log("ANGRY", word.getValue1() + " is NOT trained");
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            AngryWirds.gameActivityManager.pop(); // return to game
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        spriteBatch.end();
    }
}
