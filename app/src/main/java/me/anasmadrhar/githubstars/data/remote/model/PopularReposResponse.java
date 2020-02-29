package me.anasmadrhar.githubstars.data.remote.model;

import android.os.Build;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

/**
 * The model class which holds the top popular repos data
 * Author: Anas Madrhar
 * Email: webmasterdisco4@gmail.com
 */
public class PopularReposResponse {


    @SerializedName("items")
    private List<Repo> popularRepos;

    @SerializedName("total_count")
    private int count;

    /**
     * This method return the list of repo entities
     *
     * @return List of entities
     */
    public List<RepoEntity> getPopularRepos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return popularRepos
                    .stream()
                    .map(Repo::toEntity)
                    .collect(Collectors.toList());
        } else {
            List<RepoEntity> repoEntities = new ArrayList<>();
            for (Repo repo : popularRepos) {
                repoEntities.add(repo.toEntity());
            }
            return repoEntities;
        }
    }

    /**
     * This method sets the repo entities
     *
     * @param repos - repo list
     */
    public void setPopularArticles(List<Repo> repos) {
        this.popularRepos = repos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
