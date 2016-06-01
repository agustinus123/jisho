package net.fauxpark.jisho.activity;

import java.io.File;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import net.fauxpark.jisho.R;
import net.fauxpark.jisho.task.UnzipTask;
import net.fauxpark.jisho.util.DatabaseUtil;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!new File(DatabaseUtil.getDatabasePath(this) + "jisho.db").exists()) {
            new UnzipTask(this).execute();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchMenuItem).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settingsMenuItem:
                startActivity(new Intent(this, SettingsActivity.class));

                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
