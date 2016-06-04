package net.fauxpark.jisho.task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import net.fauxpark.jisho.datasource.KanjiDataSource;
import net.fauxpark.jisho.model.Kanji;

public class SearchTask extends AsyncTask<String, Void, Kanji> {
    private static final String TAG = "SearchTask";

    private Context context;

    public SearchTask(Context context) {
        this.context = context;
    }

    @Override
    protected Kanji doInBackground(String... params) {
        KanjiDataSource kanjiDataSource = new KanjiDataSource(context);
        Kanji kanji = kanjiDataSource.getKanjiById(Integer.parseInt(params[0]));
        kanjiDataSource.close();

        return kanji;
    }

    @Override
    protected void onPostExecute(Kanji kanji) {
        Log.d(TAG, "Result: " + kanji.getLiteral());
    }
}
