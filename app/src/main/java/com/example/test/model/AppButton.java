package com.example.test.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;

import java.util.function.Function;

public class AppButton extends UserButton{
    public static double size_x = 100;
    public static double size_y = 100;
    public AppButton(String app, Bitmap image, double x, double y, Context context, ViewGroup layout) {
        super(() -> {
            System.out.println("opening " + app);
        }, image, x, y, size_x, size_y, context, layout);
    }
}
