package net.fauxpark.jisho.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import net.fauxpark.jisho.fragment.SettingsFragment;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
