package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.page.Park.ParkActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;

public class ShoppingActivity extends AppCompatActivity {

    private static final String PRODUCT_URL = "https://item.jd.com/10103645274300.html?extension_id=eyJhZCI6IiIsImNoIjoiIiwic2hvcCI6IiIsInNrdSI6IiIsInRzIjoiIiwidW5pcWlkIjoie1wiY2xpY2tfaWRcIjpcImEwMmI2ODBlLTY5M2MtNGY1NC05YTEyLTQ5MjNiYjk1NjZkZVwiLFwicG9zX2lkXCI6XCIyNjE3XCIsXCJzaWRcIjpcIjQwNjYyNzNkLTU0Y2UtNDc3NC1hY2IxLTUyODllMjE4YzE5N1wiLFwic2t1X2lkXCI6XCIxMDEwMzY0NTI3NDMwMFwifSJ9&jd_pop=a02b680e-693c-4f54-9a12-4923bb9566de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        // 设置系统栏内边距
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 获取大图片
        ImageView bigImage = findViewById(R.id.bigImage);
        bigImage.setOnClickListener(v -> openWebPage(PRODUCT_URL));

        // 获取小图片
        ImageView smallImage1 = findViewById(R.id.smallImage1);
        ImageView smallImage2 = findViewById(R.id.smallImage2);
        ImageView smallImage3 = findViewById(R.id.smallImage3);
        ImageView smallImage4 = findViewById(R.id.smallImage4);

        // 设置小图片点击事件
        smallImage1.setOnClickListener(v -> openWebPage(PRODUCT_URL));
        smallImage2.setOnClickListener(v -> openWebPage(PRODUCT_URL));
        smallImage3.setOnClickListener(v -> openWebPage(PRODUCT_URL));
        smallImage4.setOnClickListener(v -> openWebPage(PRODUCT_URL));

        // 获取 BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 设置默认选中项为购物页
        bottomNavigationView.setSelectedItemId(R.id.nav_shopping);

        // 设置点击监听器
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                // 跳转到首页
                startActivity(new Intent(ShoppingActivity.this, HomeActivity.class));
                overridePendingTransition(0, 0); // 可选，用于移除过渡动画
                return true;
            } else if (itemId == R.id.nav_square) {
                // 跳转到广场
                startActivity(new Intent(ShoppingActivity.this, ParkActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_creation_center) {
                // 跳转到创作中心
                startActivity(new Intent(ShoppingActivity.this, CreationCenterActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_shopping) {
                // 当前已经是购物页
                return true;
            } else if (itemId == R.id.nav_profile) {
                // 跳转到个人中心
                startActivity(new Intent(ShoppingActivity.this, ProfileActivity.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}