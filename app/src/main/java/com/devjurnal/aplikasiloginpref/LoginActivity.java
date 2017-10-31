package com.devjurnal.aplikasiloginpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // TODO
    public static String LOGIN_PREF = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginApps(View view) {
        EditText inpUsername = (EditText) findViewById(R.id.inpUsername);
        EditText inpPassword = (EditText) findViewById(R.id.inpPassword);

        String username = inpUsername.getText().toString();
        String password = inpPassword.getText().toString();

        // TODO 11 setting SharedPreference
        if (username.equals("adit") && password.equals("ya")){
            SharedPreferences sp = getSharedPreferences(LOGIN_PREF, MODE_PRIVATE);

            SharedPreferences.Editor spEdit = sp.edit();

            spEdit.putString("username",username);
            spEdit.putString("token","sdkj23h4r9dfhakse4jhsadf9813e23rhkj");

            spEdit.apply();

            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            Intent in =new Intent(this,MainActivity.class);
            // TODO (12) khusus login, menghapus activity sebelumnya
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);

            // TODO (13) setting MainActivity
        }
    }
}
