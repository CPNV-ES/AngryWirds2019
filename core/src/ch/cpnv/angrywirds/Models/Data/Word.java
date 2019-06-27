package ch.cpnv.angrywirds.Models.Data;

/**
 * Created by Xavier on 21.06.18.
 */

public class Word {
    private int id;
    private String value1;
    private String value2;
    private Boolean correct;
    public int getId() {
        return id;
    }

    public String getValue1() {
        return value1;

    }

    public String getValue2() {
        return value2;
    }
    public Boolean getCorrect(){
        return correct;
    }
    public void setCorrect(){
        correct = true;
    }
    public Word(int id, String value1, String value2, Boolean correct) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
        this.correct = correct;
    }

}
