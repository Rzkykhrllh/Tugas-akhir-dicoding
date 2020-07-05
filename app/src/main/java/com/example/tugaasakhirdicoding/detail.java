package com.example.tugaasakhirdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {

    TextView nama,desc,harga;
    ImageView gambar;

    String nm,dsc,hrg;
    int gmbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama = findViewById(R.id.nama_makanan);
        harga = findViewById(R.id.harga_makanan);
        desc = findViewById(R.id.desc_makanan);
        gambar = findViewById(R.id.gambar_makanan);

        getdata();
        setdata();

    }


    private void getdata() {

        if (getIntent().getStringExtra("KeyNama") == null) {
            Toast.makeText(this, "KeyNama Error", Toast.LENGTH_SHORT).show();
        } else {
            nm = getIntent().getStringExtra("KeyNama");
        }


        if (getIntent().getStringExtra("KeyDesc") == null) {
            Toast.makeText(this, "Desc Error", Toast.LENGTH_SHORT).show();
        } else {
            dsc = getIntent().getStringExtra("KeyDesc");
        }


        if (getIntent().getStringExtra("KeyHarga") == null) {
            Toast.makeText(this, "KeyHarga Error", Toast.LENGTH_SHORT).show();
        } else {
            hrg = getIntent().getStringExtra("KeyHarga");
        }

        if (getIntent().getIntExtra("KeyGambar",1) == 0) {
            Toast.makeText(this, "KeyHarga Error", Toast.LENGTH_SHORT).show();
        } else {
            gmbr = getIntent().getIntExtra("KeyGambar",1);
        }

    }


    private void setdata(){
        nama.setText(nm);
        desc.setText(dsc);
        harga.setText(hrg);
        gambar.setImageResource(gmbr);
    }
}
