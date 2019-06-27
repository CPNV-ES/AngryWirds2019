package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Stage.Button;
import ch.cpnv.angrywirds.Models.Stage.Progress;

public class Menu extends GameActivity implements InputProcessor {

    private Texture background;
    //private ArrayList<Button> buttons = new ArrayList<Button>();
    private Button buttons;
    private Progress progress;

    public Menu() {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        buttons = new Button(0,100, "Back", 0);
        //progress = new Progress(word.getValue1(), word.getValue2());
        //buttons.add(new Button(WORLD_WIDTH/2+250, pos, "Bird 2", 0));
        progress = new Progress();
        Gdx.input.setInputProcessor(this);
    }

    public void handleInput() { }

    public void update(float dt) { }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        buttons.draw(spriteBatch);
        progress.draw(spriteBatch);
        /*for (Button button: buttons){
            button.draw(spriteBatch);
        }*/
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
        if(buttons.getSprite().getBoundingRectangle().contains(new Vector2(pointTouched.x, pointTouched.y))){
            AngryWirds.gameActivityManager.pop();
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
