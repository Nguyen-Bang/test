package com.example.test.model;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.test.MainActivity;
import com.example.test.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppLayout {
    private final ArrayList<UserButton> buttons;
    private final Context context;
    private final ViewGroup layout;

    private final MainActivity main_activity;

    public AppLayout(Context context, ViewGroup layout){
        buttons = new ArrayList<>();
        this.context = context;
        this.layout = layout;
        this.main_activity = (MainActivity) context;
    }

    public void addButton(UserButton button){
        buttons.add(button);
        layout.addView(button.getImageButton());
        updateLayout();
    }

    public AppButton newAppButton(){
        return new AppButton("YouTube", null, 500, 500, context, layout);
    }

    public FolderButton newFolderButton(){
        return new FolderButton("demo folder", null, 500, 500, context, main_activity ,layout);
    }

    public void updateLayout(){
        doDelete();
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

    public void hide(){
        for(UserButton button:buttons){
            button.getImageButton().setVisibility(View.GONE);
        }
    }

    public void show(){
        for(UserButton button:buttons){
            button.getImageButton().setVisibility(View.VISIBLE);
        }
    }

    public void doDelete(){
        List<UserButton> toDelete = new LinkedList<>();
        for(UserButton b:buttons){
            if(b.isDeleted()){
                toDelete.add(b);
            }
        }
        buttons.removeAll(toDelete);
    }
}
