package com.example.daggerhomework.di;

import com.example.daggerhomework.contracts.RepoDetailsContract;
import com.example.daggerhomework.contracts.RepoListContract;
import com.example.daggerhomework.contracts.UserContract;
import com.example.daggerhomework.presenter.RepoDetailsPresenter;
import com.example.daggerhomework.presenter.RepoListPresenter;
import com.example.daggerhomework.presenter.UserPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface SingletonComponent {
    void inject(RepoListPresenter presenter);
    void inject(UserPresenter presenter);
    void inject(RepoDetailsPresenter presenter);

}
