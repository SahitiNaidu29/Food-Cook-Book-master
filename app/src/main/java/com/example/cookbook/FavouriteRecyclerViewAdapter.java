package com.example.cookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewHolder> {
    private List<DbItem> meals=new ArrayList<>();
    private Context context=null;

    public FavouriteRecyclerViewAdapter(Context mContext, List<DbItem> list){
        meals=list;
        context=mContext;
    }

    @NonNull
    @Override
    public ItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_view,parent,false);
        return new ItemRecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewHolder holder, int position) {
        String url =meals.get(position).getStrMealThumb();
        Glide.with(context)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.dinner)
                .into(holder.imageView);
        holder.name_tv.setText(meals.get(position).getStrMeal());
        holder.favImage.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("meal_id", meals.get(position).getIdMeal());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}