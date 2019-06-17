package com.mitrais.carrotmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mitrais.carrotmobile.Configuration;
import com.mitrais.carrotmobile.R;
import com.mitrais.carrotmobile.model.Bazaar;
import com.mitrais.carrotmobile.model.BazaarItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BazaarItemAdapter extends RecyclerView.Adapter<BazaarItemAdapter.BazaarItemViewHolder> {
    private List<BazaarItem> bazaarItems;
    private Context context;

    public BazaarItemAdapter(List<BazaarItem> bazaars, Context context) {
        this.bazaarItems = bazaars;
        this.context = context;
    }

    @NonNull
    @Override
    public BazaarItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BazaarItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bazaar_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BazaarItemViewHolder holder, int position) {
        if(bazaarItems.get(position).getPicture()!=null)
            Glide.with(context).load(Configuration.BASE_URL+bazaarItems.get(position).getPicture()).into(holder.bazaarImage);
        holder.bazaarItemName.setText(bazaarItems.get(position).getName());
        holder.bazaarPrice.setText(String.valueOf(bazaarItems.get(position).getExchangeRate()));
    }

    @Override
    public int getItemCount() {
        return bazaarItems.size();
    }

    class BazaarItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.bazaar_image) ImageView bazaarImage;
        @BindView(R.id.bazaar_item_name) TextView bazaarItemName;
        @BindView(R.id.bazaar_price) TextView bazaarPrice;
        public BazaarItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
