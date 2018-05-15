package com.example.harshmodi.dateinput;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Toast;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private CheckBox cb1;
    int m,y,d;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        cb1 = (CheckBox)findViewById(R.id.checkBox);


        /*LocalDateTime t = LocalDateTime.now();
        y = t.getYear();
        d = t.getDayOfMonth();
        m = t.getMonthValue();*/
        y = 2017; m = 10;

        showDialogMethod();
    }
    public void onCheckClick(View view){
        boolean checked = ((CheckBox) view).isChecked();
        if(checked){
            Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "UnChecked", Toast.LENGTH_SHORT).show();
        }
    }
    public void showDialogMethod(){

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
               // Toast.makeText(MainActivity.this, "HEllo", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            return new DatePickerDialog(this, dpickerListener, y,m,d);
        }
        else return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            y = i;
            m = i1+1;
            d = i2;
            String disp = d+"/"+m+"/"+y;
            Toast.makeText(MainActivity.this, disp , Toast.LENGTH_LONG).show();
        }
    };
}
