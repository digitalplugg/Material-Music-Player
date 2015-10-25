package com.buptsse.zero.materialmusicplayer.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.buptsse.zero.materialmusicplayer.R;

public class SettingsItemDetailFragment extends PreferenceFragment {
    public static final String ARG_ITEM_POS = "item_pos";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    private boolean mTwoPane = false;
    private String title = "";
    public SettingsItemDetailFragment() { }

    public void setPreferenceTitle(String title) {
        this.title = title;
    }

    public void setIsTowPane(boolean isTowPane) {
        mTwoPane = isTowPane;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mTwoPane) {
            setPreferenceScreen(getPreferenceManager().createPreferenceScreen(getActivity()));
            getPreferenceScreen().addPreference(new PreferenceHeader(getActivity(), title));
        }
        int item_id = getArguments().getInt(ARG_ITEM_POS, 0);
        switch (item_id)
        {
            case 0:
                addPreferencesFromResource(R.xml.settings_appearance_preference);
                break;
            case 1:
                addPreferencesFromResource(R.xml.settings_about_preference);
                break;
        }
    }
}
