package com.example.jose.dagger2.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.global.App;
import com.example.jose.dagger2.global.di.DaggerUserListComponent;
import com.example.jose.dagger2.global.di.UserListComponent;
import com.example.jose.dagger2.global.di.UserListModule;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.interactor.GetUsersInteractor;
import com.example.jose.dagger2.ui.adaptor.RecyclerAdapter;
import com.example.jose.dagger2.ui.presenter.UserListPresenter;
import com.example.jose.dagger2.ui.presenter.abs.AbsUserListPresenter;
import com.example.jose.dagger2.usecase.ShowUserGreetings;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class UserListActivity extends AppCompatActivity implements AbsUserListPresenter.View, AbsUserListPresenter.Navigator {

    @InjectView(R.id.user_detail_users_list)
    RecyclerView recyclerView;

    UserListComponent component;
    RecyclerAdapter recyclerAdapter;
    List<User> list = new ArrayList<User>();

    AbsUserListPresenter presenter;

    @InjectView(R.id.user_detail_progressbar)
    ProgressBar pbr;

    @Inject
    ShowUserGreetings showUserGreetings;

    @Inject
    GetUsersInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);
        ButterKnife.inject(this);

        presenter = new UserListPresenter(this, interactor);
        presenter.setView(this);
        presenter.setNavigator(this);
        presenter.initialize();

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, list);
    }

    private int getLayoutId() {
        return R.layout.activity_main;
    }

    public UserListComponent component() {
        if (component == null) {
            component = DaggerUserListComponent.builder()
                    .rootComponent(((App) getApplication()).getComponent())
                    .userListModule(new UserListModule(getApplicationContext()))
                    .mainModule(((App) getApplication()).getMainModule())
                    .build();
        }
        return component;
    }

    @Override
    public void showUserList(List<User> users) {
        for (User u : users) {
            list.add(u);
        }
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showUserListError(Exception e) {
        Toast.makeText(this, R.string.list_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoInternetAvailable() {
        Toast.makeText(this, R.string.no_internet, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGreetingsUser(User user) {
        showUserGreetings.show(user);
    }

    @Override
    public void showLooading() {
        pbr.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbr.setVisibility(View.GONE);
    }

    @Override
    public void navigateUserDetail(User user) {
        open(this, user);
    }

    public static void open(Context ctx, User user) {
//        Intent intent = new Intent(ctx, aa.class);
//        intent.putExtra("user", (Parcelable) user);
//        ctx.startActivity(intent);
    }
}
