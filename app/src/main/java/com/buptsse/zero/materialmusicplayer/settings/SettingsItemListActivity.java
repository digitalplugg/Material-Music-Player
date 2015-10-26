package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.buptsse.zero.materialmusicplayer.MainActivity;
import com.buptsse.zero.materialmusicplayer.R;
import com.buptsse.zero.materialmusicplayer.settings.provider.AppSharePreference;

public class SettingsItemListActivity extends AppCompatActivity
        implements SettingsItemListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(AppSharePreference.getThemeResID(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_app_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_settings_activity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (findViewById(R.id.settings_item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            SettingsItemListFragment fragment = (SettingsItemListFragment)getFragmentManager().findFragmentById(R.id.fragment_settings_item_list);
            fragment.setActivateOnItemClick(true);
            fragment.getListView().setItemChecked(0, true);
            fragment.onListItemClick(fragment.getListView(), null, 0, 0);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback method from {@link SettingsItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(int position) {
        String preferenceTitle = getResources().getStringArray(R.array.settings_item)[position];
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(SettingsItemDetailFragment.ARG_ITEM_POS, position);
            SettingsItemDetailFragment fragment = new SettingsItemDetailFragment();
            fragment.setIsTowPane(true);
            fragment.setPreferenceTitle(preferenceTitle);
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.settings_item_detail_container, fragment).commit();

        } else {
            Intent detailIntent = new Intent(this, SettingsItemDetailActivity.class);
            detailIntent.putExtra(SettingsItemDetailFragment.ARG_ITEM_POS, position);
            detailIntent.putExtra(SettingsItemDetailActivity.ARG_TITLE, preferenceTitle);
            startActivity(detailIntent);
        }
    }
}
