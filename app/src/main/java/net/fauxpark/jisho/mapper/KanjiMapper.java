package net.fauxpark.jisho.mapper;

import java.util.Arrays;
import java.util.List;

import android.database.Cursor;

import net.fauxpark.jisho.model.Kanji;

public class KanjiMapper {
    private static final String ID = "id";

    private static final String LITERAL = "literal";

    private static final String CODEPOINT = "codepoint";

    private static final String RADICAL = "radical";

    private static final String GRADE = "grade";

    private static final String STROKE_COUNT = "stroke_count";

    private static final String FREQUENCY = "frequency";

    private static final String JLPT = "jlpt";

    private static final String HEISIG = "heisig";

    private static final String WHITE_RABBIT = "white_rabbit";

    private static final String SKIP = "skip";

    private static final String FOUR_CORNER = "four_corner";

    private static final String ONYOMI = "onyomi";

    private static final String KUNYOMI = "kunyomi";

    private static final String NANORI = "nanori";

    private static final String MEANINGS = "meanings";

    private static final String COMPONENTS = "components";

    public static Kanji map(Cursor cursor) {
        Kanji kanji = new Kanji();

        kanji.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        kanji.setLiteral(new String(cursor.getBlob(cursor.getColumnIndex(LITERAL))));
        kanji.setCodePoint(cursor.getString(cursor.getColumnIndex(CODEPOINT)));
        kanji.setRadical(cursor.getInt(cursor.getColumnIndex(RADICAL)));

        if(!cursor.isNull(cursor.getColumnIndex(GRADE))) {
            kanji.setGrade(cursor.getInt(cursor.getColumnIndex(GRADE)));
        }

        kanji.setStrokeCount(cursor.getInt(cursor.getColumnIndex(STROKE_COUNT)));

        if(!cursor.isNull(cursor.getColumnIndex(FREQUENCY))) {
            kanji.setFrequency(cursor.getInt(cursor.getColumnIndex(FREQUENCY)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(JLPT))) {
            kanji.setJlpt(cursor.getInt(cursor.getColumnIndex(JLPT)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(HEISIG))) {
            kanji.setHeisig(cursor.getInt(cursor.getColumnIndex(HEISIG)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(WHITE_RABBIT))) {
            kanji.setWhiteRabbit(cursor.getString(cursor.getColumnIndex(WHITE_RABBIT)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(SKIP))) {
            kanji.setSkip(cursor.getString(cursor.getColumnIndex(SKIP)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(FOUR_CORNER))) {
            kanji.setFourCorner(cursor.getString(cursor.getColumnIndex(FOUR_CORNER)));
        }

        if(!cursor.isNull(cursor.getColumnIndex(ONYOMI))) {
            kanji.setOnyomi(mapList(cursor.getString(cursor.getColumnIndex(ONYOMI))));
        }

        if(!cursor.isNull(cursor.getColumnIndex(KUNYOMI))) {
            kanji.setKunyomi(mapList(cursor.getString(cursor.getColumnIndex(KUNYOMI))));
        }

        if(!cursor.isNull(cursor.getColumnIndex(NANORI))) {
            kanji.setNanori(mapList(cursor.getString(cursor.getColumnIndex(NANORI))));
        }

        if(!cursor.isNull(cursor.getColumnIndex(MEANINGS))) {
            kanji.setMeanings(mapList(cursor.getString(cursor.getColumnIndex(MEANINGS))));
        }

        if(!cursor.isNull(cursor.getColumnIndex(COMPONENTS))) {
            kanji.setComponents(new String(cursor.getBlob(cursor.getColumnIndex(COMPONENTS))));
        }

        return kanji;
    }

    private static List<String> mapList(String value) {
        return Arrays.asList(value.substring(1, value.length() - 1).split("\\]\\["));
    }
}
