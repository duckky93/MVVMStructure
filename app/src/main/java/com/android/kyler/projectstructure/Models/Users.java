package com.android.kyler.projectstructure.Models;

import android.databinding.BaseObservable;

/**
 * Created by kyler on 30/08/2017.
 */

public class Users extends BaseObservable{
    String userName;
    String userEmail;
    boolean isActived;

    public Users(String userName, String userEmail, boolean isActived) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.isActived = isActived;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isActived() {
        return isActived;
    }

    public void setActived(boolean actived) {
        isActived = actived;
    }
}
