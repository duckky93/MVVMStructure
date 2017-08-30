package com.android.kyler.projectstructure.Fragments.Dialog;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;

/**
 * Created by kyler on 30/08/2017.
 */

public class BaseDialogFragment<T> extends DialogFragment {

    public interface DialogListener<T> {
        void onDialogClosed(T result);
    }

    protected String mTitle;
    protected String mMessage;

    protected DialogListener<T> mListener;
    protected T mValueListener;

    public BaseDialogFragment(){

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mListener != null) {
            mListener.onDialogClosed(mValueListener);
        }
    }
}
