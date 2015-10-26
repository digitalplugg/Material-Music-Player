package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.buptsse.zero.materialmusicplayer.R;
import com.buptsse.zero.materialmusicplayer.settings.provider.AppSharePreference;
import com.buptsse.zero.materialmusicplayer.settings.provider.ThemeColor;

public class ColorListPreference extends CheckBoxPreference {
    private Context context;
    private CheckBox dummyCheckBox;
    private static ImageView colorIconImage = null;
    private int preSelectItemPos;


    public ColorListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        if (colorIconImage == null) {
            colorIconImage = new ImageView(context);
            colorIconImage.setImageResource(R.drawable.color_circle);
        }
        colorIconImage.setImageLevel(0);
    }

    public ColorListPreference(Context context) {
        super(context);
        this.context = context;
        if (colorIconImage == null) {
            colorIconImage = new ImageView(context);
            colorIconImage.setImageResource(R.drawable.color_circle);
        }
        colorIconImage.setImageLevel(0);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        dummyCheckBox = (CheckBox) view.findViewById(android.R.id.checkbox);
        dummyCheckBox.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
        dummyCheckBox.setWidth(context.getResources().getDimensionPixelSize(R.dimen.icon_large_size));
        dummyCheckBox.setHeight(context.getResources().getDimensionPixelSize(R.dimen.icon_large_size));
        preSelectItemPos = AppSharePreference.getThemeOptionValue(context);
        setColorIconImage(preSelectItemPos);
    }

    private void setColorIconImage(int value) {
        colorIconImage.setImageLevel(value);
        dummyCheckBox.setBackgroundDrawable(colorIconImage.getDrawable());
    }

    @Override
    protected void onClick() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(context.getResources().getString(R.string.theme_color_lable));
        final ColorListAdapter adapter = new ColorListAdapter(context, context.getResources().getStringArray(R.array.theme_option_array),
                R.drawable.color_circle);
        adapter.setCheckItemPos(preSelectItemPos);
        alertDialogBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                preSelectItemPos = which;
                setColorIconImage(which);
                AppSharePreference.setThemeOptionValue(context, which);
            }
        });
        /*alertDialogBuilder.setItems(context.getResources().getStringArray(R.array.theme_option_array), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Item " + which + " click.");
            }
        });*/
        alertDialogBuilder.setNegativeButton(R.string.cancel_label, null);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ThemeColor.getAccentColor(context));
            }
        });
        alertDialog.show();
    }
}