package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.buptsse.zero.materialmusicplayer.R;

public class AppSharePreference {
    private static SharedPreferences globalPreference = null;

    public static final int appThemeID[] = new int[]{R.style.AppTheme, R.style.AppRedTheme,
        R.style.AppOrangeTheme, R.style.AppGreenTheme};

    public static void initPreference(Context context)
    {
        globalPreference = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
    }

    public static int getThemeResID(Context context)
    {
        int pos = globalPreference.getInt(context.getResources().getString(R.string.theme_color_key), 0);
        return appThemeID[pos];
    }
}
