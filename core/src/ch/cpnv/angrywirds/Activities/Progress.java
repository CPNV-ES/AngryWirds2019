package ch.cpnv.angrywirds.Activities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ch.cpnv.angrywirds.Models.Data.Vocabulary;
import ch.cpnv.angrywirds.Models.Stage.ScoreBoard;
import ch.cpnv.angrywirds.Models.Stage.Title;

public class Progress {
    private Texture background;
    private Title title;
    private Vocabulary vocabulary;

    public Progress()
    {
        super();
        background = new Texture(Gdx.files.internal("background.png"));
        title = new Title("Game Over\n score: "+ ScoreBoard.score);
    }
}
