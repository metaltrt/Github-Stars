package me.anasmadrhar.githubstars;

import android.app.Application;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class GithubStarsApp extends Application {

    private static GithubStarsApp sInstance;


    public static GithubStarsApp getAppContext() {
        return sInstance;
    }


    private static synchronized void setInstance(GithubStarsApp app) {
        sInstance = app;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
    }
}
