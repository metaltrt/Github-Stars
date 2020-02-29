package me.anasmadrhar.githubstars.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.anasmadrhar.githubstars.view.activity.MainActivity;

/**
 * The module which provides the android injection service to Activities.
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

}
