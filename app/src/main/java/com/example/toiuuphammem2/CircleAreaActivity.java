package com.example.toiuuphammem2;

import android.os.Bundle;


public class CircleAreaActivity extends AbstractNDKActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_area);
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
            float a = Float.parseFloat(this.numberOne.getText().toString());
            long startTime = 0, endTime = 0;
            double totalResultJava = 0;
            double totalResultC = 0;
            long totalTimeJava = 0;
            long totalTimeC = 0;
            startTime = System.nanoTime();
            totalResultJava = CircleAreaJava(a);
            endTime = System.nanoTime();
            totalTimeJava = (endTime - startTime);

            startTime = System.nanoTime();
            totalResultC = CircleArea(a);
            endTime = System.nanoTime();
            totalTimeC = endTime - startTime;
            this.resultJava.setText(Double.toString(totalResultJava));
            this.timeJava.setText(Double.toString(totalTimeJava));

            this.resultNativeC.setText(Double.toString(totalResultC));
            this.timeNativeC.setText(Double.toString(totalTimeC));
        });
    }

    public void calc() {

    }

    private double CircleAreaJava(float n) {
        double result = 0;
        for (int t = 1; t < 1000000; t++) {
            result = 3.14159*n*n;
        }
        return result;
    }
}



