package net.fauxpark.jisho.activity;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;

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
}
