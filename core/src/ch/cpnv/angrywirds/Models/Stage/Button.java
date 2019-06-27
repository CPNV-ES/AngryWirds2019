package ch.cpnv.angrywirds.Models.Stage;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Button extends PhysicalObject {
        Stage stage;

    public Button(Vector2 position, float width, float height, String graphic) {
        super(position, width, height, graphic);
    }
}
