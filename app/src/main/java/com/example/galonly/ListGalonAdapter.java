package com.example.galonly;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.galonly.Galon;

import java.util.ArrayList;

public class ListGalonAdapter extends RecyclerView.Adapter<ListGalonAdapter.ListViewHolder> {
    private ArrayList<Galon> clubs;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    public ListGalonAdapter(ArrayList<Galon> list){ this.clubs = list; }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_galon, parent, false);
        return new ListViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Galon  galon = clubs.get(position);
        Glide.with(holder.itemView.getContext())
                .load(galon.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(galon.getName());
        holder.tvDetail.setText(galon.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(clubs.get(holder.getAdapterPosition()));
            }
        });

    }

    private void into(ImageView imgPhoto) {
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDetail;


        ListViewHolder(View itemview){
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_club);
            tvName = itemview.findViewById(R.id.tv_item_name);
            tvDetail = itemview.findViewById(R.id.tv_detail);
        }

    }
    public interface OnItemClickCallback{
        void onItemClicked(Galon data);
    }
}

