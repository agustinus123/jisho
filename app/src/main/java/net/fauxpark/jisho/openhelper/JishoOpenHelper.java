package net.fauxpark.jisho.openhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JishoOpenHelper extends SQLiteOpenHelper {
    private static JishoOpenHelper jishoOpenHelper = null;

    private static final String DBNAME = "jisho.db";

    private JishoOpenHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    public static JishoOpenHelper getInstance(Context context) {
        if(jishoOpenHelper == null) {
            jishoOpenHelper = new JishoOpenHelper(context.getApplicationContext());
        }

        return jishoOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
