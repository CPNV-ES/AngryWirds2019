package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Stage.Title;

public class Progress extends GameActivity{

    private Texture background;
    private Title title;


    public Progress() {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Progression");
    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            AngryWirds.gameActivityManager.pop();
            AngryWirds.gameActivityManager.pop();
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        spriteBatch.end();
    }

}
