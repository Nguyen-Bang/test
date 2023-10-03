package com.example.test.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.*;
import android.view.View;

public class BlurUtils {

    public static void applyBlur(Context context, View view) {
        Bitmap bitmap = getBitmapFromView(view);
        RenderScript renderScript = RenderScript.create(context);
        final Allocation input = Allocation.createFromBitmap(renderScript, bitmap);
        final Allocation output = Allocation.createTyped(renderScript, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));

        script.setInput(input);
        script.setRadius(25f); // Sie können den Radius anpassen, um den Blur-Effekt zu ändern

        script.forEach(output);
        output.copyTo(bitmap);

        view.setBackground(new BitmapDrawable(context.getResources(), bitmap));

        renderScript.destroy();
    }

    private static Bitmap getBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
