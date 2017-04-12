package com.example.jose.dagger2.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by jose on 11/04/2017.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        ButterKnife.inject(this);
    }

    protected abstract int getLayoutId();
}
