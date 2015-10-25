package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.buptsse.zero.materialmusicplayer.R;
import com.buptsse.zero.materialmusicplayer.ThemeColor;

public class ColorListPreference extends CheckBoxPreference
{
    private Context context;
    private CheckBox dummyCheckBox;
    private ImageView colorIconImage;
    private int preSelectItemPos;

    public ColorListPreference(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        colorIconImage = new ImageView(context);
        colorIconImage.setImageResource(R.drawable.color_circle);
        colorIconImage.setImageLevel(0);
    }

    public ColorListPreference(Context context)
    {
        super(context);
        this.context = context;
        colorIconImage = new ImageView(context);
        colorIconImage.setImageResource(R.drawable.color_circle);
        colorIconImage.setImageLevel(0);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        dummyCheckBox = (CheckBox)view.findViewById(android.R.id.checkbox);
        dummyCheckBox.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
        dummyCheckBox.setWidth(context.getResources().getDimensionPixelSize(R.dimen.icon_large_size));
        dummyCheckBox.setHeight(context.getResources().getDimensionPixelSize(R.dimen.icon_large_size));
        preSelectItemPos = getThemeOptionValue();
        setColorIconImage(preSelectItemPos);
    }

    private void setColorIconImage(int value)
    {
        colorIconImage.setImageLevel(value);
        dummyCheckBox.setBackgroundDrawable(colorIconImage.getDrawable());
    }

    private int getThemeOptionValue()
    {
        return getSharedPreferences().getInt(context.getResources().getString(R.string.theme_color_key), 0);
    }

    private void setThemeOptionValue(int value)
    {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(context.getResources().getString(R.string.theme_color_key), value);
        editor.commit();
    }

    @Override
    protected void onClick() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(context.getResources().getString(R.string.theme_color_lable));
        final ColorListAdapter adapter = new ColorListAdapter(context, context.getResources().getStringArray(R.array.theme_option_array),
                                                              R.drawable.color_circle);
        alertDialogBuilder.setAdapter(adapter, null);
        alertDialogBuilder.setNegativeButton(R.string.cancel_label, null);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ThemeColor.getAccentColor(context));
                adapter.setItemChecked(preSelectItemPos, true);
                for(int i = 0; i < adapter.getCount(); i++)
                {
                    final int pos = i;
                    adapter.setItemOnClickListener(i, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setThemeOptionValue(pos);
                            setColorIconImage(pos);
                            preSelectItemPos = pos;
                            alertDialog.dismiss();
                        }
                    });
                }
            }

        });
        alertDialog.show();
    }
}
