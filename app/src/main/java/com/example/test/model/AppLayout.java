package com.example.test.model;

import android.content.Context;
import android.text.Layout;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.test.R;

import java.util.ArrayList;

public class AppLayout {
    private final ArrayList<UserButton> buttons;
    private final Context context;
    private final ViewGroup layout;

    public AppLayout(Context context, ViewGroup layout){
        buttons = new ArrayList<>();
        this.context = context;
        this.layout = layout;
    }

    public void addButton(UserButton button){
        buttons.add(button);
        layout.addView(button.getImageButton());
        updateLayout();
    }

    public AppButton newAppButton(){
        return new AppButton("YouTube", null, 500, 500, context);
    }

    public void updateLayout(){
        int size = buttons.size();
        for(int i = 0; i < size; i++){
            UserButton button = buttons.get(i);
            moveButton(button, -220 + (i%4 - 1)*110, -110 + i * 110);
        }
    }

    private void moveButton(UserButton button, int x, int y){
        button.setY(y);
        button.setX(x);
        layout.updateViewLayout(button.getImageButton(), button.getImageButton().getLayoutParams());
    }
}
