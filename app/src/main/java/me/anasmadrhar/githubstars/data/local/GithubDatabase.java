package me.anasmadrhar.githubstars.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.anasmadrhar.githubstars.data.local.dao.GithubDao;
import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */

@Database(entities = {RepoEntity.class}, version = 1)
public abstract class GithubDatabase extends RoomDatabase {
    public abstract GithubDao githubDao();
}
