package com.example.toiuuphammem2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    public static final int REQUEST_CODE_REGISTER = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.loadLibrary("native-lib");
        this.setOnClick();
    }

    private void setOnClick() {
        findViewById(R.id.congSoNguyen).setOnClickListener(this);
        findViewById(R.id.phanSoToiGian).setOnClickListener(this);
        findViewById(R.id.dienTichHinhTron).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.congSoNguyen:
                Intent intent = new Intent(this, TotalFiboActivity.class);
                startActivity(intent);
                break;
            case R.id.phanSoToiGian:
                Intent intent1 = new Intent(this, MinimalFractionsActivity.class);
                startActivity(intent1);
                break;
            case R.id.dienTichHinhTron:
                Intent intent2 = new Intent(this, CircleAreaActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}