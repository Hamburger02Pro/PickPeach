package com.example.myapplication.Peach;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

/**
 * 首页：显示累计摘桃数，点“去桃园”进入桃园，回来后刷新数字。
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv_count;

    /**
     * 启动桃园页面，并等待它返回结果。
     * 注意：必须在 onCreate 之前注册（写成成员变量就可以）。
     */
    private final ActivityResultLauncher<Intent> peachLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            showCount(result.getData().getIntExtra(PeachActivity.EXTRA_COUNT, 0));
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_peach);

        tv_count = findViewById(R.id.tv_count);

        Button btn_peach = findViewById(R.id.btn_peach);
        btn_peach.setOnClickListener(v ->
                peachLauncher.launch(new Intent(MainActivity.this, PeachActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 直接从 SharedPreferences 读：按系统返回键回来、或重启 App，都能显示最新累计数
        int total = getSharedPreferences(PeachActivity.PREFS_NAME, MODE_PRIVATE)
                .getInt(PeachActivity.KEY_TOTAL, 0);
        showCount(total);
    }

    private void showCount(int total) {
        tv_count.setText("累计摘到" + total + "个");
    }
}
