package com.android.kyler.projectstructure.Models;

import android.databinding.BaseObservable;

/**
 * Created by kyler on 30/08/2017.
 */

public class Users extends BaseObservable{
    String userName;
    String userEmail;
    boolean isActived;
    int seekbarValue;

    public Users(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.isActived = false;
        this.seekbarValue = 0;
    }

    public Users(String userName, String userEmail, boolean isActived) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.isActived = isActived;
        this.seekbarValue = 0;
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

    public int getSeekbarValue() {
        return seekbarValue;
    }

    public void setSeekbarValue(int seekbarValue) {
        this.seekbarValue = seekbarValue;
    }
}
