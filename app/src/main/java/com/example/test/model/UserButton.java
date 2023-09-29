package com.example.test.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;

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
        imageButton.setImageBitmap(image);
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
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }
}
