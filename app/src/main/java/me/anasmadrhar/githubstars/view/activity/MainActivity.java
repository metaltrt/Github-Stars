package me.anasmadrhar.githubstars.view.activity;

import android.os.Bundle;

import me.anasmadrhar.githubstars.R;
import me.anasmadrhar.githubstars.databinding.ActivityMainBinding;
import me.anasmadrhar.githubstars.utils.FragmentUtils;
import me.anasmadrhar.githubstars.view.Fragment.RepoListFragment;
import me.anasmadrhar.githubstars.view.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentUtils.replaceFragment(this, RepoListFragment.newInstance(), R.id.fragContainer, false, FragmentUtils.TRANSITION_NONE);

    }
}