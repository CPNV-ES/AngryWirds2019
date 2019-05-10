package ch.cpnv.angrywirds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import ch.cpnv.angrywirds.Models.Bird;

public class AngryWirds extends Game {

    public static Random alea; // random generator object. Static for app-wide use

    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;

    private Bird tweety;

	SpriteBatch batch;
	Texture background;
	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("background.jpg"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false,WORLD_WIDTH,WORLD_HEIGHT);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
        camera.update();

        tweety = new Bird(0,WORLD_HEIGHT/10,new Vector2(30,100));

	}

	public void update() {
        float dt = Gdx.graphics.getDeltaTime();
        tweety.accelerate(dt);
        tweety.move(dt);
        // Gdx.app.log("AWI", tweety.toString());
    }

	@Override
	public void render () {
	    update();
        batch.setProjectionMatrix(camera.combined);
		batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		tweety.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
