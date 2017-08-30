package com.android.kyler.projectstructure.Interfaces;

import android.view.View;

/**
 * Created by kyler on 30/08/2017.
 */

public interface UserViewModelInterface {
    void onUserClick();
    void onCheckboxClick(boolean isChecked);
    void onSeekBarChange(View v);
}
