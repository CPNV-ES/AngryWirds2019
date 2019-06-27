package ch.cpnv.angrywirds.Models.Data;

/**
 * Created by Xavier on 21.06.18.
 */

public class Word {
    private int id;
    private String value1;
    private String value2;
    private boolean completed;

    public int getId() {
        return id;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setCompleted() { this.completed = true; }

    public boolean getCompleted() { return this.completed; }

    public Word(int id, String value1, String value2) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
        this.completed = false;
    }

}
