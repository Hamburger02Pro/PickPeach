package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity2","onCreate()被调用");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity2","onStart()被调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity2","onResume()被调用");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity2","onPause()被调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity2","onStop()被调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity2","onDestroy()被调用");
    }
}