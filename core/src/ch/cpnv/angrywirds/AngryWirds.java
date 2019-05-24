package ch.cpnv.angrywirds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.Random;

import ch.cpnv.angrywirds.Models.Bird;
import ch.cpnv.angrywirds.Models.PhysicalObject;
import ch.cpnv.angrywirds.Models.Pig;
import ch.cpnv.angrywirds.Models.Scenery;
import ch.cpnv.angrywirds.Models.TNT;
import ch.cpnv.angrywirds.Models.Wasp;

public class AngryWirds extends Game implements InputProcessor {

    public static Random alea; // random generator object. Static for app-wide use

    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;
    public static final int FLOOR_HEIGHT = 120;
    private static final int SLINGSHOT_WIDTH = 75;
    private static final int SLINGSHOT_HEIGHT = 225;
    private static final int SLINGSHOT_OFFSET = 100; // from left edge
    private static final int BOARD_WIDTH = 300;
    private static final int BOARD_HEIGHT = 200;
    private static final int BOARD_OFFSET = 50; // from left edge
    private static final float INITIAL_PUSH = 1.5f; // Multiplication factor on bird launch

    private Scenery scenery;
    private Bird tweety;
    private Wasp waspy;

    private SpriteBatch batch;
    private Texture background;
    private Texture slingshot;
    private Texture board;

    private OrthographicCamera camera;

    @Override
    public void create() {
        alea = new Random();

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("background.jpg"));
        slingshot = new Texture(Gdx.files.internal("slingshot.png"));
        board = new Texture(Gdx.files.internal("panel.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        tweety = new Bird(new Vector2(0, FLOOR_HEIGHT), new Vector2(0, 0));
        tweety.freeze(); // it won't fly until we launch

        waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));
        scenery = new Scenery();
        for (int i = 5; i < WORLD_WIDTH / 50; i++) {
            try {
                scenery.addElement(new PhysicalObject(new Vector2(i * 50, FLOOR_HEIGHT), 50, 50, "block.png"));
            } catch (Exception e) {
                Gdx.app.log("ANGRY", "Could not add block to scenery");
            }
        }
        for (int i = 0; i < 5; i++) {
            try {
                scenery.addElement(new TNT(new Vector2(alea.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3, FLOOR_HEIGHT + 50), 50));
            } catch (Exception e) {
                Gdx.app.log("ANGRY", "Could not add TNT to scenery");
            }
        }
        for (int i = 0; i < 5; i++) {
            try {
                scenery.addElement(new Pig(new Vector2(alea.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3, FLOOR_HEIGHT + 50), "I am Pig#" + 1));
            } catch (Exception e) {
                Gdx.app.log("ANGRY", "Could not add Pig to scenery");
            }
        }

        Gdx.input.setInputProcessor(this);
    }

    public void update() {
        float dt = Gdx.graphics.getDeltaTime();
        tweety.update(dt);
        waspy.update(dt);
        PhysicalObject hit = scenery.collidesWith(tweety);
        if (hit != null || tweety.collidesWith(waspy) || tweety.getX() > WORLD_WIDTH || tweety.getY() < FLOOR_HEIGHT) {
            tweety.setPosition(0, FLOOR_HEIGHT);
            tweety.freeze();
            if (hit != null) Gdx.app.log("ANGRY","Collided with "+hit.getClass().getSimpleName());
        }
    }

    @Override
    public void render() {
        update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        batch.draw(slingshot, SLINGSHOT_OFFSET, FLOOR_HEIGHT, SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT);
        batch.draw(board, BOARD_OFFSET, WORLD_HEIGHT - BOARD_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT);
        tweety.draw(batch);
        waspy.draw(batch);
        scenery.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
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
        if (tweety.isFrozen()) {
            if (tweety.getX() == 0) // start position => launch !!!
            {
                tweety.setSpeed(new Vector2((pointTouched.x - tweety.getPosition().x) * INITIAL_PUSH, (pointTouched.y - tweety.getPosition().y) * INITIAL_PUSH));
                tweety.unFreeze();
            } else
            {
                tweety.setPosition(0, FLOOR_HEIGHT);
                waspy.unFreeze(); // in case it was
            }
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
