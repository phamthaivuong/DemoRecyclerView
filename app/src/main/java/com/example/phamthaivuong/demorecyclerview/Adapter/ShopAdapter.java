package com.example.phamthaivuong.demorecyclerview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phamthaivuong.demorecyclerview.Model.DataShop;
import com.example.phamthaivuong.demorecyclerview.R;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup pagent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_row,pagent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.txtName.setText(dataShops.get(i).getTen());
        viewHolder.imgHinh.setImageResource(dataShops.get(i).getHinhAnh());

    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgHinh;
        LinearLayout line;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            imgHinh = (ImageView)itemView.findViewById(R.id.imgHinh);
            line = (LinearLayout)itemView.findViewById(R.id.line);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DeleteItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
    public void DeleteItem(int i){
        dataShops.remove(i);
        notifyItemRemoved(i);
    }
}
