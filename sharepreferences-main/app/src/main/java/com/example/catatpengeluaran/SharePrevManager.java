package com.example.catatpengeluaran;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.PublicKey;

public class SharePrevManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharePrevManager(Context context){
        sharedPreferences = context.getSharedPreferences("com.example.catatpengeluaran",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setAsDefaultValue();
    }

    private void setAsDefaultValue(){
        setUsername("admin");
        setPassword("12345678");
    }

    private void setPassword(String s) {
        editor.putString("sp_Password",s);
        editor.commit();
    }

    private void setUsername(String admin){
        editor.putString("sp_username",admin);
        editor.commit();
    }

    public void saveIsLogin(Boolean value){
        editor.putBoolean("sp_isLogin",value);
        editor.commit();
    }

    // Mendapatkan Value Shared Preferences

    public String getUsername(){
        return sharedPreferences.getString("sp_username","");
    }

    public String getPassword(){
        return sharedPreferences.getString("sp_Password","");
    }

    public Boolean getIsLogin(){
        return sharedPreferences.getBoolean("sp_isLogin",false);
    }

}
