package com.example.toiuuphammem2;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractNDKActivity extends AppCompatActivity {

    protected Context context;
    protected Button calc;
    protected EditText loop;

    public abstract void calc();
//    protected native int congSoNguyen(int a, int b);
    public native long totalFibo(long a, long b, int loop);

    protected abstract void setOnClick();

}
