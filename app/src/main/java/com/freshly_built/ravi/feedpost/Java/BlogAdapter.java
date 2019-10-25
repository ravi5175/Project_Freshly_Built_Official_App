package com.freshly_built.ravi.feedpost.Java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshly_built.ravi.feedpost.R;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter
{

    private ArrayList<blogViewModel> dataset;
    private Context mcontext;

    public BlogAdapter( ArrayList<blogViewModel> mlist,Context context)
    {
        this.dataset= mlist;
        this.mcontext=context;
    }
    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,subtitle;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView)
        {
            super(itemView);
            this.title= itemView.findViewById(R.id.Title);
            this.subtitle=itemView.findViewById(R.id.subtitle);
            this.imageView=itemView.findViewById(R.id.icon);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postcard,parent,false);
        return new ImageTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {   final blogViewModel object = dataset.get(position);
        ((ImageTypeViewHolder) holder).title.setText(object.title);
        ((ImageTypeViewHolder) holder).subtitle.setText(object.subtitle);


    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }
}
