package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.test.model.AppButton;
import com.example.test.model.UserButton;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton dropdownButton;
    private ImageButton addButton;
    private ImageButton settingsButton;
    private ImageButton folderButton;
    private ImageButton shortcutButton;

    private boolean isDropdownOpen = false;
    private boolean areSubButtonsVisible = false;
    private final Context context = this;

    private ConstraintLayout layout;

    private List<UserButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new LinkedList<>();

        dropdownButton = findViewById(R.id.dropdown_menu);
        addButton = findViewById(R.id.addButton);
        settingsButton = findViewById(R.id.settingsButton);
        folderButton = findViewById(R.id.folderButton);
        shortcutButton = findViewById(R.id.shortcutButton);
        layout = findViewById(R.id.layout);

        dropdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDropdownOpen) {
                    // Dropdown schließen
                    addButton.setVisibility(View.GONE);
                    settingsButton.setVisibility(View.GONE);
                    isDropdownOpen = false;
                } else {
                    // Dropdown öffnen
                    addButton.setVisibility(View.VISIBLE);
                    settingsButton.setVisibility(View.VISIBLE);
                    isDropdownOpen = true;

                    // Starte die Animation
                    //dropdownAnimation.start();
                }
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (areSubButtonsVisible) {
                    // Schließe die Sub-Buttons
                    folderButton.setVisibility(View.GONE);
                    shortcutButton.setVisibility(View.GONE);
                    areSubButtonsVisible = false;
                    // Mache den Rest des Bildschirms nicht mehr verschwommen (falls vorher verschwommen)
                    // Hier musst du Logik hinzufügen, um die Blur-Effekte zu entfernen.
                } else {
                    // Öffne die Sub-Buttons
                    folderButton.setVisibility(View.VISIBLE);
                    shortcutButton.setVisibility(View.VISIBLE);
                    areSubButtonsVisible = true;
                    // Füge hier Logik hinzu, um den Rest des Bildschirms zu verschwimmen.
                }
            }
        });
    }
    private void userAdd(){
        UserButton next = new AppButton("YouTube", null, 500, 500, context);
        list.add(next);
        layout.addView(next.getImageButton());
    }
}