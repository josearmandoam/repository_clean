package com.example.jose.dagger2.ui.adaptor;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose.dagger2.R;
import com.example.jose.dagger2.global.model.User;
import com.example.jose.dagger2.usecase.ShowUserGreetings;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jose on 08/04/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {

    Activity activity;
    List<User> list_users;

    public RecyclerAdapter(Activity activity, List<User> list_users) {
        this.activity = activity;
        this.list_users = list_users;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView username;
        TextView email;
        ImageView userImage;

        UserViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.user_list_cardview);
            username = (TextView) itemView.findViewById(R.id.user_list_username);
            email = (TextView) itemView.findViewById(R.id.user_list_email);
            userImage = (ImageView) itemView.findViewById(R.id.user_list_thumbnail);

        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.email.setText(list_users.get(position).getUsername());
        holder.email.setText(list_users.get(position).getEmail());
        Picasso.with(activity.getApplicationContext())
                .load(list_users.get(position).getThumbnail())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return list_users.size();
    }

}
