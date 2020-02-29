package me.anasmadrhar.githubstars.di.module;

import android.app.Application;

import androidx.room.Room;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.anasmadrhar.githubstars.data.local.GithubDatabase;
import me.anasmadrhar.githubstars.data.local.dao.GithubDao;
import me.anasmadrhar.githubstars.data.remote.ApiConstants;
import me.anasmadrhar.githubstars.data.remote.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The application module which provides app wide instances of various components
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Module(includes = ViewModelModule.class)
public class AppModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    GithubDatabase provideGithubDatabase(Application application) {
        return Room.databaseBuilder(application, GithubDatabase.class, "github.db").build();
    }

    @Provides
    @Singleton
    GithubDao provideGithubDao(GithubDatabase githubDatabase) {
        return githubDatabase.githubDao();
    }

}
