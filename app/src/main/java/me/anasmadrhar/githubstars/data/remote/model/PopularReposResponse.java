package me.anasmadrhar.githubstars.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    public List<Repo> getPopularRepos() {
        return popularRepos;
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
