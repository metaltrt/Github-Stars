package me.anasmadrhar.githubstars.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("description")
    private String description;

    @SerializedName("stargazers_count")
    private int stargazers;

    public int getStargazers() {
        return stargazers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

}
