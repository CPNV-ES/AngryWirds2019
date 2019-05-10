package ch.cpnv.angrywirds.Models;

/**
 * Created by Xavier on 06.05.18.
 */

public final class Pig extends PhysicalObject {

    private static final String PICNAME = "pig.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private String word; // The word of the vocabulary that this pig carries

    public Pig(float positionX, float positionY, String word) {
        super(positionX, positionY, WIDTH, HEIGHT, PICNAME);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

}
