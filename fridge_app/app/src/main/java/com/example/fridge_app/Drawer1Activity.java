package com.example.fridge_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.time.LocalDate;


public class Drawer1Activity extends AppCompatActivity {

    Button editbtn;
    String name;
    float minWeight;
    int gt;
    String dateinput;
    LocalDate ld;

    int i,j;
    TextView t_name, t_Type, t_minweight, t_Date;
    controller ctrl;

    //回傳資料回來這個Activity
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @RequiresApi(api = Build.VERSION_CODES.O)
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
                            GoodsType tmp = GoodsType.RawMeat;
                            switch (gt)
                            {
                                case 0:
                                    t_Type.setText("Type:"+GoodsType.RawMeat.toString());
                                    tmp = GoodsType.RawMeat;
                                    break;
                                case 1:
                                    t_Type.setText("Type:"+GoodsType.Cooked.toString());
                                    tmp = GoodsType.Cooked;
                                    break;
                                case 2:
                                    t_Type.setText("Type:"+GoodsType.Vegetable.toString());
                                    tmp = GoodsType.Vegetable;
                                    break;
                            }
                            Goods goods = new Goods(0,tmp,null,name);
                            //修改//把String日期改成LocalDate
                            ld = LocalDate.parse(dateinput);
                            FridgeDrawer fd = new FridgeDrawer(null,goods,minWeight,ld);
                            ctrl.setDrawer(i,j,fd);

                            /*Log.d("test",name);
                            Log.d("test",Float.toString(minWeight));
                            Log.d("test",Integer.toString(gt));
                            Log.d("test",dateinput);*/
                            Log.d("test","From controller:" + ctrl.fd[i][j].goods.g_Name);
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

        i = getIntent().getExtras().getInt("i");
        j = getIntent().getExtras().getInt("j");
        ctrl = (controller) getIntent().getSerializableExtra("ctrl");

        Log.d("test",Integer.toString(i));
        Log.d("test",Integer.toString(j));
        if(ctrl.fd[i][j] != null)   Log.d("test","From controller:" + ctrl.fd[i][j].goods.g_Name);
        else Log.d("test","ctrl.fd[0][0] == null");

        //進入畫面時設定初始數值
        if(ctrl.fd[i][j] != null)
        {
            t_name.setText("Name:"+ctrl.fd[i][j].goods.g_Name);
            t_minweight.setText("Minweight:"+Float.toString(ctrl.fd[i][j].minWeight));
            t_Date.setText("Date:"+ctrl.fd[i][j].Exdate.toString());
            t_Type.setText("Type:"+ctrl.fd[i][j].goods.g_Type.toString());
        }

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