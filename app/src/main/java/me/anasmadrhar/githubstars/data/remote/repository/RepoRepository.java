package me.anasmadrhar.githubstars.data.remote.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import me.anasmadrhar.githubstars.data.local.dao.GithubDao;
import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;
import me.anasmadrhar.githubstars.data.remote.ApiService;
import me.anasmadrhar.githubstars.data.remote.NetworkBoundResource;
import me.anasmadrhar.githubstars.data.remote.Resource;
import me.anasmadrhar.githubstars.data.remote.model.PopularReposResponse;
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
    private final GithubDao githubDao;


    @Inject
    RepoRepository(ApiService service, GithubDao githubDao) {
        this.apiService = service;
        this.githubDao = githubDao;
    }

    /**
     * This method fetches the popular repos last 3 months from github service.
     * Once the fetching is done the data is cached to local db so that the app can work offline
     *
     * @return List of articles
     */
    public LiveData<Resource<List<RepoEntity>>> loadPopularRepos(int page) {
        return new NetworkBoundResource<List<RepoEntity>, PopularReposResponse>() {

            @Override
            protected void saveCallResult(PopularReposResponse item) {
                if (null != item) {
                    Log.d("saveCallResult", item.getPopularRepos().size() + "");
                    githubDao.saveRepos(item.getPopularRepos());
                }
            }

            @NonNull
            @Override
            protected LiveData<List<RepoEntity>> loadFromDb() {
                LiveData<List<RepoEntity>> data = githubDao.loadPopularRepos();
                if (data.getValue() != null)
                    Log.d("loadFromDb", data.getValue().size() + "");
                return data;
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

