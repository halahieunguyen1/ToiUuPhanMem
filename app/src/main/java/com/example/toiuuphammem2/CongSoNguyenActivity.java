package com.example.toiuuphammem2;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class CongSoNguyenActivity extends AbstractNDKActivity {
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
        setContentView(R.layout.activity_cong_so_nguyen);
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

        this.calc.setOnClickListener(v -> {
            int a = Integer.parseInt(this.numberOne.getText().toString());
            int b = Integer.parseInt(this.numberTwo.getText().toString());
            int loop = Integer.parseInt(this.loop.getText().toString());
            int ab=0;
            ResultAndTime cd = new ResultAndTime();
            long startTime = 0, endTime = 0;
            long totalResultJava = 0;
            long totalResultC = 0;
            long totalTimeJava = 0;
            long totalTimeC = 0;
            ResultAndTime ef;
            for (int i = 1; i <= loop; i++) {
                startTime = System.nanoTime();
                ab = a + b;
                ab = a + b;
                ab = a + b;
                ab = a + b;
                ab = a + b;
                endTime = System.nanoTime();
                totalResultJava += ab;
                totalTimeJava += (endTime - startTime);
            }

            for (int i = 1; i <= loop; i++) {
                ef = cd.congSoNguyen(a,b);
                totalResultC += ef.result;
                totalTimeC += ef.time;
            }

            this.resultJava.setText(Double.toString(totalResultJava/loop));
            this.timeJava.setText(Double.toString(totalTimeJava/loop));
//
//
            this.resultNativeC.setText(Double.toString(totalResultC/loop));
            this.timeNativeC.setText(Double.toString(totalTimeC/loop));
        });
    }

    public void calc() {

    }


}