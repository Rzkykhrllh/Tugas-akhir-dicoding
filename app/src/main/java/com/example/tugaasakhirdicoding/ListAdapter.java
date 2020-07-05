package com.example.tugaasakhirdicoding;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.net.ConnectException;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    String[] nama, desc, harga;
    int[] gambar;
    Context context;

    public ListAdapter(Context context, String[] nama, String[] desc, String[] harga, int[] gambar) {
        this.nama = nama;
        this.desc = desc;
        this.context = context;
        this.gambar = gambar;
        this.harga = harga;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListHolder holder, final int position) {
        holder.tvnama.setText(nama[position]);
        holder.tvdesc.setText(desc[position]);
        holder.tvharga.setText(harga[position]);
        holder.gambar.setImageResource(gambar[position]);


        if (holder.mainlayout != null){
            holder.mainlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, detail.class);
                    intent.putExtra("KeyNama", nama[position]);
                    intent.putExtra("KeyDesc", desc[position]);
                    intent.putExtra("KeyHarga", harga[position]);
                    intent.putExtra("KeyGambar",gambar[position]);
                    context.startActivity(intent);
                }
            });
        } else{
            Log.d("Error","di Adapter");
        }

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        TextView tvnama,tvdesc, tvharga;
        ImageView gambar;
        RelativeLayout mainlayout;


        public ListHolder(@NonNull View itemView) {
            super(itemView);

            tvnama = itemView.findViewById(R.id.tv_nama);
            tvdesc = itemView.findViewById(R.id.tv_desc);
            tvharga = itemView.findViewById(R.id.tv_harga);
            gambar = itemView.findViewById(R.id.img_list);

            mainlayout = (RelativeLayout) itemView.findViewById(R.id.item_row);
        }
    }
}
