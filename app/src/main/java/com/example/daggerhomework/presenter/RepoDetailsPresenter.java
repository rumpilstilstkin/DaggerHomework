package com.example.daggerhomework.presenter;

import com.example.daggerhomework.GitApplication;
import com.example.daggerhomework.contracts.RepoDetailsContract;
import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.model.repository.RepoRepository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

public class RepoDetailsPresenter implements RepoDetailsContract.Presenter, Subscriber<RepoDetailsModel> {

    @Inject
    RepoRepository repository;

    private RepoDetailsContract.View view;
    private String user;
    private String repo;

    public RepoDetailsPresenter(RepoDetailsContract.View view) {
        this.view = view;
        GitApplication.getComponentInstance().inject(this);
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(RepoDetailsModel repoDetailsModel) {
        view.showRepo(repoDetailsModel);
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
    public void loadData(String user, String repo) {
        this.user = user;
        this.repo = repo;
        repository.getRepoByNameAndUser(user, repo).subscribe(this);
    }

    @Override
    public void updateData() {
        repository.getRepoByNameAndUser(user, repo).subscribe(this);
    }
}
