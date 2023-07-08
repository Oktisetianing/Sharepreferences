package com.example.catatpengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SharedPreferensactActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private SharePrevManager sharePrevManager;
    private EditText etUsername, etPassword;
    private Button btnlogin;
    private ProgressBar pbLogin;
    private ImageView ivLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferensact);

        sharePrevManager = new SharePrevManager(this);
        if (sharePrevManager.getIsLogin()){
            //kondisi jika user sudah log in
            startHomeUI();
        }
    }
    public  void startHomeUI(){
        Intent i = new Intent(SharedPreferensactActivity.this,
                LoginActivity.class);

        startActivity(i);
        finishAffinity(); 
    }


}