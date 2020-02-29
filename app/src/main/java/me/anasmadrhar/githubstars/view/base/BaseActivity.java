package me.anasmadrhar.githubstars.view.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Generic Activity with databinding
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public abstract class BaseActivity<D extends ViewDataBinding> extends AppCompatActivity {

    public D dataBinding;

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    }

}
