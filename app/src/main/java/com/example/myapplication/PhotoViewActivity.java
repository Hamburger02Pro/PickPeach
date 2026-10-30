package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PhotoViewActivity extends AppCompatActivity {
    //定义图片数据，导入图片名称
    private  RecyclerView rvAlbum;
    private int[] images = {
            R.drawable.photo_1,R.drawable.photo_2,R.drawable.photo_3,
            R.drawable.photo_4,R.drawable.photo_5, R.drawable.photo_6,
            R.drawable.photo_7,R.drawable.photo_8,R.drawable.photo_9,
            R.drawable.photo_10, R.drawable.photo_11,R.drawable.photo_12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        //1.获取RecycleView控件
        rvAlbum = findViewById(R.id.rv_album);
        //2.设置布局管理器：使用GridLayoutManager实现两列网格效果
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rvAlbum.setLayoutManager(layoutManager);
        //3.创建适配器并设置给RecyclerView
        AlbumAdapter adapter = new AlbumAdapter(images);
        rvAlbum.setAdapter(adapter);
    }
    class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHoder> {
        //数据源 ： 图片资源ID数组
        private int[] imageIds;

        public AlbumAdapter(int[] imageIds){
            this.imageIds = imageIds;
        }
        @NonNull
        @Override
        public AlbumViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //添加photo_item。xml
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.photo_item,parent,false);
            return new AlbumViewHoder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AlbumViewHoder holder, int position) {
            //将数据绑定到ImageView
            holder.ivPhoto.setImageResource(imageIds[position]);
        }

        @Override
        public int getItemCount() {
            return imageIds.length;
        }
        //ViewHolder类
        class AlbumViewHoder extends RecyclerView.ViewHolder{
            ImageView ivPhoto;

            public AlbumViewHoder(@NonNull View itemView) {
                super(itemView);
                ivPhoto = itemView.findViewById(R.id.iv_photo);
            }
        }
    }
}