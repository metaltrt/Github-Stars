package me.anasmadrhar.githubstars.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.anasmadrhar.githubstars.view.Fragment.RepoListFragment;

/**
 * This builder provides android injector service to fragments
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract RepoListFragment contributeRepoListFragment();

}
