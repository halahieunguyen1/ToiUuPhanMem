package com.example.toiuuphammem2;

import android.os.Bundle;


public class TotalFiboActivity extends AbstractNDKActivity {

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
            long a = Integer.parseInt(this.numberOne.getText().toString());
            long b = Integer.parseInt(this.numberTwo.getText().toString());
            int loop = Integer.parseInt(this.loop.getText().toString());
            long startTime = 0, endTime = 0;
            long totalResultJava = 0;
            long totalResultC = 0;
            long totalTimeJava = 0;
            long totalTimeC = 0;
            startTime = System.nanoTime();
            totalResultJava = totalFiboJava(a,b, loop);
            endTime = System.nanoTime();
            totalTimeJava = (endTime - startTime);

            startTime = System.nanoTime();
            totalResultC = totalFibo(a,b,loop);
            endTime = System.nanoTime();
            totalTimeC = endTime - startTime;
            this.resultJava.setText(Double.toString(totalResultJava));
            this.timeJava.setText(Double.toString(totalTimeJava/loop));

            this.resultNativeC.setText(Double.toString(totalResultC));
            this.timeNativeC.setText(Double.toString(totalTimeC/loop));
        });
    }

    public void calc() {

    }

    private long totalFiboJava(long begin,long end, int loop) {
        long c = 0;
        for (int j = 1; j <= loop; j++) {
            if (begin < 0 || end < 0) {
                return (long) 0;
            }
            if (end < begin) {
                long k = end;
                end = begin;
                begin = k;
            }
            long a1 = 1, a2 = 1;
            if (end == 1) {
                if (begin == 0) return (long) 1;
                return (long) 0;
            }
            long i = 2, a = 1;
            if (begin == 1) a = 1;
            if (begin == 2) a = 2;
            if (begin == 0) a = 0;
            while (i < begin) {
                a = a1 + a2;
                a1 = a2;
                a2 = a;
                i++;
            }
            long fib = a;
            i++;
            while (i <= end) {
                a = a1 + a2;
                a1 = a2;
                a2 = a;
                i++;
            }
            c = a - fib;
        }
        return c;
    }
}



