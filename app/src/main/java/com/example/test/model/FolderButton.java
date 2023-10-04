package com.example.test.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.test.MainActivity;
import com.example.test.R;

public class FolderButton extends UserButton{
    public static double size_x = 100;
    public static double size_y = 100;

    private final AppLayout folder;
    public FolderButton(String name, Bitmap image, double x, double y, Context context, MainActivity activity, ViewGroup layout) {
        super(()->{}, image, x, y, size_x, size_y, context, layout);
        folder = new AppLayout(context, layout);
        this.setFunction(() -> {
            System.out.println("opening " + name);
            activity.openAppLayout(folder);}
        );
        if(image != null){
            this.getImageButton().setImageBitmap(image);
        } else {
            this.getImageButton().setImageResource(R.drawable.folder);
            this.getImageButton().setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public AppLayout getAppLayout(){
        return folder;
    }

}
