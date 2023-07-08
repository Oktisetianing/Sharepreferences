package com.example.catatpengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    TextView tvnamavalue , tvjumlahvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvnamavalue = findViewById(R.id.tvnamavalue);
        tvjumlahvalue = findViewById(R.id.tvjumlahvalue);

        //Opsi 1 : Ambil dari Bundle
        //Bundle bundle = getIntent().getExtras();
        //tvnamavalue.setText(bundle.getString("keyNama"));
        //tvjumlahvalue.setText(bundle.getString("keyJumlah"));

        //Opsi 2 : Ambil dari Data Intent
        Intent data = getIntent();
        String nama = data.getStringExtra("KeyNama");
        String jumlah = data.getStringExtra("KeyJumlah");

        tvnamavalue.setText(nama);
        tvjumlahvalue.setText(jumlah);
    }
}