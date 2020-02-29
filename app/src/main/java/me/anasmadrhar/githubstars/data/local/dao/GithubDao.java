package me.anasmadrhar.githubstars.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

/**
 * Github Data access object
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Dao
public interface GithubDao {

    @Query("SELECT * FROM repos order by stargazersCount desc limit (:page * :perPage)")
    LiveData<List<RepoEntity>> loadPopularRepos(int page, int perPage);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveRepos(List<RepoEntity> repoEntities);

}
