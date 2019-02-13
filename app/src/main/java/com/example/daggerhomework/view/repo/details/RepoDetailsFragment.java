package com.example.daggerhomework.view.repo.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.RepoDetailsContract;
import com.example.daggerhomework.model.data.RepoDetailsModel;
import com.example.daggerhomework.presenter.RepoDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoDetailsFragment extends Fragment implements RepoDetailsContract.View {
    private static final String ARG_USER = "param1";
    private static final String ARG_REPO = "param2";

    @BindView(R.id.repo_name)
    TextView name;

    @BindView(R.id.repo_description)
    TextView description;

    @BindView(R.id.repo_issue)
    TextView issue;

    private RepoDetailsContract.Presenter presenter;

    private String user;
    private String repo;

    public static Bundle getArgs(String user, String repo) {
        Bundle args = new Bundle();
        args.putString(ARG_USER, user);
        args.putString(ARG_REPO, repo);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getString(ARG_USER);
            repo = getArguments().getString(ARG_REPO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repo_details, container, false);
        ButterKnife.bind(this, view);
        return view;
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
    public void showRepo(RepoDetailsModel model) {
        name.setText(model.name);
        description.setText(model.description);
        issue.setText(getString(R.string.issue_count, model.issuesCount));
    }

    private void initPresenter(){
        presenter = new RepoDetailsPresenter(this);
        presenter.setUser(user);
        presenter.setRepo(repo);
        presenter.loadData();
    }
}
