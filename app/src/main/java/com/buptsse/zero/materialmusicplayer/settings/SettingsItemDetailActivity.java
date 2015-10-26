package com.buptsse.zero.materialmusicplayer.settings;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.buptsse.zero.materialmusicplayer.R;
import com.buptsse.zero.materialmusicplayer.settings.provider.AppSharePreference;

public class SettingsItemDetailActivity extends AppCompatActivity {
    public static final String ARG_TITLE = "arg_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(AppSharePreference.getThemeResID(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_settings_detail_activity);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra(ARG_TITLE);
        if(title != null)
            setTitle(title);
        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(SettingsItemDetailFragment.ARG_ITEM_POS,
                    getIntent().getIntExtra(SettingsItemDetailFragment.ARG_ITEM_POS, 0));
            SettingsItemDetailFragment fragment = new SettingsItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction().add(R.id.settings_item_detail_activity_container, fragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, SettingsItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
