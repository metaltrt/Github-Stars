package me.anasmadrhar.githubstars.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import me.anasmadrhar.githubstars.GithubStarsApp;
import me.anasmadrhar.githubstars.di.builder.ActivityBuilderModule;
import me.anasmadrhar.githubstars.di.module.AppModule;

/**
 * The main application component which initializes all the dependent modules
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    void inject(GithubStarsApp githubStarsApp);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}