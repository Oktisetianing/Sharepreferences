package com.example.catatpengeluaran;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Deklarasi variable
    TextView tv_nama;
    EditText et_jumlah;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi variable
        tv_nama = findViewById(R.id.tv_nama);
        et_jumlah = findViewById(R.id.et_jumlah);
        btn_submit = findViewById(R.id.btn_submit);

        // memakai button
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( MainActivity.this);
                // Membuat judul alert dialog
                alertDialogBuilder.setTitle("Konfirmasi");

                // Membuat Pesan alert dialog
                alertDialogBuilder.setMessage("Apakah Anda yakin akan menyimpan Data?")
                        .setIcon(R.drawable.avataraku)
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String nama = tv_nama.getText().toString();
                                String jumlah = et_jumlah.getText().toString();

                                // Pengecekan jumlah harus diisi
                                if (jumlah.isEmpty()) {
                                    Toast.makeText(MainActivity.this, "Jumlah Pengeluaran harus diisi", Toast.LENGTH_SHORT).show();
                                } else {
                                    //Opsi 1 : Passing data via Extras
                                    //Bundle bundle = new Bundle();
                                    //bundle.putString("keyNama",nama);
                                   // bundle.putString("keyJumlah",jumlah);
                                    //Intent intent = new Intent(MainActivity.this,DataActivity.class);
                                   // intent.putExtras(bundle);
                                   // startActivity(intent);

                                    //Opsi 2 :  Passing data via Data
                                    Intent intent2 = new Intent(MainActivity.this, DataActivity.class);
                                    intent2.putExtra("KeyNama", nama);
                                    intent2.putExtra("KeyJumlah", jumlah);
                                    startActivity(intent2);

                                }

                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                              dialog.cancel();
                            }
                        });
                AlertDialog dialog=alertDialogBuilder.create();
                dialog.show();

            }
        });
    }
}