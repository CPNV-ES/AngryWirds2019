package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Stage.Bird;
import ch.cpnv.angrywirds.Models.Stage.Bourd;
import ch.cpnv.angrywirds.Models.Stage.Pig;
import ch.cpnv.angrywirds.Models.Stage.Title;

public class ChoseYourBirds extends GameActivity implements InputProcessor{
    private Texture background;
    private Title title;
    private Bird tweety;
    private Bird bad;
    private Queue<Touch> actions;
    public ArrayList<Bird> birds;

    public ChoseYourBirds() {
        super();
        birds = new ArrayList<Bird>();
        tweety = new Bird("bird", 1, 60, 240, "bird.png");
        bad = new Bird("bourd", 2, 0, 120, "bourd.png");
        birds.add(tweety);
        birds.add(bad);

        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Click on Your Bird");
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
        tweety.draw(spriteBatch);
        bad.draw(spriteBatch);
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

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from screen coordinates to camera coordinates
        for (Bird bird : birds)
        {
            if (pointTouched.x >= bird.getX() && pointTouched.x <= bird.getX()+bird.getWidth() ) {
                AngryWirds.gameActivityManager.push(new Play(bird));
            }
        }

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
