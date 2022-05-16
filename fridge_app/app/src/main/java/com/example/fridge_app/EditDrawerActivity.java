package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.util.Log;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class EditDrawerActivity extends AppCompatActivity {

    Button submmit;
    TextView date;
    Button datePickerButton;
    DatePickerDialog.OnDateSetListener datePicker;
    Calendar calendar = Calendar.getInstance();
    String dateinput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_drawer);
        submmit = findViewById(R.id.submmit);
        final EditText simpleEditText = (EditText) findViewById(R.id.nameinput);//get the id for edit text
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(new ArrayAdapter<GoodsType>(this, android.R.layout.simple_spinner_item, GoodsType.values()));
        datePickerButton = findViewById(R.id.datePickerButton);
        date = findViewById(R.id.date);

        int i = getIntent().getExtras().getInt("i");
        int j = getIntent().getExtras().getInt("j");


        datePicker = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TAIWAN);
                date.setText("date：" + sdf.format(calendar.getTime()));
                dateinput = sdf.format(calendar.getTime());
            }
        };

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(EditDrawerActivity.this,
                        datePicker,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        submmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText nameinput = (EditText) findViewById(R.id.nameinput);
                String name = nameinput.getText().toString();
                EditText minWeightInput = (EditText)findViewById(R.id.editTextNumber);
                float minWeight = Float.parseFloat(minWeightInput.getText().toString());
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                int gt = spinner.getSelectedItemPosition();
                GoodsType goodsType = GoodsType.Cooked;

                /*Log.d("test", name);
                Log.d("test", Float.toString(minWeight));
                Log.d("test", Integer.toString(gt));
                Log.d("test", dateinput);*/

                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("minWeight",minWeight);
                intent.putExtra("gt",gt);
                intent.putExtra("dateinput",dateinput);
                setResult(87,intent);

                finish();
            }
        });
    }
}