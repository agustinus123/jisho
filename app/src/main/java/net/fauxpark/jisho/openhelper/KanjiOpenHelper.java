package net.fauxpark.jisho.openhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KanjiOpenHelper extends SQLiteOpenHelper {
    private static KanjiOpenHelper kanjiOpenHelper = null;

    private static final String DBNAME = "kanji.db";

    private KanjiOpenHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    public static KanjiOpenHelper getInstance(Context context) {
        if(kanjiOpenHelper == null) {
            kanjiOpenHelper = new KanjiOpenHelper(context.getApplicationContext());
        }

        return kanjiOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
