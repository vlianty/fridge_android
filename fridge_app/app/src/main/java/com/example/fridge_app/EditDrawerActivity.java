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





public class EditDrawerActivity extends AppCompatActivity {

    Button submmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_drawer);
        submmit = findViewById(R.id.submmit);
        final EditText simpleEditText = (EditText) findViewById(R.id.nameinput);//get the id for edit text

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setAdapter(new ArrayAdapter<GoodsType>(this, android.R.layout.simple_spinner_item, GoodsType.values()));

        submmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), NewDrawerActivity.class);
                //startActivity(intent);
                //Log.d("test","1234");
                EditText nameinput = (EditText) findViewById(R.id.nameinput);
                String name = nameinput.getText().toString();
                EditText minWeightInput = (EditText)findViewById(R.id.editTextNumber);
                float minWeight = Float.parseFloat(minWeightInput.getText().toString());
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                int gt = spinner.getSelectedItemPosition();
                GoodsType goodsType = GoodsType.Cooked;
                

                Log.d("test", name);
                Log.d("test", Float.toString(minWeight));
                Log.d("test", Integer.toString(gt));
                //TextView tv = (TextView) findViewById(R.id.nameinput);
                //tv.setText(input);
            }
        });
    }
}