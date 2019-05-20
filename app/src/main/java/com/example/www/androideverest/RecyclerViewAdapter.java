package com.example.www.androideverest;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<RecyclerViewModel> row_list;

    public RecyclerViewAdapter(List<RecyclerViewModel> row_list) {
        this.row_list = row_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View my_view = inflater.inflate(R.layout.recyclerview_row, parent, false);

        return new MyViewHolder(my_view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.vh_imageView_icon.setImageDrawable(row_list.get(position).getIcon());
        holder.vh_imageView_photo.setImageDrawable(row_list.get(position).getPhoto());
        holder.vh_textView_title.setText(row_list.get(position).getTitle());
        holder.vh_textView_subtitle.setText(row_list.get(position).getSubtitle());
        holder.vh_textView_id.setText(row_list.get(position).getIdentification());
    }

    @Override
    public int getItemCount() {
        return row_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView vh_imageView_icon, vh_imageView_photo;
        TextView vh_textView_title, vh_textView_subtitle, vh_textView_id;

        public MyViewHolder(View itemView) {
            super(itemView);

            vh_imageView_icon = itemView.findViewById(R.id.recyclerview_icon);
            vh_imageView_photo = itemView.findViewById(R.id.recyclerview_photo);
            vh_textView_title = itemView.findViewById(R.id.recyclerview_title);
            vh_textView_subtitle = itemView.findViewById(R.id.recyclerview_subtitle);
            vh_textView_id = itemView.findViewById(R.id.recyclerview_id);
        }
    }
}
