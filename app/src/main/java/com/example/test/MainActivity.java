package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.test.model.AppButton;
import com.example.test.model.AppLayout;
import com.example.test.model.FolderButton;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton dropdownButton;
    private ImageButton addButton;
    private ImageButton settingsButton;
    private ImageButton folderButton;
    private ImageButton shortcutButton;
    private ImageButton homeButton;
    private boolean isDropdownOpen = false;
    private boolean areSubButtonsVisible = false;
    private AppLayout appLayout;

    private AppLayout open;
    private LinkedList<View> toBlur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        dropdownButton = findViewById(R.id.dropdown_menu);
        addButton = findViewById(R.id.addButton);
        settingsButton = findViewById(R.id.settingsButton);
        folderButton = findViewById(R.id.folderButton);
        shortcutButton = findViewById(R.id.shortcutButton);
        homeButton = findViewById(R.id.homeButton);
        ViewGroup layout = findViewById(R.id.layout);

        toBlur = new LinkedList<>();
        for(int index = 0; index < layout.getChildCount(); index++) {
            toBlur.add(layout.getChildAt(index));
        }
        Listener listener = new Listener(toBlur);

        dropdownButton.setOnClickListener(listener);
        addButton.setOnClickListener(listener);
        homeButton.setOnClickListener(listener);
        layout.setOnClickListener(listener);
        settingsButton.setOnClickListener(listener);
        shortcutButton.setOnClickListener(listener);
        folderButton.setOnClickListener(listener);
        appLayout = new AppLayout(context, layout);
        open = appLayout;
    }
    private void userAddAppButton(){
        AppButton button = open.newAppButton();
        open.addButton(button);
        toBlur.add(button.getImageButton());
    }

    private void userAddFolderButton(){
        FolderButton button = open.newFolderButton();
        open.addButton(button);
        toBlur.add(button.getImageButton());
    }

    private class Listener implements View.OnClickListener {
        private final RenderEffect blurEffect;
        private List<View> toBlur;

        Listener(LinkedList<View> toBlur){
            this.toBlur = toBlur;
            blurEffect = RenderEffect.createBlurEffect(8, 8 , Shader.TileMode.MIRROR);
        }
        @Override
        public void onClick(View view) {
            if(view == addButton) {
                if (!areSubButtonsVisible) {
                    // Öffne die Sub-Buttons
                    folderButton.setVisibility(View.VISIBLE);
                    shortcutButton.setVisibility(View.VISIBLE);
                    // Füge hier Logik hinzu, um den Rest des Bildschirms zu verschwimmen.
                    toBlur.remove(addButton);
                    toBlur.remove(folderButton);
                    toBlur.remove(shortcutButton);
                    for(View v:toBlur){
                        v.setRenderEffect(blurEffect);
                        if(v instanceof ImageButton || v instanceof Button){
                            v.setEnabled(false);
                        }
                    }
                } else {
                    folderButton.setVisibility(View.GONE);
                    shortcutButton.setVisibility(View.GONE);
                    // Mache den Rest des Bildschirms nicht mehr verschwommen (falls vorher verschwommen)
                    // Hier musst du Logik hinzufügen, um die Blur-Effekte zu entfernen.
                    toBlur.add(addButton);
                    toBlur.add(folderButton);
                    toBlur.add(shortcutButton);
                    for(View v:toBlur){
                        v.setRenderEffect(null);
                        if(v instanceof ImageButton || v instanceof Button){
                            v.setEnabled(true);
                        }
                    }
                }
                areSubButtonsVisible = !areSubButtonsVisible;
            } else if(view == dropdownButton) {
                if (!isDropdownOpen) {
                    // Dropdown öffnen
                    addButton.setVisibility(View.VISIBLE);
                    settingsButton.setVisibility(View.VISIBLE);
                    // Starte die Animation
                    //dropdownAnimation.start();
                } else {
                    addButton.setVisibility(View.GONE);
                    settingsButton.setVisibility(View.GONE);
                }
                isDropdownOpen = !isDropdownOpen;
            } else if (view == shortcutButton) {
                userAddAppButton();
            } else if (view == folderButton) {
                userAddFolderButton();
            } else if (view == homeButton) {
                open.hide();
                appLayout.show();
                open = appLayout;
            } else if (view == settingsButton) {
            } else {
                if (areSubButtonsVisible) {
                    // Schließe die Sub-Buttons
                    folderButton.setVisibility(View.GONE);
                    shortcutButton.setVisibility(View.GONE);
                    // Mache den Rest des Bildschirms nicht mehr verschwommen (falls vorher verschwommen)
                    // Hier musst du Logik hinzufügen, um die Blur-Effekte zu entfernen.
                    areSubButtonsVisible = false;
                    if(!toBlur.contains(addButton)){
                        toBlur.add(addButton);
                        toBlur.add(folderButton);
                        toBlur.add(shortcutButton);for(View v:toBlur){
                            v.setRenderEffect(null);
                            if(v instanceof ImageButton || v instanceof Button){
                                v.setEnabled(true);
                            }
                        }
                    }
                }
                if (isDropdownOpen) {
                    // Dropdown schließen
                    addButton.setVisibility(View.GONE);
                    settingsButton.setVisibility(View.GONE);
                    isDropdownOpen = false;
                }
            }
        }
    }

    public void openAppLayout(AppLayout appLayout){
        this.open.hide();
        this.open = appLayout;
        this.open.show();
    }
}