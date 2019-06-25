package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.ShownWord;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

/**
 * Created by Xavier on 10.06.18.
 */

public class Progress extends GameActivity {

    private Texture background;
    private Title title;
    private Vocabulary vocabulary;
    private ArrayList<ShownWord> words;

    public Progress() {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Progrès",0,GameActivity.WORLD_HEIGHT);
        vocabulary = VocProvider.vocabularies.get(0); // hardcoded for now
        words = new ArrayList<ShownWord>();
        for (int row = 0; row < vocabulary.getWords().size(); row++) {
            Word word = vocabulary.getWords().get(row);
            words.add(new ShownWord(row, word.getValue1(), ShownWord.ShowMode.Primary));
            if (word.isTrained())
                words.add(new ShownWord(row, word.getValue1(), ShownWord.ShowMode.Secondary));
            else
                words.add(new ShownWord(row, word.getValue2(), ShownWord.ShowMode.SecondaryTrained));
        }
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
        for (ShownWord sw : words) sw.draw(spriteBatch);
        spriteBatch.end();
    }
}
