package me.anasmadrhar.githubstars;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import me.anasmadrhar.githubstars.data.local.GithubDatabase;
import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class GithubDaosTest {
    private GithubDatabase githubDatabase;

    @Before
    public void init() {
        githubDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), GithubDatabase.class).build();
    }

    @After
    public void uninit() {
        githubDatabase.close();
    }

    @Test
    public void testLoadPopularArticles() {
        List<RepoEntity> repo = new ArrayList<>();
        RepoEntity entity = new RepoEntity();
        entity.setId(1000);
        entity.setName("test");
        entity.setDescription("test");
        entity.setOwner("test");
        entity.setOwnerAvatar("test");
        entity.setStargazersCount(23132);
        repo.add(entity);
        githubDatabase.githubDao().saveRepos(repo);
        LiveData<List<RepoEntity>> repos = githubDatabase.githubDao().loadPopularRepos(1, 10);
        assertNotNull(repos);
    }

}
