package app.server.utils;

import app.server.domain.custom.PartOfSpeech;

import java.io.Serializable;

public class TranslateData implements Serializable {

    private String fromWord;
    private PartOfSpeech partOfSpeech;
    private String toWord;

    public TranslateData(String fromWord, PartOfSpeech partOfSpeech, String toWord) {
        this.fromWord = fromWord;
        this.partOfSpeech = partOfSpeech;
        this.toWord = toWord;
    }

    public String getFromWord() {
        return fromWord;
    }

    public void setFromWord(String fromWord) {
        this.fromWord = fromWord;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getToWord() {
        return toWord;
    }

    public void setToWord(String toWord) {
        this.toWord = toWord;
    }
}
