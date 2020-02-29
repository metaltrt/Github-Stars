package me.anasmadrhar.githubstars.view.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import me.anasmadrhar.githubstars.R;
import me.anasmadrhar.githubstars.data.remote.Status;
import me.anasmadrhar.githubstars.databinding.FragmentListReposBinding;
import me.anasmadrhar.githubstars.view.adapter.RepoListAdapter;
import me.anasmadrhar.githubstars.view.base.BaseFragment;
import me.anasmadrhar.githubstars.viewmodel.RepoListViewModel;

/**
 * Repo list fragment which will list the popular repos
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class RepoListFragment extends BaseFragment<RepoListViewModel, FragmentListReposBinding> {
    private boolean isLoading = false;
    private int page = 1;

    public static RepoListFragment newInstance() {
        Bundle args = new Bundle();
        RepoListFragment fragment = new RepoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Class<RepoListViewModel> getViewModel() {
        return RepoListViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_list_repos;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBinding.recyclerView.setAdapter(new RepoListAdapter());
        initScrollListener();
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadRepos(page++);

    }

    private void initScrollListener() {
        dataBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && dataBinding.recyclerView.getAdapter() != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == dataBinding.recyclerView.getAdapter().getItemCount() - 1) {
                        dataBinding.bottomProgress.setVisibility(View.VISIBLE);
                        loadRepos(page++);
                        isLoading = true;
                    }
                }
            }
        });
    }

    private void loadRepos(int page) {
        viewModel.getPopularRepos(page)
                .observe(getViewLifecycleOwner(), listResource -> {
                    if (null != listResource && (listResource.status == Status.ERROR || listResource.status == Status.SUCCESS)) {
                        dataBinding.loadingProgress.setVisibility(View.GONE);
                        dataBinding.bottomProgress.setVisibility(View.GONE);
                        this.isLoading = false;
                    }

                    if (null != listResource && (listResource.status == Status.LOADING)) {
                        this.isLoading = true;
                    }

                    dataBinding.setResource(listResource);

                    // If the cached data is already showing then no need to show the error
                    if (null != dataBinding.recyclerView.getAdapter() && dataBinding.recyclerView.getAdapter().getItemCount() > 0) {
                        dataBinding.errorText.setVisibility(View.GONE);
                    }
                });
    }
}
