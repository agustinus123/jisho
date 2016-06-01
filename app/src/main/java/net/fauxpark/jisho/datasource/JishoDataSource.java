package net.fauxpark.jisho.datasource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.fauxpark.jisho.mapper.WordMapper;
import net.fauxpark.jisho.model.Word;
import net.fauxpark.jisho.openhelper.JishoOpenHelper;

public class JishoDataSource {
    private static final String JISHO_TABLE = "jisho";

    private SQLiteDatabase database;

    private JishoOpenHelper jishoOpenHelper;

    public JishoDataSource(Context context) {
        jishoOpenHelper = JishoOpenHelper.getInstance(context);
        database = jishoOpenHelper.getReadableDatabase();
    }

    public void close() {
        jishoOpenHelper.close();
    }

    public Word getWordById(int id) {
        Cursor c = database.query(JISHO_TABLE, null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        Word word = null;

        if(c.getCount() > 0) {
            c.moveToPosition(0);
            word = WordMapper.map(c);
            c.close();
        }

        return word;
    }
}
