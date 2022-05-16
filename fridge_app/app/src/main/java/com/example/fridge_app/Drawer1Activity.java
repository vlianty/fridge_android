package com.example.fridge_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Drawer1Activity extends AppCompatActivity {

    Button editbtn;
    String name;
    float minWeight;
    int gt;
    String dateinput;

    TextView t_name, t_Type, t_minweight, t_Date;

    //回傳資料回來這個Activity
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 87)
                    {
                        Intent intent = result.getData();
                        if (intent != null)
                        {
                            name = intent.getStringExtra("name");
                            minWeight = intent.getFloatExtra("minWeight",0);
                            gt = intent.getIntExtra("gt",0);
                            dateinput = intent.getStringExtra("dateinput");

                            t_name.setText("Name:"+name);
                            t_minweight.setText("Minweight:"+Float.toString(minWeight));
                            t_Date.setText("Date:"+dateinput);
                            switch (gt)
                            {
                                case 0:
                                    t_Type.setText("Type:"+GoodsType.RawMeat.toString());
                                    break;
                                case 1:
                                    t_Type.setText("Type:"+GoodsType.Cooked.toString());
                                    break;
                                case 2:
                                    t_Type.setText("Type:"+GoodsType.Vegetable.toString());
                                    break;
                            }

                            Log.d("test",name);
                            Log.d("test",Float.toString(minWeight));
                            Log.d("test",Integer.toString(gt));
                            Log.d("test",dateinput);
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer1);
        editbtn = findViewById(R.id.editbtn);
        t_name = findViewById(R.id.name);
        t_Type = findViewById(R.id.type);
        t_minweight = findViewById(R.id.minweight);
        t_Date = findViewById(R.id.Date);

        int i = getIntent().getExtras().getInt("i");
        int j = getIntent().getExtras().getInt("j");
        Log.d("test",Integer.toString(i));
        Log.d("test",Integer.toString(j));

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditDrawerActivity.class);
                intent.putExtra("i",i);
                intent.putExtra("j",j);
                activityResultLauncher.launch(intent);
//                startActivity(intent);
            }
        });
    }
}

//商品細節切到編輯