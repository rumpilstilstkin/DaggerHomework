package com.example.daggerhomework.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerhomework.R;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class NavigateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        NavigationUI.setupWithNavController(navigation, navHostFragment.getNavController());
    }

}
