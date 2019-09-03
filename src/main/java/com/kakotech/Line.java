package com.kakotech;

import javafx.beans.property.SimpleStringProperty;

public class Line {

    private final SimpleStringProperty wordEnglish;
    private final SimpleStringProperty wordHungarian;
    private final SimpleStringProperty exampleSentence;

    public Line(){
        this.wordEnglish = new SimpleStringProperty("");
        this.wordHungarian = new SimpleStringProperty("");
        this.exampleSentence = new SimpleStringProperty("");
    }

    public Line(String wordEnglish, String wordHungarian, String exampleSentence) {
        this.wordEnglish = new SimpleStringProperty(wordEnglish);
        this.wordHungarian = new SimpleStringProperty(wordHungarian);
        this.exampleSentence = new SimpleStringProperty(exampleSentence);
    }

    public String getWordEnglish() {
        return wordEnglish.get();
    }

    public SimpleStringProperty wordEnglishProperty() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish.set(wordEnglish);
    }

    public String getWordHungarian() {
        return wordHungarian.get();
    }

    public SimpleStringProperty wordHungarianProperty() {
        return wordHungarian;
    }

    public void setWordHungarian(String wordHungarian) {
        this.wordHungarian.set(wordHungarian);
    }

    public String getExampleSentence() {
        return exampleSentence.get();
    }

    public SimpleStringProperty exampleSentenceProperty() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence.set(exampleSentence);
    }
}
