package com.example.harshmodi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDot, badd, bsub, bmul, bdiv, beq, res;
    private float num1, num2;
    private boolean addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   ed1 = (EditText)findViewById(R.id.edt);
        res = (Button)findViewById(R.id.reset);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        bDot = (Button)findViewById(R.id.buttonDot);
        badd = (Button)findViewById(R.id.addButton);
        bmul = (Button)findViewById(R.id.mulButton);
        bsub = (Button)findViewById(R.id.subButton);
        bdiv = (Button)findViewById(R.id.divButton);
        beq = (Button)findViewById(R.id.buttonEq);


        num1 = num2 = 0;
        addition = subtraction = multiplication = division = false;
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(null);
                num1 = 0;
                num2 = 0;
                addition = subtraction = multiplication = division = false;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"0");
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+".");
            }
        });

        badd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(ed1.getText().toString());
                ed1.setText(null);
                addition = true;
            }
        });

        bsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(ed1.getText().toString());
                ed1.setText(null);
                subtraction = true;
            }
        });

        bmul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(ed1.getText().toString());
                ed1.setText(null);
                multiplication = true;
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(ed1.getText().toString());
                ed1.setText(null);
                division = true;
            }
        });

        beq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(ed1 == null){
                    ed1.setText(null);
                }
                else{
                    float res;
                    num2 = Float.parseFloat(ed1.getText().toString());
                    if(addition){
                        res = num1 + num2;
                        addition = false;
                    }
                    else if(subtraction){
                        res = num1 - num2;
                        subtraction = false;
                    }
                    else if(multiplication){
                        res = num1 * num2;
                        multiplication = false;
                    }
                    else{
                        if(num2 == 0)res = 0;
                        else{
                            res = num1/num2;
                            division = false;
                        }
                    }
                    ed1.setText(res+"");
                }
            }
        });
*/
    }

}
