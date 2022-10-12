package com.example.toiuuphammem2;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractNDKActivity extends AppCompatActivity {

    protected Context context;
    protected Button calc;
    protected EditText loop;

    protected EditText numberTwo;
    protected EditText word;
    protected EditText numberOne;
    protected TextView resultJava;
    protected TextView resultNativeC;
    protected TextView timeJava;
    protected TextView timeNativeC;

    public abstract void calc();
//    protected native int congSoNguyen(int a, int b);
    public native long totalFibo(long a, long b, int loop);
    public native long MinimalFractions(int a);
    public native double CircleArea(float a);
    public native String StandardWord(String a);

    protected abstract void setOnClick();

}
