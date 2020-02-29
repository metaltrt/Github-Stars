package me.anasmadrhar.githubstars.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import me.anasmadrhar.githubstars.viewmodel.RepoListViewModel;
import me.anasmadrhar.githubstars.viewmodel.ViewModelFactory;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsRepoListViewModel(RepoListViewModel repoListViewModel);
}
