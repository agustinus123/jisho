package net.fauxpark.jisho.task;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import net.fauxpark.jisho.adapter.KanjiListAdapter;
import net.fauxpark.jisho.datasource.KanjiDataSource;
import net.fauxpark.jisho.model.Kanji;

public class SearchTask extends AsyncTask<String, Void, List<Kanji>> {
    private static final String TAG = "SearchTask";

    private Context context;

    private TextView empty;

    private ListView list;

    private KanjiListAdapter adapter;

    public SearchTask(Context context, TextView empty, ListView list, KanjiListAdapter adapter) {
        this.context = context;
        this.empty = empty;
        this.list = list;
        this.adapter = adapter;
    }

    @Override
    protected List<Kanji> doInBackground(String... params) {
        KanjiDataSource kanjiDataSource = new KanjiDataSource(context);
        List<Kanji> kanjiList = kanjiDataSource.searchKanji(params[0]);
        kanjiDataSource.close();

        return kanjiList;
    }

    @Override
    protected void onPostExecute(List<Kanji> kanjiList) {
        Log.d(TAG, "Result size: " + kanjiList.size());

        if(kanjiList.size() > 0) {
            adapter.addAll(kanjiList);
        } else {
            list.setVisibility(View.GONE);
            empty.setVisibility(View.VISIBLE);
        }
    }
}
