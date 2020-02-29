package me.anasmadrhar.githubstars.view.base;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Generic Base adapter for recycler views
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public abstract class BaseAdapter<T extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<T> {

    public abstract void setData(List<D> data);

}
