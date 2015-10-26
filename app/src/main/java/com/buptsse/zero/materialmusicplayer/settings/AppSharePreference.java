package com.buptsse.zero.materialmusicplayer.settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.buptsse.zero.materialmusicplayer.R;

public class AppSharePreference {
    private static SharedPreferences globalPreference = null;

    public static final int appThemeID[] = new int[]{R.style.AppTheme, R.style.AppRedTheme,
        R.style.AppOrangeTheme, R.style.AppGreenTheme, R.style.AppTealTheme,
        R.style.AppPinkTheme, R.style.AppPurpleTheme, R.style.AppCyanTheme,
        R.style.AppGrassGreenTheme, R.style.AppLimeTheme, R.style.AppBlueGreyTheme};

    public static void initPreference(Context context)
    {
        globalPreference = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
    }

    public static int getThemeResID(Context context)
    {
        int pos = getThemeOptionValue(context);
        return appThemeID[pos];
    }

    public static int getThemeOptionValue(Context context)
    {
        return globalPreference.getInt(context.getResources().getString(R.string.theme_color_key), 0);
    }

    public static void setThemeOptionValue(Context context, int value) {
        SharedPreferences.Editor editor = globalPreference.edit();
        editor.putInt(context.getResources().getString(R.string.theme_color_key), value);
        editor.commit();
    }
}
