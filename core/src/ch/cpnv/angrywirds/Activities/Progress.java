package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.Bubble;
import ch.cpnv.angrywirds.Models.Stage.Button;
import ch.cpnv.angrywirds.Models.Stage.DisplayContent;
import ch.cpnv.angrywirds.Models.Stage.Pig;
import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.Title;

/**
 * Created by Xavier on 10.06.18.
 */

public class Progress extends GameActivity implements InputProcessor{

    private Texture background;
    private DisplayContent contentToDisplay;
    private Queue<Touch> actions;

    // Object With A lot of words

    private Vocabulary localVoc; // The vocabulary we train

    private String content;

    // Buttons
    Button buttonBack = new Button(new Vector2(120,10), 100,100, "button_Back.png");
    Button buttonSwitch = new Button(new Vector2(WORLD_WIDTH-110,10), 100,100, "button.png");


    public Progress(Vocabulary vocabulary)
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));

        this.localVoc = vocabulary;

        // Display the vocabulary
        for (Word wtd : localVoc.words){
            content = content + (wtd.getValue1() + "    " + wtd.getValue2() +"\n" );
        }

        contentToDisplay = new DisplayContent(content);

        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>(); // User inputs are queued in here when events fire, handleInput processes them
    }


    @Override
    public void handleInput() {
        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    if (action.point.x > buttonBack.getX() && action.point.y > buttonBack.getY()) {
                        AngryWirds.gameActivityManager.pop();
                    }
                break;
            }
        }
    }


    @Override
    public void update(float dt) {
        //this.localVoc = vocabulary;
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        contentToDisplay.draw(spriteBatch);
        buttonBack.draw(spriteBatch);
        buttonSwitch.draw(spriteBatch);
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
