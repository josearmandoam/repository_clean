package com.example.jose.dagger2.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.global.App;
import com.example.jose.dagger2.global.di.DaggerUserListComponent;
import com.example.jose.dagger2.global.di.UserListComponent;
import com.example.jose.dagger2.global.di.UserListModule;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.ui.presenter.UserDetailPresenter;
import com.example.jose.dagger2.ui.presenter.abs.AbsUserDetailPresenter;
import com.example.jose.dagger2.usecase.ShowErrorLoading;
import com.example.jose.dagger2.usecase.ShowUserGreetings;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

public class UserDetailActivity extends BaseActivity implements AbsUserDetailPresenter.View, AbsUserDetailPresenter.Navigator {

    @InjectView(R.id.user_detail_address)
    TextView address;
    @InjectView(R.id.user_detail_email)
    TextView email;
    @InjectView(R.id.user_detail_userId)
    TextView id;
    @InjectView(R.id.user_detail_name)
    TextView name;
    @InjectView(R.id.user_detail_pbr)
    ProgressBar pbr;
    @InjectView(R.id.user_detail_image)
    ImageView userImage;

    User user;

    @Inject
    ShowUserGreetings showUserGreetings;
    @Inject
    ShowErrorLoading showErrorLoading;

    UserDetailPresenter presenter;

    UserListComponent component;

    @OnClick(R.id.user_detail_image)
    public void onImageClicked(View view) {
        presenter.onImageClicked(user);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);


        getUser();

        presenter = new UserDetailPresenter(this, user);
        presenter.setView(this);
        presenter.setNavigator(this);
        presenter.initialize();
    }

    private UserListComponent component() {
        if (component == null) {
            component = DaggerUserListComponent.builder()
                    .rootComponent(((App) getApplication()).getComponent())
                    .userListModule(new UserListModule(getApplicationContext()))
                    .mainModule(((App) getApplication()).getMainModule())
                    .build();
        }
        return component;
    }

    private void getUser() {
        user = (User) getIntent().getExtras().get("userId");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_detail;
    }

    @Override
    public void navigate() {
        /**/
    }

    @Override
    public void showUserGreetings(User user) {
        showUserGreetings.show(user);
    }

    @Override
    public void showLoading() {
        pbr.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbr.setVisibility(View.GONE);
    }

    @Override
    public void showErrorLoading() {
        showErrorLoading.show();
    }

    @Override
    public void showUserName(String name) {
        this.name.setText(name);
    }

    @Override
    public void showUserEmail(String email) {
        this.email.setText(email);
    }

    @Override
    public void showUserID(String id) {
        this.id.setText(id);
    }

    @Override
    public void showUserAddress(String address) {
        this.address.setText(address);
    }

    @Override
    public void loadImage(String thumbnail) {
        Picasso.with(this)
                .load(thumbnail)
                .into(userImage);
    }
}
