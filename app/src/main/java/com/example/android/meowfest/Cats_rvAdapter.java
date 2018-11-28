package com.example.android.meowfest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.meowfest.data.Cat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Cats_rvAdapter extends RecyclerView.Adapter<Cats_rvAdapter.ViewHolder> {
    Context context;
    ArrayList<Cat> cats;

    public Cats_rvAdapter(Context context, ArrayList<Cat> cats) {
        this.context = context;
        this.cats = cats;
    }


    @NonNull
    @Override
    public Cats_rvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cats_rvAdapter.ViewHolder viewHolder, int pos) {

        viewHolder.cat_title.setText(cats.get(pos).getTitle());
        viewHolder.cat_desc.setText(cats.get(pos).getDescription());

        Picasso.get()
                .load(cats.get(pos).getImage_url())
                .error(R.drawable.no_image)
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cat_title;
        TextView cat_desc;
        ImageView image;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_title = (TextView) itemView.findViewById(R.id.title);
            cat_desc = (TextView) itemView.findViewById(R.id.descritpion);
            image = (ImageView) itemView.findViewById(R.id.cat_image);
            date = (TextView) itemView.findViewById(R.id.cat_date);
        }
    }
}
