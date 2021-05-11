package com.example.myfavoritephotos.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavoritephotos.model.DataModel;
import com.example.myfavoritephotos.model.Image;
import com.example.myfavoritephotos.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>  {

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(
          R.layout.recyclerview_item,
          parent, false
        );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ImageAdapter.ViewHolder holder, int position) {
        Log.v("ImagesArrayAdapter", "onBindViewHolder"+position);
        Image image = DataModel.getInstance().images.get(position);
        holder.title.setText(image.getTitle());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.imageTitle);
        }
    }
}
