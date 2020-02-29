package me.anasmadrhar.githubstars.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    private String login;


    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }
}
