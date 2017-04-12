package com.example.jose.dagger2.ui.view;

import android.content.Context;
import android.widget.Toast;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.usecase.ShowNoInternetAvailable;

/**
 * Created by jose on 12/04/2017.
 */

public class ShowNoInternetAvailableImp implements ShowNoInternetAvailable {
    Context context;

    public ShowNoInternetAvailableImp(Context context) {
        this.context = context;
    }

    @Override
    public void show() {
        Toast.makeText(context, context.getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
    }
}
