package com.example.test.model;

import android.content.Context;
import android.widget.ImageButton;

import java.util.function.Function;

public abstract class UserButton {

    private Function<Void,Void> function;
    private String image;

    private double x,y;
    private double w,h;

    private Context context;
    private ImageButton imageButton;

    public UserButton(Function<Void, Void> function, String image, double x, double y, double w, double h, Context context) {
        this.function = function;
        this.image = image;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.context = context;
    }

    public Function<Void, Void> getFunction() {
        return function;
    }

    public void setFunction(Function<Void, Void> function) {
        this.function = function;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
}
