package com.mitrais.carrotmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mitrais.carrotmobile.R;
import com.mitrais.carrotmobile.model.Bazaar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BazaarAdapter extends RecyclerView.Adapter<BazaarAdapter.BazaarViewHolder> {
    private List<Bazaar> bazaars;
    private Context context;

    public BazaarAdapter(List<Bazaar> bazaars,Context context) {
        this.bazaars = bazaars;
        this.context = context;
    }

    @NonNull
    @Override
    public BazaarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        return new BazaarViewHolder(inflater.inflate(R.layout.card_bazaar,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BazaarViewHolder holder, int position) {
        holder.bazaarItemName.setText(bazaars.get(position).getName());
        holder.bazaarItemList.setLayoutManager(new GridLayoutManager(context,2));
        holder.bazaarItemList.setAdapter(new BazaarItemAdapter(bazaars.get(position).getItems(),context));
    }

    @Override
    public int getItemCount() {
        return bazaars.size();
    }

    class BazaarViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.bazaar_item_list) RecyclerView  bazaarItemList;
        @BindView(R.id.bazaar_name) TextView bazaarItemName;

        public BazaarViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
