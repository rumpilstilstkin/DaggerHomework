package com.example.daggerhomework.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daggerhomework.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
