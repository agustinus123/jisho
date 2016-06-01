package net.fauxpark.jisho.model;

import java.util.List;

public class Kanji {
    private int id;

    private String literal;

    private String codePoint;

    private int radical;

    private Integer grade;

    private int strokeCount;

    private Integer frequency;

    private Integer jlpt;

    private Integer heisig;

    private String whiteRabbit;

    private String skip;

    private String fourCorner;

    private List<String> onyomi;

    private List<String> kunyomi;

    private List<String> nanori;

    private List<String> meanings;

    private String components;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getCodePoint() {
        return codePoint;
    }

    public void setCodePoint(String codePoint) {
        this.codePoint = codePoint;
    }

    public int getRadical() {
        return radical;
    }

    public void setRadical(int radical) {
        this.radical = radical;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getStrokeCount() {
        return strokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        this.strokeCount = strokeCount;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getJlpt() {
        return jlpt;
    }

    public void setJlpt(Integer jlpt) {
        this.jlpt = jlpt;
    }

    public Integer getHeisig() {
        return heisig;
    }

    public void setHeisig(Integer heisig) {
        this.heisig = heisig;
    }

    public String getWhiteRabbit() {
        return whiteRabbit;
    }

    public void setWhiteRabbit(String whiteRabbit) {
        this.whiteRabbit = whiteRabbit;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getFourCorner() {
        return fourCorner;
    }

    public void setFourCorner(String fourCorner) {
        this.fourCorner = fourCorner;
    }

    public List<String> getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(List<String> onyomi) {
        this.onyomi = onyomi;
    }

    public List<String> getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(List<String> kunyomi) {
        this.kunyomi = kunyomi;
    }

    public List<String> getNanori() {
        return nanori;
    }

    public void setNanori(List<String> nanori) {
        this.nanori = nanori;
    }

    public List<String> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<String> meanings) {
        this.meanings = meanings;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }
}
