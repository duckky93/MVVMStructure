package com.android.kyler.projectstructure.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.kyler.projectstructure.Adapters.UserAdapter;
import com.android.kyler.projectstructure.R;
import com.android.kyler.projectstructure.ViewModel.MainViewModel;

import java.util.Random;

public class MainViewModelActivity extends BaseViewModelActivity<MainViewModel> {

    @Override
    Class<? extends MainViewModel> getClassType() {
        return MainViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rv = findViewById(R.id.recycler_view);
        Button addUser = findViewById(R.id.add_user_btn);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final UserAdapter adapter = new UserAdapter(this);
        rv.setAdapter(adapter);
        adapter.setUsers(mViewModel.getUsers());
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.addUser();
                adapter.setUsers(mViewModel.getUsers());
                rv.scrollToPosition(adapter.getItemCount()-1);
            }
        });
    }
}
