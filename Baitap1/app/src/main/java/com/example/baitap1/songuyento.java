package com.example.baitap1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class songuyento extends AppCompatActivity {
    private EditText edt_soNT;
    private Button btn_kiemTra, btn_quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_songuyento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edt_soNT = findViewById(R.id.edt_soNT);
        btn_kiemTra = findViewById(R.id.btn_kiemTra);
        btn_quaylai = findViewById(R.id.btn_quaylai);

        btn_quaylai.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btn_kiemTra.setOnClickListener(v -> {
            String input = edt_soNT.getText().toString();
            if (!input.isEmpty()) {
                String[] numbers = input.split(",");
                ArrayList<Integer> numberList = new ArrayList<>();

                for (String number : numbers) {
                    try {
                        numberList.add(Integer.parseInt(number.trim()));
                    } catch (NumberFormatException e) {
                        Log.d("ERROR", "Số không hợp lệ: " + number);
                    }
                }

                for (int number : numberList) {
                    if (isPrime(number)) {
                        Log.d("Prime Numbers", number + " là số nguyên tố");
                    }
                }
            }
        });
    }
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}