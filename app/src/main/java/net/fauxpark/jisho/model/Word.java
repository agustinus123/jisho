package net.fauxpark.jisho.model;

import java.util.List;

public class Word {
    private int id;

    private List<String> kanji;

    private List<String> readings;

    private List<String> meanings;

    private byte[] pos;

    private Integer common;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getKanji() {
        return kanji;
    }

    public void setKanji(List<String> kanji) {
        this.kanji = kanji;
    }

    public List<String> getReadings() {
        return readings;
    }

    public void setReadings(List<String> readings) {
        this.readings = readings;
    }
    public List<String> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<String> meanings) {
        this.meanings = meanings;
    }

    public byte[] getPos() {
        return pos;
    }

    public void setPos(byte[] pos) {
        this.pos = pos;
    }

    public Integer getCommon() {
        return common;
    }

    public void setCommon(Integer common) {
        this.common = common;
    }
}
