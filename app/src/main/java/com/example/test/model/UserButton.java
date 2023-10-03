package com.example.test.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.test.R;

import java.util.function.Function;


public abstract class UserButton {

    private Button_Function function;
    private Bitmap image;

    private double x,y;
    private double w,h;

    private final Context context;
    private ImageButton imageButton;

    public UserButton(Button_Function function, Bitmap image, double x, double y, double w, double h, Context context) {
        this.function = function;
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.context = context;
        imageButton = new ImageButton(context);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function.execute();
            }
        });
        imageButton.setX((float) x);
        imageButton.setY((float) y);
        imageButton.setId(View.generateViewId());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int)w, (int)h);
        imageButton.setLayoutParams(layoutParams);
        if(image != null){
            imageButton.setImageBitmap(image);
        } else {
            imageButton.setImageResource(R.drawable.shortcut);
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public Button_Function getFunction() {
        return function;
    }

    public void setFunction(Button_Function function) {
        this.function = function;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
        imageButton.setImageBitmap(image);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        if (imageButton.getLayoutParams() instanceof RelativeLayout.LayoutParams){
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageButton.getLayoutParams();
            layoutParams.leftMargin = (int) x;
            imageButton.setLayoutParams(layoutParams);
        } else {
            imageButton.setX((float) x);
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        if (imageButton.getLayoutParams() instanceof RelativeLayout.LayoutParams){
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageButton.getLayoutParams();
            layoutParams.topMargin = (int) y;
            imageButton.setLayoutParams(layoutParams);
        } else {
            imageButton.setY((float) y);
        }
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        layoutParams.width = (int) w;
        imageButton.setLayoutParams(layoutParams);
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        layoutParams.height = (int) h;
        imageButton.setLayoutParams(layoutParams);
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }
}
