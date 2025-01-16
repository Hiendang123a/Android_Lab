package com.example.baitap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CircleImageView img_myImage;
        TextView txt_thongTin;
        Button btn_nguyenTo, btn_chinhPhuong;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        img_myImage = findViewById(R.id.img_myImage);
        txt_thongTin = findViewById(R.id.txt_thongTin);
        btn_nguyenTo = findViewById(R.id.btn_nguyenTo);
        btn_chinhPhuong = findViewById(R.id.btn_chinhPhuong);
        img_myImage.setImageResource(R.drawable.hien);
        String text = "Đặng Bá Hiền-22110320\nSinh viên trường Đại học Sư Phạm Kỹ Thuật";
        txt_thongTin.setText(text);

        btn_nguyenTo.setOnClickListener(v -> {
            Intent intent = new Intent(this, songuyento.class);
            startActivity(intent);
        });

        btn_chinhPhuong.setOnClickListener(v -> {
            Intent intent = new Intent(this, sochinhphuong.class);
            startActivity(intent);
        });
    }
}