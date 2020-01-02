package com.shanshui.customviewdemo;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }

    public static boolean isInt(float f) {
        int i = (int) f;
        if (f == i) {
            return true;
        }
        return false;
    }
}
