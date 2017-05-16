package com.uysys.practicejsonwithvolley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by zubayer on 5/16/2017.
 */

public class RecyclerUsersAdapter extends RecyclerView.Adapter<RecyclerUsersAdapter.ViewHolder> {

    private ArrayList<UserModel> userModels;
    private Context context;

    public RecyclerUsersAdapter(ArrayList<UserModel> userModels, Context context) {
        this.userModels = userModels;
        this.context = context;
    }

    @Override
    public RecyclerUsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_users_row,parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerUsersAdapter.ViewHolder holder, int position) {

        UserModel userModel = userModels.get(position);

        holder.txtUserID.setText(String.valueOf(userModel.getUserId()));
        holder.txtId.setText(String.valueOf(userModel.getId()));
        holder.txtTitle.setText(userModel.getTitle());
        holder.txtBody.setText(userModel.getBody());
        Glide.with(this.context)
                .load("http://images4.fanpop.com/image/photos/16900000/Megamind-megamind-16949112-1200-1576.jpg")
                .into(holder.imageTest);
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtUserID,txtId,txtTitle,txtBody;
        ImageView imageTest;
        public ViewHolder(View itemView) {
            super(itemView);

            txtUserID = (TextView) itemView.findViewById(R.id.txtUserId);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtBody = (TextView) itemView.findViewById(R.id.txtBody);
            imageTest = (ImageView) itemView.findViewById(R.id.imageTest);
        }
    }
}
