package com.android.kyler.projectstructure.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.kyler.projectstructure.Adapters.UserAdapter;
import com.android.kyler.projectstructure.Models.Users;
import com.android.kyler.projectstructure.R;
import com.android.kyler.projectstructure.ViewModel.MainViewModel;

import java.util.Random;

public class MainActivity extends BaseActivity<MainViewModel> {

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
                Random random = new Random();
                int rdInt = random.nextInt(10000);
                Users user = new Users(String.valueOf(rdInt),String.valueOf(rdInt+"@gmail.com"), random.nextBoolean());
                mViewModel.addUser(user);
                adapter.addUser(user);
                rv.scrollToPosition(adapter.getItemCount());
            }
        });
    }
}
