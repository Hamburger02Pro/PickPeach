package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleActivity extends AppCompatActivity {
    private String[] names = {"小猫", "哈士奇", "小黄鸭", "小鹿", "老虎"};
    private int[] imgs = {R.drawable.cat, R.drawable.siberiankusky,
            R.drawable.yellowduck, R.drawable.fawn, R.drawable.tiger};
    private String[] introduces = {
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较为广泛的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，一些属的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物。体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色，满有黑色横纹；头圆、耳短，耳背面黑色。中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Toast.makeText(this, "页面已加载", Toast.LENGTH_SHORT).show();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        HomeAdapter adapter = new HomeAdapter();
        rv.setAdapter(adapter);
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(RecycleActivity.this).inflate(R.layout.animal_item, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.iv.setBackgroundResource(imgs[position]);
            holder.tv_name.setText(names[position]);
            holder.tv_introduce.setText(introduces[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv;
            TextView tv_name,tv_introduce;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                iv = itemView.findViewById(R.id.iv);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_introduce = itemView.findViewById(R.id.tv_introduce);
            }
        }
    }
}
