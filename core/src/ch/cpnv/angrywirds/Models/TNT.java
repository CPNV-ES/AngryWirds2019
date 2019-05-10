package ch.cpnv.angrywirds.Models;

/**
 * Created by Xavier on 06.05.18.
 */

public final class TNT extends PhysicalObject {

    private static final String PICNAME = "tnt.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private int negativePoints; // Number of pooints removed from score if hit

    public TNT(float positionX, float positionY, int negativePoints) {
        super(positionX, positionY, WIDTH, HEIGHT, PICNAME);
        this.negativePoints = negativePoints;
    }

}
