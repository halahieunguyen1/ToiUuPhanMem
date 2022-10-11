package com.example.toiuuphammem2;

import android.os.Bundle;


public class MinimalFractionsActivity extends AbstractNDKActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimal_fractions);
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
            long startTime = 0, endTime = 0;
            long totalResultJava = 0;
            long totalResultC = 0;
            long totalTimeJava = 0;
            long totalTimeC = 0;
            startTime = System.nanoTime();
            totalResultJava = MinimalFractionsJava(a);
            endTime = System.nanoTime();
            totalTimeJava = (endTime - startTime);

            startTime = System.nanoTime();
            totalResultC = MinimalFractions(a);
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

    private long MinimalFractionsJava(int n) {
        long knt,x=0;
        long a[] = new long[80000];
        int b=0;
        boolean nt;
        for(int i=2;i<=n;i++){
            knt=i;
            nt=true;
            for(int j=0;j<b;j++){
                if (knt%a[j]==0) {
                    knt-=knt/a[j];
                    nt=false;
                }
            }
            if (nt==true) {
                a[b] = knt;
                x+=i-1;
                b++;
            } else {
                x=x+knt;
            }
        }
        return x;
    }
}



