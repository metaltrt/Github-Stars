package me.anasmadrhar.githubstars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class EntityUnitTest {

    @Test
    public void testId() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setId(1000);
        assertEquals(RepoEntity.getId(), 1000);
    }

    @Test
    public void testTitle() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setName("test");
        assertEquals(RepoEntity.getName(), "test");
    }

    @Test
    public void testContent() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setDescription("test");
        assertEquals(RepoEntity.getDescription(), "test");
    }

    @Test
    public void testStars() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setStargazersCount(100);
        assertEquals(RepoEntity.getStargazersCount(), 100);
    }

    @Test
    public void testStarsFromatted() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setStargazersCount(1225);
        assertEquals(RepoEntity.getStargazersCountFormatted(), "1.2k");
    }


    @Test
    public void testOwner() {
        RepoEntity RepoEntity = new RepoEntity();
        RepoEntity.setOwner("test");
        assertEquals(RepoEntity.getOwner(), "test");
    }
}
