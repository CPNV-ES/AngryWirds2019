package ch.cpnv.angrywirds.Models.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ch.cpnv.angrywirds.Activities.GameActivity;
import ch.cpnv.angrywirds.Providers.FontProvider;

public class DisplayWord  {

    private BitmapFont font;
    private GlyphLayout layout;
    private float x;
    private float y;

    public DisplayWord(String message, float x, float y) {
        initBase(message);
        this.x = x;
        this.y = y;
    }


    private void initBase(String message)
    {
        layout = new GlyphLayout();
        font = FontProvider.h3;
        setText(message);
    }

    public void draw(Batch batch)
    {
        Gdx.app.log("HAHA",  "  Drawable ! ");
        font.draw(batch, layout, x, y);
    }

    public void setText (String text)
    {
        layout.setText(font,text);
    }
}
