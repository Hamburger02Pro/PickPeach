package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {
    //Foods Name
    private String[] names = {"手撕面包","华夫饼","小麻花","每日坚果","原味肉饼"};
    //Foods Prices
    private String[] prices = {"4$","3$","2.5$","6$","5$"};
    //Shop Name
    private String[] shop = {"Shop1","Shop2","Shop3","Shop4","Shop5"};
    //Foods Picture
    private int[] picture = {R.drawable.tear_bread,R.drawable.waffle,R.drawable.dough_twist,R.drawable.daily_nuts,R.drawable.meat_floss};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //找到listview
        ListView lv = findViewById(R.id.lv);
        MyAdapter myAdapter = new MyAdapter(this);
        lv.setAdapter(myAdapter);

    }
    //准备数据适配器
    class MyAdapter extends BaseAdapter{
        private Context mContext;
        public MyAdapter(Context context){
            mContext = context;
        }
        @Override
        public int getCount() {
            return names.length;

        }
        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            ImageView iv = convertView.findViewById(R.id.iv_picture);
            TextView tv_goodsnames = convertView.findViewById(R.id.tv_goodsname);
            TextView tv_price = convertView.findViewById(R.id.tv_price);
            TextView tv_shop = convertView.findViewById(R.id.tv_shop);
            iv.setBackgroundResource(picture[position]);
            tv_goodsnames.setText(names[position]);
            tv_price.setText(prices[position]);
            tv_shop.setText(shop[position]);

            return convertView;
        }
    }
}