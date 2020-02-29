package me.anasmadrhar.githubstars.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.anasmadrhar.githubstars.data.remote.Resource;
import me.anasmadrhar.githubstars.view.base.BaseAdapter;

/**
 * Binding adapters
 * Author: Anas Madrhar
 * Email: webmasterdisco4@gmail.com
 */
final class ListBindingAdapter {

    private ListBindingAdapter() {
        // Private Constructor to hide the implicit one
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        if (resource == null || resource.data == null)
            return;

        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).setData((List) resource.data);
        }
    }

}
