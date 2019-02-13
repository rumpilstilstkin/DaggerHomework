package com.example.daggerhomework.view.repo.list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daggerhomework.R;
import com.example.daggerhomework.contracts.RepoListContract;
import com.example.daggerhomework.model.data.RepoModel;
import com.example.daggerhomework.presenter.RepoListPresenter;
import com.example.daggerhomework.view.repo.details.RepoDetailsFragment;
import com.example.daggerhomework.view.user.UserDetailsFragment;

import java.util.List;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListFragment extends Fragment
        implements RepoListContract.View, RepoListAdapter.Listener {

    private RepoListContract.Presenter presenter;

    @BindView(R.id.feed_list)
    RecyclerView feedList;

    private RepoListAdapter adapter = new RepoListAdapter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.repo_list, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feedList.setAdapter(adapter);
        initPresenter();
    }

    private void initPresenter() {
        presenter = new RepoListPresenter(this);
        presenter.loadData();
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
    public void showRepos(List<RepoModel> list) {
        adapter.setItems(list);
    }

    @Override
    public void onRepoClick(String user, String repo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.select_details)
                .setItems(R.array.details_type, (dialog, which) -> {
                    Activity activity = getActivity();
                    if(activity == null){
                        return;
                    }

                    switch (which) {
                        case 0: {
                            Navigation.findNavController(activity, R.id.my_nav_host_fragment)
                                    .navigate(
                                            R.id.action_repoListFragment_to_userDetailsFragment,
                                            UserDetailsFragment.getArguments(user)
                                    );
                            break;
                        }
                        case 1: {
                            Navigation.findNavController(activity, R.id.my_nav_host_fragment)
                                    .navigate(
                                            R.id.action_repoListFragment_to_repoDetailsFragment,
                                            RepoDetailsFragment.getArgs(user, repo)
                                    );
                            break;
                        }
                    }
                });
        builder.create().show();
    }
}
