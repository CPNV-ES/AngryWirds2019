package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.FoundedWord;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.Bird;
import ch.cpnv.angrywirds.Models.Stage.PhysicalObject;
import ch.cpnv.angrywirds.Models.Stage.Scenery;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Models.Stage.WordProgress;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class Progress extends GameActivity implements InputProcessor {
    private Texture background;
    private Title title;
    private Vocabulary vocabulary;
    private BitmapFont font;
    private ArrayList<Title> words;
    private ArrayList<WordProgress> wordProgresses = new ArrayList<WordProgress>();
    private int POSX = 0;
    private int POSY = 0;
    public FoundedWord foundedwords;
    int i = 0;
    private Bird back;

    private Scenery scenery;

    public Progress(ArrayList<FoundedWord> foundedwords) {
        super();
        foundedwords = foundedwords;
        words = new ArrayList<Title>();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Progress");
        vocabulary = VocProvider.vocabularies.get(0); // hardcoded for now
        font= new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(5);

        scenery = new Scenery();
        try {
            scenery.addElement(new PhysicalObject(new Vector2(0, 0), 100, 100, "block.png"));
        } catch (Exception e) {
            Gdx.app.log("EXC", "Could not add menu to scenery");
        }

        for (Vocabulary vocabulary : VocProvider.vocabularies) {
            for (Word word : vocabulary.getVoc()) {

                i++;
                wordProgresses.add(new WordProgress(100+POSX,(GameActivity.WORLD_HEIGHT-150)-POSY, word.getValue1(), word.getValue2(), "word.png"));


                for (FoundedWord find : foundedwords) {
                    if (find.getValue1() == word.getValue1()) {
                        wordProgresses.add(new WordProgress(100+POSX,(GameActivity.WORLD_HEIGHT-100)-POSY, word.getValue1(), word.getValue2(), "block.png"));
                    }
                }

                POSX += 350;
                if (i%3 == 0) {
                    POSX = 0;
                    POSY += 200;
                }
            }
        }

        Gdx.input.setInputProcessor(this);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        for (WordProgress word: wordProgresses) {
            word.draw(spriteBatch);
        }
        scenery.draw(spriteBatch);
        spriteBatch.end();
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
        if (pointTouched.x <= 100 && pointTouched.y <= 100) {
            AngryWirds.gameActivityManager.push(new Play());
        }

        if (pointTouched.x >= GameActivity.WORLD_HEIGHT-100 && pointTouched.x >= GameActivity.WORLD_WIDTH-100) {
            Gdx.app.log("TUTU", "Achievment");
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
