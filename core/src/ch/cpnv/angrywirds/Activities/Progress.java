package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Data.Word;
import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.Title;
import ch.cpnv.angrywirds.Providers.VocProvider;

import static javax.print.attribute.standard.Chromaticity.COLOR;

public class Progress extends GameActivity {
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
    }
    @Override
    public void handleInput() {}
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

            Gdx.app.log("pos",Integer.toString(YPos));
        }

        title.draw(spriteBatch, "Progression", WORLD_WIDTH/2 - 75, WORLD_HEIGHT -25);
        spriteBatch.end();
    }
}
