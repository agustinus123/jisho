package net.fauxpark.jisho.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import net.fauxpark.jisho.BuildConfig;
import net.fauxpark.jisho.R;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference prefVersion = findPreference("prefVersion");
        prefVersion.setSummary(BuildConfig.VERSION_NAME + "-" + BuildConfig.BUILD_TYPE);
    }
}
