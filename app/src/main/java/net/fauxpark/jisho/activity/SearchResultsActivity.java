package net.fauxpark.jisho.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import net.fauxpark.jisho.R;
import net.fauxpark.jisho.adapter.KanjiListAdapter;
import net.fauxpark.jisho.model.Kanji;
import net.fauxpark.jisho.task.SearchTask;

public class SearchResultsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            TextView empty = (TextView) findViewById(R.id.empty);
            ListView list = (ListView) findViewById(R.id.list);
            KanjiListAdapter adapter = new KanjiListAdapter(this, new ArrayList<Kanji>());
            list.setAdapter(adapter);
            new SearchTask(this, empty, list, adapter).execute(query);
        }
    }
}
