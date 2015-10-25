package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.buptsse.zero.materialmusicplayer.R;

public class ColorListAdapter extends BaseAdapter {

    private String[] colorNameArray;
    private int levelListResID;
    private Context context;
    private View itemView[];

    public ColorListAdapter(Context context, String[] colorNameArray, int levelListResID) {
        this.context = context;
        this.colorNameArray = colorNameArray;
        this.levelListResID = levelListResID;
        itemView = new View[colorNameArray.length];
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        itemView[position] = View.inflate(context, R.layout.list_radiobutton_item, null);
        ImageView itemIcon = (ImageView)itemView[position].findViewById(R.id.list_item_icon);
        itemIcon.setImageResource(levelListResID);
        itemIcon.setImageLevel(position);
        itemIcon.setVisibility(View.VISIBLE);
        ((TextView)itemView[position].findViewById(R.id.list_item_name)).setText(colorNameArray[position]);
        return itemView[position];
    }

    public void setItemOnClickListener(int pos, View.OnClickListener listener)
    {
        itemView[pos].setOnClickListener(listener);
    }

    public void setItemChecked(int position, boolean checked)
    {
        ((RadioButton)itemView[position].findViewById(R.id.list_item_radio_button)).setChecked(checked);
    }

    public boolean getItemChecked(int position)
    {
        return ((RadioButton)itemView[position].findViewById(R.id.list_item_radio_button)).isChecked();
    }
}
