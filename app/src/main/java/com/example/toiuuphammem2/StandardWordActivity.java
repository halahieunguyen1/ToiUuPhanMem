package com.example.toiuuphammem2;

import android.os.Bundle;


public class StandardWordActivity extends AbstractNDKActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_area);
        this.setOnClick();
    }


    protected void setOnClick() {
        this.calc = findViewById(R.id.calc);
        this.loop = findViewById(R.id.loop);
        this.word = findViewById(R.id.word);
        this.resultJava = findViewById(R.id.resultJava);
        this.timeJava = findViewById(R.id.timeJava);
        this.resultNativeC = findViewById(R.id.resultNativeC);
        this.timeNativeC = findViewById(R.id.timeNativeC);

        this.calc.setOnClickListener(v -> {
            String a = this.word.getText().toString();
            long startTime = 0, endTime = 0;
            String resultJava = "";
            String resultC = "";
            long totalTimeJava = 0;
            long totalTimeC = 0;
            startTime = System.nanoTime();
            resultJava = StandardWordJava(a);
            endTime = System.nanoTime();
            totalTimeJava = (endTime - startTime);

            startTime = System.nanoTime();
            resultC = StandardWord(a);
            endTime = System.nanoTime();
            totalTimeC = endTime - startTime;
            this.resultJava.setText(resultJava);
            this.timeJava.setText(Double.toString(totalTimeJava));

            this.resultNativeC.setText(resultC);
            this.timeNativeC.setText(Double.toString(totalTimeC));
        });
    }

    public void calc() {

    }

    private String StandardWordJava(String n) {
        return n;
    }
}



