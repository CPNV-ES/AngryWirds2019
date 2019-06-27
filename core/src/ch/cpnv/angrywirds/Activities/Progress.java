package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;

/**
 * Created by Quentin Neves on 27.06.19.
 */

public class Progress extends GameActivity implements InputProcessor {
    private Texture background;
    private Texture back;
    private Texture tick;
    private Texture refresh;
    private Texture arrow;
    private BitmapFont font;

    private Vocabulary vocabulary;

    private static final Vector2 BACK_BUTTON_LOCATION = new Vector2(10,10);
    private static final Vector2 BACK_BUTTON_SIZE = new Vector2(100,100);

    private static final Vector2 REFRESH_BUTTON_SIZE = new Vector2(100,100);
    private static final Vector2 REFRESH_BUTTON_LOCATION = new Vector2(WORLD_WIDTH - REFRESH_BUTTON_SIZE.x,WORLD_HEIGHT - REFRESH_BUTTON_SIZE.y);

    private static final int tableOffset = 500;
    private static final int topOffset = 100;
    private static final int wordSpacing = 500;
    private static final int lineSpacing = 35;

    private boolean showRemaining;
    private Queue<Touch> actions;

    private static final int maxDisplayableWords = 19;
    private int totalWords;
    private int totalRemainingWords;

    public Progress(Vocabulary vocabulary)
    {
        super();
        this.vocabulary = vocabulary;

        // Set font
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2);

        // Set textures
        background = new Texture(Gdx.files.internal("background.png"));
        back = new Texture(Gdx.files.internal("back.png"));
        tick = new Texture(Gdx.files.internal("tick.png"));
        refresh = new Texture(Gdx.files.internal("refresh.png"));
        arrow = new Texture(Gdx.files.internal("arrow.png"));

        this.showRemaining = false;
        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>(); // User inputs are queued in here when events fire, handleInput processes them

        for(Word word : vocabulary.getWords()) {
            if (!word.getCompleted()) totalRemainingWords++;
            totalWords++;
        }
    }

    @Override
    public void handleInput() {
        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    break;
                case up:
                    // Clicked on progress button
                    if(action.point.x >= BACK_BUTTON_LOCATION.x && action.point.x <= BACK_BUTTON_LOCATION.x + BACK_BUTTON_SIZE.x
                            && action.point.y >= BACK_BUTTON_LOCATION.y && action.point.y <= BACK_BUTTON_LOCATION.y + BACK_BUTTON_SIZE.y){
                        // We must re-push Play Acitivity because InputProcessor won't be usable
                        AngryWirds.gameActivityManager.pop();
                    }

                    // Clicked changeDisplay button
                    if(action.point.x >= REFRESH_BUTTON_LOCATION.x && action.point.x <= REFRESH_BUTTON_LOCATION.x + REFRESH_BUTTON_SIZE.x
                            && action.point.y >= REFRESH_BUTTON_LOCATION.y && action.point.y <= REFRESH_BUTTON_LOCATION.y + REFRESH_BUTTON_SIZE.y) {
                        showRemaining = (showRemaining) ? false : true;
                    }
                    break;
            }
        }
    }

    @Override
    public void update(float dt) {
    }

    public void showAllWords(){
        // Set word table starting height
        int lineOffset = WORLD_HEIGHT - topOffset;

        for (Word word : vocabulary.getWords()){
            // Word.value1
            if (word.getCompleted()) spriteBatch.draw(tick, tableOffset - 50, lineOffset - 30, lineSpacing, lineSpacing);
            font.draw(spriteBatch, word.getValue1(), tableOffset, lineOffset);

            // Word.value2
            if (word.getCompleted()) spriteBatch.draw(tick, tableOffset + wordSpacing - 50, lineOffset - lineSpacing, lineSpacing, lineSpacing);
            font.draw(spriteBatch, word.getValue2(), tableOffset + wordSpacing, lineOffset);

            // Set offset for next word
            lineOffset -= lineSpacing;
        }
    }

    public void showRemainingWords(){
        int lineOffset = WORLD_HEIGHT - topOffset;
        for (Word word : vocabulary.getWords()){
            if (!word.getCompleted()) {
                font.draw(spriteBatch, word.getValue1(), tableOffset, lineOffset);
                font.draw(spriteBatch, word.getValue2(), tableOffset + wordSpacing, lineOffset);

                // Set offset for next word
                lineOffset -= lineSpacing;
            }
        }
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);

        // Chose words display
        if (showRemaining) { showRemainingWords(); }else { showAllWords(); }

        // Show buttons
        spriteBatch.draw(back, BACK_BUTTON_LOCATION.x, BACK_BUTTON_LOCATION.y, BACK_BUTTON_SIZE.x, BACK_BUTTON_SIZE.y);
        spriteBatch.draw(refresh, REFRESH_BUTTON_LOCATION.x, REFRESH_BUTTON_LOCATION.y, REFRESH_BUTTON_SIZE.x, REFRESH_BUTTON_SIZE.y);
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
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from screen coordinates to camera coordinates
        actions.add(new Touch(pointTouched, Touch.Type.up));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0)); // Convert from screen coordinates to camera coordinates
        actions.add(new Touch(pointTouched, Touch.Type.drag
        ));
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
