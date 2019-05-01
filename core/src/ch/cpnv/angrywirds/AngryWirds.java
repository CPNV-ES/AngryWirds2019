package ch.cpnv.angrywirds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AngryWirds extends Game {

    public static final int WORLD_WIDTH = 1600;
    public static final int WORLD_HEIGHT = 900;

	SpriteBatch batch;
	Texture img;
	Texture background;
	private float x;
	private float y;
	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal("bird.png"));
        background = new Texture(Gdx.files.internal("background.jpg"));
		x = 0f;
        y = 0f;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,WORLD_WIDTH,WORLD_HEIGHT);
        batch.setProjectionMatrix(camera.combined);
	}

	public void update() {
        float dt = Gdx.graphics.getDeltaTime();
        x += WORLD_WIDTH/10 * dt; // we want our bird to cross the screen in 10s
    }

	@Override
	public void render () {
	    update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(background, 0, 0, camera.viewportWidth,camera.viewportHeight);
		batch.draw(img, x, y, 60,60);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
