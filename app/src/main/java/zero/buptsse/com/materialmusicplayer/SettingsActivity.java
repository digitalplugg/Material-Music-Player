package zero.buptsse.com.materialmusicplayer;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_settings);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_settings_activity));
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(getFragmentManager().findFragmentById(R.id.fragment_settings_activity), "Settings");
        transaction.commit();
    }
}
