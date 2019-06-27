package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Providers.VocProvider;


public class Progress extends GameActivity  implements InputProcessor {
    public static final int SPACE_BETWEEN = 50;

    //public static final int WORLD_WIDTH = 1600;
    //public static final int WORLD_HEIGHT = 900;

    private Stage stage;
    private Texture background;
    private Vocabulary vocabulary;
    private ArrayList<Word> words;
    private BitmapFont wordFont;
    private BitmapFont title;
    private int YPos;
    private Queue<Touch> actions;
    public Progress()
    {
        super();
        YPos = WORLD_HEIGHT -75;
        vocabulary = VocProvider.vocabularies.get(0);
        words = vocabulary.getWords();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new BitmapFont();
        title.getData().setScale(3,3);
        int position = 0;
         wordFont = new BitmapFont();
         wordFont.getData().setScale(2,2);
        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>(); // User inputs are queued in here when events fire, handleInput processes them
    }
    @Override
    public void handleInput() {

        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    if (action.point.x > 0 && action.point.x < 50 && action.point.y > 0 && action.point.x < 100) {
                        AngryWirds.gameActivityManager.pop();
                    }
                    break;
            }
        }

    }
    public void update(float dt) {

    }

    @Override
    public void render() {


        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        int pos =0;
        for (Word word : words){

            pos++;
            if(!word.getCorrect())
            {
                wordFont.setColor(1,0,0,1);
            }
            else{
                wordFont.setColor(0,1,0,1);
            }
            wordFont.draw(spriteBatch,word.getValue1(),WORLD_WIDTH/3 -50,YPos - (35*pos));
            wordFont.draw(spriteBatch,word.getValue2(),WORLD_WIDTH/3*2 -50,YPos - (35*pos));


        }

        title.draw(spriteBatch, "Progression", WORLD_WIDTH/2 - 75, WORLD_HEIGHT -25);
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
