package com.buptsse.zero.materialmusicplayer.settings.provider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import com.buptsse.zero.materialmusicplayer.R;

public class ThemeColor
{
    public static int getPrimaryColor(Context context)
    {
        TypedArray ColorAttr = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        return ColorAttr.getColor(0, Color.BLACK);
    }

    public static int getAccentColor(Context context)
    {
        TypedArray ColorAttr = context.getTheme().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        return ColorAttr.getColor(0, Color.BLACK);
    }
}
