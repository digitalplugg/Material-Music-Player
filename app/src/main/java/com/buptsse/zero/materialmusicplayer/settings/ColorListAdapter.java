package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.buptsse.zero.materialmusicplayer.R;

public class ColorListAdapter extends BaseAdapter {

    private String[] colorNameArray;
    private int levelListResID;
    private Context context;
    private int checkItemPos = 0;

    public ColorListAdapter(Context context, String[] colorNameArray, int levelListResID) {
        this.context = context;
        this.colorNameArray = colorNameArray;
        this.levelListResID = levelListResID;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return colorNameArray.length;
    }

    public void setCheckItemPos(int pos) {
        checkItemPos = pos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View newView = null;
        if(convertView == null)
            newView = View.inflate(context, R.layout.list_radiobutton_item, null);
        else
            newView = convertView;
        ImageView itemIcon = (ImageView)newView.findViewById(R.id.list_item_icon);
        itemIcon.setImageResource(levelListResID);
        itemIcon.setImageLevel(position);
        itemIcon.setVisibility(View.VISIBLE);
        ((TextView)newView.findViewById(R.id.list_item_name)).setText(colorNameArray[position]);
        if(position == checkItemPos) {
            ((RadioButton) newView.findViewById(R.id.list_item_radio_button)).setChecked(true);
            newView.requestFocus();
        }
        else
            ((RadioButton)newView.findViewById(R.id.list_item_radio_button)).setChecked(false);
        return newView;
    }
}
