package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.Button;
import ch.cpnv.angrywirds.Models.Stage.Scenery;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class ReminingWords  extends GameActivity implements InputProcessor {
    private Texture background;
    private Scenery scenery;
    private Queue<Touch> actions;
    private ArrayList<Word> voc;
    private ArrayList<Word> vocCkecked;
    private Boolean view;

    public ReminingWords(Vocabulary vocabulary, Vocabulary vocabularyCkecked)
    {
        super();
        vocCkecked = vocabularyCkecked.allWords();
        view = true;

        voc = vocabulary.allWords();
        background = new Texture(Gdx.files.internal("background.png"));
        scenery = new Scenery();
        try {

            scenery.addElement(new Button(new Vector2(10, 10), 50, 50, "scoreButton.jpg"));

        } catch (Exception e) {
            Gdx.app.log("ANGRY", "Could not add button to scenery");
        }
        try {

            scenery.addElement(new Button(new Vector2(70, 10), 50, 50, "scoreButton.jpg"));

        } catch (Exception e) {
            Gdx.app.log("ANGRY", "Could not add button to scenery");
        }

        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>();
    }

    @Override
    protected void handleInput() {
        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    Button button = scenery.buttonTouched(action.point.x, action.point.y);
                    if (button != null && action.point.x <60) {
                        AngryWirds.gameActivityManager.pop();
                        AngryWirds.gameActivityManager.pop();
                    }else if(button != null && action.point.x >60){
                        view = !view;
                     }
                    break;

                    default:
                        break;
            }
        }
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        scenery.draw(spriteBatch);

        spriteBatch.end();
        spriteBatch.begin();
        if (view){
            voc.removeAll(vocCkecked);

            for (Word word : voc) {
                BitmapFont font = new BitmapFont();

                font.draw(spriteBatch, word.getValue1(), 500 + 20, voc.indexOf(word) * 40);
                font.draw(spriteBatch, word.getValue2(), 500 + 120, voc.indexOf(word) * 40);
            }
            for (Word word : vocCkecked) {
                BitmapFont font = new BitmapFont();
                font.setColor(Color.BLUE);
                font.draw(spriteBatch, word.getValue1(), 500 + 20, (voc.size()+vocCkecked.indexOf(word)) * 40);
                font.draw(spriteBatch, word.getValue2(), 500 + 120, (voc.size()+vocCkecked.indexOf(word)) * 40);
            }

        }else {
            voc.removeAll(vocCkecked);

            for (Word word : voc) {
                BitmapFont font = new BitmapFont();
                font.draw(spriteBatch, word.getValue1(), 500 + 20, voc.indexOf(word) * 40);
                font.draw(spriteBatch, word.getValue2(), 500 + 120, voc.indexOf(word) * 40);

            }
        }
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
        actions.add(new Touch(pointTouched, Touch.Type.down));
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
