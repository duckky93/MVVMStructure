package com.android.kyler.projectstructure.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kyler.projectstructure.Models.Users;
import com.android.kyler.projectstructure.R;
import com.android.kyler.projectstructure.databinding.AdapterUserBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kyler on 30/08/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Users> users;

    public UserAdapter(Context context) {
        this.context = context;
        this.users = new ArrayList<>();
    }

    public void setUsers(List<Users> users){
        this.users.clear();
        this.users.addAll(users);
    }

    public void addUser(Users user){
        this.users.add(user);
        notifyItemInserted(users.size()-1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.adapter_user,parent,false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterUserBinding binding = ((UserViewHolder) holder).binding;
        binding.setUvm(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        AdapterUserBinding binding;

        public UserViewHolder(AdapterUserBinding binding) {
            super(binding.user);
            this.binding = binding;
        }
    }

}
