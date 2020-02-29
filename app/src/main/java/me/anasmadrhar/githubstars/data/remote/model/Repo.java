package me.anasmadrhar.githubstars.data.remote.model;

import com.google.gson.annotations.SerializedName;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

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

    public RepoEntity toEntity() {
        RepoEntity entity = new RepoEntity();
        entity.setId(getId());
        entity.setOwner(this.getOwner().getLogin());
        entity.setStargazersCount(this.getStargazers());
        entity.setOwnerAvatar(this.getOwner().getAvatarUrl());
        entity.setDescription(this.getDescription());
        entity.setName(this.getName());
        return entity;
    }

}
