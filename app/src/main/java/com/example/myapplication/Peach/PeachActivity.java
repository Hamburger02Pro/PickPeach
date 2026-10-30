package com.example.myapplication.Peach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * 桃园页面：点桃子 -> 桃子消失 + 累计数 +1 + 提示；
 * 点“退出桃园” -> 带累计数回首页。
 * 累计数存在 SharedPreferences 里，退出 App、重启手机都不会丢。
 */
public class PeachActivity extends AppCompatActivity implements View.OnClickListener {

    /** 把数量带回首页用的 key */
    public static final String EXTRA_COUNT = "peach_count";

    /** 累计摘桃数存放的位置，首页也要读同一份 */
    public static final String PREFS_NAME = "peach_prefs";
    public static final String KEY_TOTAL = "total_count";

    /** 所有桃子。加第 7 个桃子时，只要往这里加一个 id。 */
    private static final int[] PEACH_IDS = {
            R.id.btn_one, R.id.btn_two, R.id.btn_three,
            R.id.btn_four, R.id.btn_five, R.id.btn_six
    };

    /** 累计摘桃数（从上次退出时的数值接着加） */
    private int total;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peach);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        total = prefs.getInt(KEY_TOTAL, 0);

        for (int id : PEACH_IDS) {
            findViewById(id).setOnClickListener(this);
        }
        findViewById(R.id.btn_exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_exit) {
            backToHome();
            return;
        }
        for (int id : PEACH_IDS) {
            if (v.getId() == id) {
                pickPeach(v);
                return;
            }
        }
    }

    /**
     * 摘一个桃子：消失 + 累计数 +1 + 提示。
     * 参数就是要处理的那个桃子（View 类型，ImageView / Button 都能传）。
     */
    private void pickPeach(View peach) {
        peach.setVisibility(View.INVISIBLE);          // 保留占位，别的桃子不会乱跳
        total++;
        prefs.edit().putInt(KEY_TOTAL, total).apply(); // 立即存盘，按返回键/切后台也不丢
        Toast.makeText(this, "累计摘了 " + total + " 个桃子", Toast.LENGTH_SHORT).show();
    }

    /** 退出桃园：把累计数放进 Intent，返回首页 */
    private void backToHome() {
        Intent data = new Intent();
        data.putExtra(EXTRA_COUNT, total);
        setResult(RESULT_OK, data);
        finish();
    }
}
