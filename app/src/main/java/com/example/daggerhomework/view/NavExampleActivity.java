package com.example.daggerhomework.view;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.example.daggerhomework.R;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


public class NavExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_example);

        BottomNavigationView navigation = findViewById(R.id.navigation);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.my_nav_host_fragment);

        NavigationUI.setupWithNavController(navigation, navHostFragment.getNavController());
    }
}
