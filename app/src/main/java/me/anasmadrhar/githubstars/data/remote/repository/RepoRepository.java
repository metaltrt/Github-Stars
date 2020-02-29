package me.anasmadrhar.githubstars.data.remote.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import me.anasmadrhar.githubstars.data.remote.ApiService;
import me.anasmadrhar.githubstars.data.remote.NetworkBoundResource;
import me.anasmadrhar.githubstars.data.remote.Resource;
import me.anasmadrhar.githubstars.data.remote.model.PopularReposResponse;
import me.anasmadrhar.githubstars.data.remote.model.Repo;
import me.anasmadrhar.githubstars.utils.DateUtils;
import retrofit2.Call;

/**
 * The article repository which has access to local and remote data fetching services
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class RepoRepository {

    private final ApiService apiService;

    @Inject
    RepoRepository(ApiService service) {
        this.apiService = service;
    }

    /**
     * This method fetches the popular repos last 3 months from github service.
     * Once the fetching is done the data is cached to local db so that the app can work offline
     *
     * @return List of articles
     */
    public LiveData<Resource<List<Repo>>> loadPopularRepos(int page) {
        return new NetworkBoundResource<List<Repo>, PopularReposResponse>() {

            @Override
            protected void saveCallResult(PopularReposResponse item) {
                //TODO: SAVE TO DATABASE
            }

            @NonNull
            @Override
            protected LiveData<List<Repo>> loadFromDb() {
                //TODO: LOAD FROM DATABASE
                return null;
            }

            @NonNull
            @Override
            protected Call<PopularReposResponse> createCall() {
                String query = "created:>" + DateUtils.getDateThreeMonthsAgo();
                return apiService.loadPopularRepos(query, page);
            }
        }.getAsLiveData();
    }

}

