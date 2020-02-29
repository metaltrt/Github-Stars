package me.anasmadrhar.githubstars.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.anasmadrhar.githubstars.data.local.entity.RepoEntity;
import me.anasmadrhar.githubstars.databinding.ItemRepoListBinding;
import me.anasmadrhar.githubstars.view.base.BaseAdapter;

/**
 * Author: Anas Madrhar
 * Date: 29/02/20
 * Email: webmasterdisco4@gmail.com
 */
public class RepoListAdapter extends BaseAdapter<RepoListAdapter.RepoViewHolder, RepoEntity> {

    private List<RepoEntity> repoEntities;


    public RepoListAdapter() {
        repoEntities = new ArrayList<>();
    }


    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return RepoViewHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder viewHolder, int i) {
        viewHolder.onBind(repoEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return repoEntities.size();
    }

    @Override
    public void setData(List<RepoEntity> data) {
        repoEntities = data;
        notifyDataSetChanged();
    }


    static class RepoViewHolder extends RecyclerView.ViewHolder {

        final ItemRepoListBinding binding;

        private RepoViewHolder(ItemRepoListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private static RepoViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemRepoListBinding itemRepoListBinding = ItemRepoListBinding.inflate(inflater, parent, false);
            return new RepoViewHolder(itemRepoListBinding);
        }

        private void onBind(RepoEntity repoEntity) {
            binding.setRepo(repoEntity);
            binding.executePendingBindings();
        }
    }
}
