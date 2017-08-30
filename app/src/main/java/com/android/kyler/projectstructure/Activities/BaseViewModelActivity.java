package com.android.kyler.projectstructure.Activities;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

/**
 * Created by kyler on 30/08/2017.
 */

public abstract class BaseViewModelActivity<T extends ViewModel> extends BaseActivity implements LifecycleRegistryOwner {

    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }

    abstract Class<? extends T> getClassType();

    T mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getClassType() == null){
            StringBuilder exStringBuilder = new StringBuilder();
            exStringBuilder.append(getClass())
                    .append(" doesn't initialize the getClassType()");
            throw new UnsupportedOperationException(exStringBuilder.toString());
        }
        mViewModel = ViewModelProviders.of(this).get(getClassType());
    }
}
