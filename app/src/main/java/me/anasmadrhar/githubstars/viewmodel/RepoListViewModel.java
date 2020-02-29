package me.anasmadrhar.githubstars.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;
import me.anasmadrhar.githubstars.data.remote.Resource;
import me.anasmadrhar.githubstars.data.remote.repository.RepoRepository;

/**
 * Repo List view model
 * Author: Anas Madrhar
 * Email: webmasterdisco4@gmail.com
 */
public class RepoListViewModel extends ViewModel {

    private final RepoRepository repoRepository;

    @Inject
    public RepoListViewModel(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public LiveData<Resource<List<RepoEntity>>> getPopularRepos(int page) {
        return repoRepository.loadPopularRepos(page);
    }
}
