package com.example.daggerhomework;

import android.app.Application;

import com.example.daggerhomework.di.DaggerSingletonComponent;
import com.example.daggerhomework.di.SingletonComponent;

public class GitApplication extends Application {

    private static SingletonComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerSingletonComponent.create();
    }

    public static SingletonComponent getComponentInstance(){
        return component;
    }
}
