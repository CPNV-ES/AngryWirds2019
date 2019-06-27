package ch.cpnv.angrywirds.Models.Data;

/**
 * Created by Xavier on 21.06.18.
 */

public class Word {
    private int id;
    private String value1;
    private String value2;
    private boolean marked = false;

    public int getId() {
        return id;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean marked()
    {
        return marked;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public Word(int id, String value1, String value2) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
    }


}
