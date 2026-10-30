package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //按钮跳转回Activity3
//        Button button = findViewById(R.id.button4);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
//
//                startActivity(intent);
//            }
//        });
        Intent intent =getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            int age = intent.getIntExtra("age",0);
            //打印日志
            Log.i("MainActivity4","解析到的名字："+name+",年龄："+age);
            //弹出Toast提示
            Toast.makeText(this,"名字："+name+",年龄："+age,Toast.LENGTH_SHORT).show();
        }
    }
}