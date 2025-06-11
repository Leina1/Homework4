package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.widget.TextView;
import com.example.homework4.adapters.WondersAdapter;

public class WondersActivity extends AppCompatActivity {

    private TextView tvFranceWonder, tvUkWonder, tvItalyWonder;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonders);

        // Khởi tạo các TextView trong header
        tvFranceWonder = findViewById(R.id.tv_france_wonder);
        tvUkWonder = findViewById(R.id.tv_uk_wonder);
        tvItalyWonder = findViewById(R.id.tv_italy_wonder);
        viewPager = findViewById(R.id.viewPager);

        // Đặt adapter cho ViewPager2
        viewPager.setAdapter(new WondersAdapter(this));

        // Thêm listener để thay đổi màu sắc khi kéo
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                resetTextColors(); // Reset tất cả về màu mặc định
                switch (position) {
                    case 0:
                        tvFranceWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvUkWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvItalyWonder.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvFranceWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvUkWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItalyWonder.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}