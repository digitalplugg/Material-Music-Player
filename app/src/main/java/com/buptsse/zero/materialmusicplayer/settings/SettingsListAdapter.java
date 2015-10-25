package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.buptsse.zero.materialmusicplayer.R;

public class SettingsListAdapter extends BaseAdapter {

    private String settingsItem[] = null;
    Context context;
    SettingsListAdapter(Context context)
    {
        settingsItem = context.getResources().getStringArray(R.array.settings_item);
        this.context = context;
    }

    @Override
    public int getCount() {
        return settingsItem.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.settings_list_item, null);
        ((TextView)view.findViewById(R.id.settings_item_title)).setText(settingsItem[position]);
        ((ImageView)view.findViewById(R.id.settings_item_icon)).setImageLevel(position);
        return view;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return R.array.settings_item;
    }
}
