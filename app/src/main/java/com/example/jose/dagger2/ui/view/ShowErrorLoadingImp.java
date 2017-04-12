package com.example.jose.dagger2.ui.view;

import android.content.Context;
import android.widget.Toast;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.usecase.ShowErrorLoading;

/**
 * Created by jose on 12/04/2017.
 */

public class ShowErrorLoadingImp implements ShowErrorLoading {
    Context context;

    public ShowErrorLoadingImp(Context context) {
        this.context = context;
    }

    @Override
    public void show() {
        Toast.makeText(context, context.getString(R.string.error_loading_user), Toast.LENGTH_SHORT).show();
    }
}
