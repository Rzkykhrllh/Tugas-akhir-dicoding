package com.example.tugaasakhirdicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    String[] nama, harga, desc;
    int[] gambar = {
            R.drawable.ayam_geprek,
            R.drawable.coto_makassar,
            R.drawable.gado_gado,
            R.drawable.lontong_sayur,
            R.drawable.martabak_manis,
            R.drawable.nasi_goreng,
            R.drawable.nasi_kuning,
            R.drawable.nasi_liwet,
            R.drawable.rendang,
            R.drawable.sate
    };
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_heroes);
        nama = getResources().getStringArray(R.array.nama);
        desc = getResources().getStringArray(R.array.penjelasan);
        harga = getResources().getStringArray(R.array.Harga);

        ListAdapter listAdapter = new ListAdapter(this, nama, desc, harga, gambar);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    public void profile(View view) {
        //udah lengkap ?
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
}
