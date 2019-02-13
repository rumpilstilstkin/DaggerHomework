package com.example.daggerhomework.view.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.UserContract;
import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.presenter.UserPresenter;
import com.example.daggerhomework.view.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsFragment extends Fragment implements UserContract.View{
    private static final String ARG_USER = "param1";

    @BindView(R.id.profile_name)
    TextView name;

    @BindView(R.id.profile_image)
    ImageView image;

    private UserContract.Presenter presenter;

    private String user;

    public static Bundle getArguments(String user) {
        Bundle args = new Bundle();
        args.putString(ARG_USER, user);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getString(ARG_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_details, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    @Override
    public void startLoading() {
        //TODO start loading
    }

    @Override
    public void finishLoading() {
        //TODO finish loading
    }

    @Override
    public void showError(String string) {
        //TODO show error
    }

    @Override
    public void showUser(UserModel user) {
        name.setText(user.login);
        GlideApp
                .with(this)
                .load(user.imageUrl)
                .into(image);
    }

    private void initPresenter() {
        presenter = new UserPresenter(this);
        presenter.setUser(user);
        presenter.loadData();
    }
}
