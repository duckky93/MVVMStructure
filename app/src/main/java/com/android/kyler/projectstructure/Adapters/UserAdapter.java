package com.android.kyler.projectstructure.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.android.kyler.projectstructure.Interfaces.UserViewModelInterface;
import com.android.kyler.projectstructure.Models.Users;
import com.android.kyler.projectstructure.R;
import com.android.kyler.projectstructure.databinding.AdapterUserBinding;

import java.util.ArrayList;
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
        notifyItemInserted(users.size()-1);
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Users user = users.get(position);
        AdapterUserBinding binding = ((UserViewHolder) holder).binding;
        binding.setUvm(users.get(position));
        binding.setUvmlistener(new UserViewModelInterface() {
            @Override
            public void onUserClick() {
                user.setUserEmail("Test@gmail.com");
                notifyItemChanged(position);
            }

            @Override
            public void onCheckboxClick(boolean isChecked) {
                user.setActived(isChecked);
            }

            @Override
            public void onSeekBarChange(View v) {
                user.setSeekbarValue(((SeekBar)v).getProgress());
            }
        });
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
