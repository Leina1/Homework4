package com.example.homework4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.widget.TextView;
import com.example.homework4.adapters.MuseumsAdapter;

public class MuseumsActivity extends AppCompatActivity {

    private TextView tvFranceMuseum, tvUkMuseum, tvItalyMuseum;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums);

        // Khởi tạo các TextView trong header
        tvFranceMuseum = findViewById(R.id.tv_france_museum);
        tvUkMuseum = findViewById(R.id.tv_uk_museum);
        tvItalyMuseum = findViewById(R.id.tv_italy_museum);
        viewPager = findViewById(R.id.viewPager);

        // Đặt adapter cho ViewPager2
        viewPager.setAdapter(new MuseumsAdapter(this));

        // Thêm listener để thay đổi màu sắc khi kéo
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                resetTextColors(); // Reset tất cả về màu mặc định
                switch (position) {
                    case 0:
                        tvFranceMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 1:
                        tvUkMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                    case 2:
                        tvItalyMuseum.setTextColor(getResources().getColor(android.R.color.white));
                        break;
                }
            }
        });
    }

    // Hàm reset màu sắc về mặc định
    private void resetTextColors() {
        tvFranceMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvUkMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
        tvItalyMuseum.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}