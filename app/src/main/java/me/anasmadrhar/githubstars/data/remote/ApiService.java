package me.anasmadrhar.githubstars.data.remote;

import me.anasmadrhar.githubstars.data.remote.model.PopularReposResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public interface ApiService {
    @GET("search/repositories?sort=stars&order=desc")
    Call<PopularReposResponse> loadPopularRepos(@Query("q") String query, @Query("page") int page, @Query("per_page") int perPage);
}
