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

public class MainActivity extends AppCompatActivity {

    private ImageButton dropdownButton;
    private ImageButton addButton;
    private ImageButton settingsButton;

    private boolean isDropdownOpen = false;
    private final Context context = this;

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdownButton = findViewById(R.id.dropdown_menu);
        addButton = findViewById(R.id.addButton);
        settingsButton = findViewById(R.id.settingsButton);
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
            public void onClick(View view) {
                userAdd();
            }
        });
    }
    private void userAdd(){

    }
}