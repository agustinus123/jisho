package net.fauxpark.jisho.datasource;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.fauxpark.jisho.mapper.KanjiMapper;
import net.fauxpark.jisho.mapper.RadicalMapper;
import net.fauxpark.jisho.model.Kanji;
import net.fauxpark.jisho.model.Radical;
import net.fauxpark.jisho.openhelper.KanjiOpenHelper;

public class KanjiDataSource {
    private static final String KANJI_TABLE = "kanji";

    private static final String RADICALS_TABLE = "radicals";

    private SQLiteDatabase database;

    private KanjiOpenHelper kanjiOpenHelper;

    public KanjiDataSource(Context context) {
        kanjiOpenHelper = KanjiOpenHelper.getInstance(context);
        database = kanjiOpenHelper.getReadableDatabase();
    }

    public void close() {
        kanjiOpenHelper.close();
    }

    public Kanji getKanjiById(int id) {
        Cursor c = database.query(KANJI_TABLE, null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        Kanji kanji = null;

        if(c.getCount() > 0) {
            c.moveToPosition(0);
            kanji = KanjiMapper.map(c);
            c.close();
        }

        return kanji;
    }

    public Radical getRadicalById(int id) {
        Cursor c = database.query(RADICALS_TABLE, null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        Radical radical = null;

        if(c.getCount() > 0) {
            c.moveToPosition(0);
            radical = RadicalMapper.map(c);
            c.close();
        }

        return radical;
    }

    public List<Kanji> searchKanji(String query) {
        Cursor c = database.query(KANJI_TABLE, null, "id IN (SELECT id FROM kanjifts WHERE meanings MATCH ?)", new String[] {query}, null, null, null);
        List<Kanji> kanjiList = new ArrayList<>();

        if(c.getCount() > 0) {
            while(c.moveToNext()) {
                kanjiList.add(KanjiMapper.map(c));
            }

            c.close();
        }

        return kanjiList;
    }
}
