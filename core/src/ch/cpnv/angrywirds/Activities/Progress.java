package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Models.Stage.Words;

public class Progress extends GameActivity {

    private Texture background;
    private Title title;
    private Words words;

    public Progress(Words words) {
        super();
        this.words = words;
        background = new Texture(Gdx.files.internal("progress.png"));
        title = new Title("Voici le progrès");
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
}
