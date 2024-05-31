package com.example.androiddatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddatabase.R;
import com.example.androiddatabase.model.User;
import com.example.androiddatabase.view.sqlite.UpdateUserActivity;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    ArrayList<User> mUsersList;
    Context mContext;

    public UsersAdapter(ArrayList<User> mUsersList, Context mContext) {
        this.mUsersList = mUsersList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.mTextViewUSerID.setText(String.valueOf(mUsersList.get(position).getId()));
        holder.mTextViewFirstName.setText(mUsersList.get(position).getmFirstName());
        holder.mTextViewLastName.setText(mUsersList.get(position).getmLastName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpdateUserActivity.class);
                intent.putExtra("firstname",mUsersList.get(position).getmFirstName());
                intent.putExtra("lastname",mUsersList.get(position).getmLastName());
                intent.putExtra("id",String.valueOf(mUsersList.get(position).getId()));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewUSerID,mTextViewFirstName, mTextViewLastName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewUSerID = itemView.findViewById(R.id.text_user_id);
            mTextViewFirstName = itemView.findViewById(R.id.text_first_name);
            mTextViewLastName = itemView.findViewById(R.id.text_last_name);
        }
    }
}
