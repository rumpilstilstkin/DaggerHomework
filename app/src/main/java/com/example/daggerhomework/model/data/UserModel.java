package com.example.daggerhomework.model.data;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.Nullable;

public class UserModel {
    @Nullable
    @SerializedName("avatar_url")
    public String imageUrl;

    @Nullable
    public String login;
}
