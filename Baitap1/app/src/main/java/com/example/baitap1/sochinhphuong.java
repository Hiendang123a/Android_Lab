package com.example.baitap1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class sochinhphuong extends AppCompatActivity {
    private EditText edt_number;
    private TextView txt_chinhphuong;
    private Button btn_check, btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sochinhphuong);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt_number = findViewById(R.id.edt_number);
        txt_chinhphuong = findViewById(R.id.txt_chinhphuong);
        btn_check = findViewById(R.id.btn_check);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btn_check.setOnClickListener(v -> {
            if(!TextUtils.isEmpty(edt_number.getText().toString()))
            {
                int input = Integer.parseInt(edt_number.getText().toString());
                if(input < 150)
                {
                    ArrayList<Integer> numberList = new ArrayList<>();

                    Random random = new Random();
                    for (int i = 0; i < input; i++) {
                        numberList.add(random.nextInt(1000));
                    }

                    StringBuilder resultText = new StringBuilder("Mảng ngẫu nhiên: ");
                    for (int i = 0; i < numberList.size(); i++) {
                        resultText.append(numberList.get(i));
                        if (i < numberList.size() - 1) {
                            resultText.append(", ");
                        }
                    }
                    txt_chinhphuong.setText(resultText);
                    StringBuilder toastText = new StringBuilder();
                    for (int number : numberList) {
                        if (isPerfectSquare(number)) {
                            toastText.append(number + ", ");
                        }
                    }
                    if(toastText.length() > 0)
                    {
                        Toast.makeText(this, toastText + "là số chính phương", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, "Không có số chính phương", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Số lượng quá lớn, hãy nhập lại!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "Vui lòng nhập nội dung", Toast.LENGTH_SHORT).show();
            }

        });
    }
    public boolean isPerfectSquare(int number) {
        if (number < 0)
            return false;

        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }
}