package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    TextView twResult;
    Button btnSolve, btnDel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mappingg();
        addListenerOnButtonClick();

    }

    @SuppressLint("SetTextI18n")
    private void addListenerOnButtonClick() {
        btnDel.setOnClickListener(view -> {
            edtA.setText("");
            edtB.setText("");
            twResult.setText("");
            Toast.makeText(this, "Dữ liệu đã bị xoá!", Toast.LENGTH_SHORT).show();
        });

        btnSolve.setOnClickListener(view -> {
            String a = edtA.getText().toString();
            String b = edtB.getText().toString();

            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập các hệ số", Toast.LENGTH_SHORT).show();
            } else if (Double.parseDouble(a) != 0) {
                double x = - Double.parseDouble(b) / Double.parseDouble(a);
                twResult.setText("Phương trình có nghiệm x = " + x);
            } else {
                twResult.setText("Phương trình vô nghiệm.");
            }
        });
    }

    private void mappingg() {
        edtA = findViewById(R.id.edt_a);
        edtB = findViewById(R.id.edt_b);
        btnDel = findViewById(R.id.btn_del);
        btnSolve = findViewById(R.id.btn_solve);
        twResult = findViewById(R.id.tw_result);
    }
}