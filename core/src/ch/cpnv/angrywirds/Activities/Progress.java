package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Stage.Words;

public class Progress extends GameActivity implements InputProcessor {

    private Texture background;
    private Words words;

    public Progress(Words words) {
        super();
        this.words = words;
        background = new Texture(Gdx.files.internal("progress.png"));

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
        words.draw(spriteBatch);
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
        if (pointTouched.x < 115 && pointTouched.y < 115) //Bas gauche
            AngryWirds.gameActivityManager.pop();
        else if(pointTouched.x > GameActivity.WORLD_WIDTH-115 && pointTouched.y < 115){ //Bas droite
            this.words.changeVue();
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
