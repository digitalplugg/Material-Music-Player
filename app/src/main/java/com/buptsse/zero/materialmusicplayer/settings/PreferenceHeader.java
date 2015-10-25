package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.widget.TextView;

import com.buptsse.zero.materialmusicplayer.R;

public class PreferenceHeader extends Preference {
    private String title;

    public PreferenceHeader(Context context, String title){
        super(context);
        this.title = title;
        setLayoutResource(R.layout.preference_header);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        view.setClickable(false);
        ((TextView)view.findViewById(R.id.preference_header_title)).setText(title.toUpperCase());
    }
}
