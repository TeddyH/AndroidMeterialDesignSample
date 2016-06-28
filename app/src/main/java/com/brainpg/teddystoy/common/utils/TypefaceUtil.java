package com.brainpg.teddystoy.common.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public class TypefaceUtil {

    public static void overrideFont(Context context, String defaultFontNameToOverride,
                                    String customFontFileName) {
        Typeface customFontTypeFace = Typeface.createFromAsset(context.getAssets(), customFontFileName);
        replaceFont(defaultFontNameToOverride, customFontTypeFace);
    }

    protected static void replaceFont(String defaultFontNameToOverride,
                                      Typeface customFontTypeFace) {
        try {
            Field staticField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            staticField.setAccessible(true);
            staticField.set(null, customFontTypeFace);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


