package net.fauxpark.jisho.mapper;

import java.util.Arrays;
import java.util.List;

import android.database.Cursor;

import net.fauxpark.jisho.model.Word;

public class WordMapper {
    private static final String ID = "id";

    private static final String KANJI = "kanji";

    private static final String READINGS = "readings";

    private static final String MEANINGS = "meanings";

    private static final String POS = "pos";

    private static final String COMMON = "common";

    public static Word map(Cursor cursor) {
        Word word = new Word();

        word.setId(cursor.getInt(cursor.getColumnIndex(ID)));

        if(!cursor.isNull(cursor.getColumnIndex(KANJI))) {
            word.setKanji(mapList(cursor.getString(cursor.getColumnIndex(KANJI))));
        }

        word.setReadings(mapList(cursor.getString(cursor.getColumnIndex(READINGS))));
        word.setMeanings(mapList(cursor.getString(cursor.getColumnIndex(MEANINGS))));
        word.setPos(cursor.getBlob(cursor.getColumnIndex(POS)));

        if(!cursor.isNull(cursor.getColumnIndex(COMMON))) {
            word.setCommon(cursor.getInt(cursor.getColumnIndex(COMMON)));
        }

        return word;
    }

    private static List<String> mapList(String value) {
        return Arrays.asList(value.substring(1, value.length() - 2).split("\\]\\["));
    }
}
