package com.example.daggerhomework.presenter;

import com.example.daggerhomework.GitApplication;
import com.example.daggerhomework.contracts.UserContract;
import com.example.daggerhomework.model.data.UserModel;
import com.example.daggerhomework.model.repository.UserRepository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

public class UserPresenter implements UserContract.Presenter, Subscriber<UserModel> {

    @Inject
    UserRepository repository;

    private UserContract.View view;
    private String user;

    public UserPresenter(UserContract.View view) {
        this.view = view;
        GitApplication.getComponentInstance().inject(this);
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(UserModel userModel) {
        view.showUser(userModel);
    }

    @Override
    public void onComplete() {
        view.finishLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        view.showError(e.getLocalizedMessage());
    }

    @Override
    public void loadData() {
        repository.getUser(user).subscribe(this);
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }
}
