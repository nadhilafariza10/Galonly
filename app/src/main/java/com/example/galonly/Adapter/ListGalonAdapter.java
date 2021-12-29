package com.example.galonly.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.recyclerview.widget.RecyclerView;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

;
import com.bumptech.glide.request.RequestOptions;
import com.example.galonly.Model.Galon;
import com.example.galonly.ListGalonActivity;
import com.example.galonly.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListGalonAdapter extends RecyclerView.Adapter<ListGalonAdapter.ViewHolder> {
    Context context;
    ArrayList<HashMap<String, String>> list_data;


    public ListGalonAdapter(ListGalonActivity mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ListGalonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_galon, null);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        /*Glide.with(context)
                .load("https://inescantik.herokuapp.com/foto/" + list_data.get(0).get("image"))
                .transition(withCrossFade())
                .into(holder.img);*/



      /*  Glide.with(context)
                .load("https://inescantik.herokuapp.com/foto/ "+ list_data.get(0).get("image"))
                //.apply(new RequestOptions().override(position, position).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
                .into(holder.img);*/
        String imageURL = "https://inescantik.herokuapp.com/foto/ ";
        Glide.with(context)
                .load(imageURL + list_data.get(0).get("image"))
                .apply(new RequestOptions().override(position, position).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background))
                .transition(withCrossFade())
                .into(holder.img);


        holder.txtnama.setText(list_data.get(position).get("nama_galon"));
        holder.txtalamat.setText(list_data.get(position).get("alamat_galon"));
    }



    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtnama, txtalamat;
        ImageView img;


        public ViewHolder(View itemView) {
            super(itemView);

            txtnama = (TextView) itemView.findViewById(R.id.tv_item_name);
            txtalamat = (TextView) itemView.findViewById(R.id.tv_detail);
            img = (ImageView) itemView.findViewById(R.id.imgGalon);

        }
    }


}

