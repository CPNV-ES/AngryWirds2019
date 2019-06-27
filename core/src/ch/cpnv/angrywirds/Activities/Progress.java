package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import ch.cpnv.angrywirds.AngryWirds;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.Button;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

public class Progress extends GameActivity implements InputProcessor {

    private Texture background;
    private Title title;
    private ArrayList<Word> foundWords;
    private ArrayList<Word> notFoundWords;
    private ArrayList<Word> words;
    private Table table;
    private Button swapView;
    private Button backButton;
    private Label.LabelStyle label1Style;
    private Stage stage;
    private Queue<Touch> actions;

    private boolean goToPlay = false;


    public Progress() {
        super();

        stage = new Stage();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Progression",400,900);
        words = VocProvider.vocabularies.get(0).getWords();
        notFoundWords = new ArrayList<Word>();
        foundWords = Play.foundWords;
        table = new Table();
        label1Style = new Label.LabelStyle();
        swapView = new Button(new Texture(Gdx.files.internal("button.png")),800,0,300,150);
        backButton = new Button(new Texture(Gdx.files.internal("button.png")),0,0,300,150);
        Gdx.input.setInputProcessor(this);
        actions = new LinkedList<Touch>();


        if(!foundWords.isEmpty()) {
            for (Word w : words) {
                boolean found = false;
                for (Word fw : foundWords) {
                    if (fw.getId() == w.getId()) {
                        found = true;
                    }
                }
                if (!found) {
                    notFoundWords.add(new Word(w.getId(), w.getValue1(), w.getValue2()));
                }
            }
        }

        BitmapFont myFont = new BitmapFont(Gdx.files.internal("table.fnt"));
        label1Style.font = myFont;
        label1Style.fontColor = Color.RED;

        for (Word w : words){
            table.add(new Label(w.getValue1(), label1Style));
            table.add(new Label(w.getValue2(), label1Style));
            table.row();
        }


        table.setPosition(400, 850);
        stage.addActor(table);
    }


    @Override
    protected void handleInput() {
        Touch action;
        while ((action = actions.poll()) != null) {
            switch (action.type) {
                case down:
                    if (swapView.getBoundingRectangle().contains(action.point.x, action.point.y)) {
                        table = new Table();
                        for (Word w : notFoundWords) {
                            table.add(new Label(w.getValue1(), label1Style));
                            table.add(new Label(w.getValue2(), label1Style));
                            table.row();
                        }
                        table.setPosition(400, 850);
                        stage.clear();
                        stage.addActor(table);
                    } else if (backButton.getBoundingRectangle().contains(action.point.x, action.point.y)) {
                        goToPlay = true;
                    }
                    break;
            }
        }
    }

    @Override
    public void update(float dt) {
        Gdx.app.log("INPUT", actions.toString());
        if(goToPlay){
            AngryWirds.gameActivityManager.pop();
            AngryWirds.gameActivityManager.pop();
        }

        stage.act(dt);
        stage.draw();
    }

    @Override
    public void render() {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
        title.draw(spriteBatch);
        swapView.draw(spriteBatch);
        backButton.draw(spriteBatch);
        spriteBatch.end();
        stage.draw();
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
