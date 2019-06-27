package ch.cpnv.angrywirds.Models.Data;

import java.util.ArrayList;

import ch.cpnv.angrywirds.AngryWirds;

public class PlayerVocabulary extends Vocabulary {
    public static final String VOCNAME = "playervoc";
    ArrayList<Word> words;

    public PlayerVocabulary() {
        super( 1 , VOCNAME , 1, 2);
    }

    public void addWord(Word w) {
        words.add(w);
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
