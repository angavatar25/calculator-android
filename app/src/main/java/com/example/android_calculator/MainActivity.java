package com.example.android_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button one,two,three,four,five;
    private Button six,seven,eight,nine,zero;
    private Button add, minus, multiple, divide, equal, clear, percentage;
    private TextView calculation, answer;
    private double val1 = Double.NaN;
    private double val2;
    public double percentageResult = Double.NaN;
    private final char addition = '+';
    private final char substract = '-';
    private final char multiplication = '*';
    private final char division = '/';
    private final char percent = '%';
    private final char result = '=';
    char action;
    char percent_calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setResultView();
        onClickNumber();
        onClickOperator();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation.setText(calculation.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = addition;
                answer.setText(String.valueOf(val1) + "+");
                calculation.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = substract;
                answer.setText(String.valueOf(val1) + "-");
                calculation.setText(null);
            }
        });

        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = multiplication;
                answer.setText(String.valueOf(val1) + "x");
                calculation.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = division;
                answer.setText(String.valueOf(val1) + "/");
                calculation.setText(null);
            }
        });

//        percentage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                computePercentage();
//                calculation.setText(Double.toString(answer));
//            }
//        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = result;
                answer.setText( "=" + String.valueOf(val1));
                calculation.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculation.getText().length() > 0) {
                    CharSequence name = calculation.getText().toString();
                    calculation.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    calculation.setText(null);
                    answer.setText(null);
                }
            }
        });

    }

    public void onClickNumber() {
        one = (Button)findViewById(R.id.btn_one);
        two = (Button)findViewById(R.id.btn_two);
        three = (Button)findViewById(R.id.btn_three);
        four = (Button)findViewById(R.id.btn_four);
        five = (Button)findViewById(R.id.btn_five);
        six = (Button)findViewById(R.id.btn_six);
        seven = (Button)findViewById(R.id.btn_seven);
        eight = (Button)findViewById(R.id.btn_eight);
        nine = (Button)findViewById(R.id.btn_nine);
        zero = (Button)findViewById(R.id.btn_zero);
    }

    public void setResultView() {
        calculation = (TextView)findViewById(R.id.calculation);
        answer = (TextView)findViewById(R.id.answer);
    }

    public void  onClickOperator() {
        add = (Button)findViewById(R.id.btn_plus);
        minus = (Button)findViewById(R.id.btn_minus);
        multiple = (Button)findViewById(R.id.btn_times);
        divide = (Button)findViewById(R.id.btn_divide);
//        percentage = (Button)findViewById(R.id.btn_percentage);
        clear = (Button)findViewById(R.id.btn_clear);
        equal = (Button)findViewById(R.id.btn_result);
    }

    private void compute() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(calculation.getText().toString());

            switch(action){
                case addition:
                    val1 += val2;
                    break;
                case substract:
                    val1 -= val2;
                    break;
                case multiplication:
                    val1 = val1 * val2;
                    break;
                case division:
                    val1 = val1 / val2;
                    break;
                case result:
                    break;
            }
        }

        else {
            val1 = Double.parseDouble(calculation.getText().toString());
        }
    }

    private double readDisplayState() {
        return Double.parseDouble(answer.getText().toString());
    }

    public void computePercentage() {
        percentageResult = (readDisplayState() / 100);
    }
}
