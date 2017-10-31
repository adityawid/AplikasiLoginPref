package com.devjurnal.aplikasiloginpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO 13 penerapan
    SharedPreferences loginPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO (14) cek Login pref
        // Jika belum login atau tidak ada token diarahkan untuk membuka LoginActivity
        loginPref = getSharedPreferences(LoginActivity.LOGIN_PREF, MODE_PRIVATE);

        if(!loginPref.contains("token")){
            Intent in = new Intent(this, LoginActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Log.i("main.class.activity", sp.getString("your_name", "No Name"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();

            // TODO (10) add intent
            startActivity(new Intent(this, SettingActivity.class));

            return true;

            /*TODO (2) tambah id logout*/
            // TODO (3) create new XML name : preferences
        } else if( id == R.id.action_logout){
            Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();

            // TODO (15) setting Logout
            SharedPreferences.Editor logPrefEdit = loginPref.edit();
            logPrefEdit.clear();
            logPrefEdit.apply();

            Intent in = new Intent(this, LoginActivity.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
