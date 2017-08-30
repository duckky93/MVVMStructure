package com.android.kyler.projectstructure.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.android.kyler.projectstructure.Models.Users;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kyler on 30/08/2017.
 */

public class MainViewModel extends AndroidViewModel {

    LinkedList<Users> users;

    public MainViewModel(Application application) {
        super(application);
        users = new LinkedList<>();
        users.add(new Users("abc","abc@gmail.com", false));
        users.add(new Users("abc2","abc2@gmail.com", true));
        users.add(new Users("abc3","abc3@gmail.com", false));
        users.add(new Users("abc4","abc4@gmail.com", true));
        users.add(new Users("abc5","abc5@gmail.com", false));
        users.add(new Users("abc6","abc6@gmail.com", false));
    }

    public List<Users> getUsers(){
        return users;
    }

    public void addUser(String username, String email){
        users.add(new Users(username, email));
    }

    public void addUser(){
        int size = users.size();
        Users user = new Users(String.valueOf(size),String.valueOf(size+"@gmail.com"));
        users.add(user);
    }


}
