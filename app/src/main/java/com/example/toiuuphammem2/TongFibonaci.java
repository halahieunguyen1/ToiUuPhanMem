package com.example.toiuuphammem2;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class TongFibonaci extends AbstractNDKActivity {
    private EditText numberOne;
    private Context context;

    private EditText numberTwo;
    private TextView resultJava;
    private TextView resultNativeC;
    private TextView timeJava;
    private TextView timeNativeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_day_fibonaci);
        this.setOnClick();
    }


    protected void setOnClick() {
        this.calc = findViewById(R.id.calc);
        this.loop = findViewById(R.id.loop);
        this.numberOne = findViewById(R.id.numberOne);
        this.numberTwo = findViewById(R.id.numberTwo);
        this.resultJava = findViewById(R.id.resultJava);
        this.timeJava = findViewById(R.id.timeJava);
        this.resultNativeC = findViewById(R.id.resultNativeC);
        this.timeNativeC = findViewById(R.id.timeNativeC);

        this.calc.setOnClickListener(v -> calc());
    }

    public void calc() {
        int a = Integer.parseInt(this.numberOne.getText().toString());
        int b = Integer.parseInt(this.numberTwo.getText().toString());
        int loop = Integer.parseInt(this.loop.getText().toString());
        ResultAndTime cd = new ResultAndTime();
        long startTime = 0, endTime = 0;
        long resultJava = 0;
        long totalResultC = 0;
        long totalTimeJava = 0;
        long totalTimeC = 0;
        ResultAndTime ef;
        for (int i = 1; i <= loop; i++) {
            startTime = System.nanoTime();
            resultJava = fibonaciJava(a, b);
            endTime = System.nanoTime();
            totalTimeJava += (endTime - startTime);
        }

        for (int i = 1; i <= loop; i++) {
            ef = cd.congSoNguyen(a,b);
            totalResultC += ef.result;
            totalTimeC += ef.time;
        }

        this.resultJava.setText(Double.toString(resultJava));
        this.timeJava.setText(Double.toString(totalTimeJava/loop));
//
//
        this.resultNativeC.setText(Double.toString(totalResultC/loop));
        this.timeNativeC.setText(Double.toString(totalTimeC/loop));
    }

    private long fibonaciJava(long begin,long end) {
        if (begin < 0 || end < 0) return 0;
        if (begin > end) {
            long k = begin;
            begin = end;
            end = k;
        }
        long result = 0;
        int f0 = 0;
        int f1 = 1;
        int fn = 1;

        if(n == 1) {
            return n;
        } else {
            for (int i = 2; i < n; i++) {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }
        return result;
    }

}