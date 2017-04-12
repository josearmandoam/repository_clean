package com.example.jose.dagger2.ui.adaptor;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.global.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by jose on 08/04/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {

    Activity activity;
    List<User> list_users;
    OnUserClicked onUserClicked = new EmptyOnUserClicked();


    public RecyclerAdapter(Activity activity, List<User> list_users, OnUserClicked onUserClicked) {
        this.activity = activity;
        this.list_users = list_users;
        setListener(onUserClicked);
    }

    private void setListener(OnUserClicked onUserClicked) {
        if (onUserClicked != null) {
            this.onUserClicked = onUserClicked;
        }
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.user_list_thumbnail)
        ImageView userImage;
        @InjectView(R.id.user_list_username)
        TextView userName;
        @InjectView(R.id.user_list_email)
        TextView userEmail;

        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        @OnClick(R.id.user_list_thumbnail)
        public void onUserClicked(View view) {
            onUserClicked.onPictureClicked(list_users.get(getAdapterPosition()));
        }

        @OnClick(R.id.user_list_container)
        public void onBackgroundClicked(View view) {
            onUserClicked.onBackgroundClicked(list_users.get(getAdapterPosition()));
        }

    }

    @Override
    public RecyclerAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.userName.setText(list_users.get(position).getName());
        holder.userEmail.setText(list_users.get(position).getEmail());
        Picasso.with(activity.getApplicationContext())
                .load(list_users.get(position).getThumbnail())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return list_users.size();
    }

    public interface OnUserClicked {
        void onPictureClicked(User user);

        void onBackgroundClicked(User user);
    }

    private class EmptyOnUserClicked implements OnUserClicked {
        @Override
        public void onPictureClicked(User user) {

        }

        @Override
        public void onBackgroundClicked(User user) {

        }
    }
}
