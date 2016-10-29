package com.example.zsl.mycalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private RadioButton rb1,rb2;
    private Button bt;
    private TextView tv;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.weight);
        bt = (Button) findViewById(R.id.jisuan);
        rb1= (RadioButton) findViewById(R.id.man);
        rb2= (RadioButton) findViewById(R.id.woman);
        rg = (RadioGroup) findViewById(R.id.manwoman);
        tv = (TextView) findViewById(R.id.result);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerEvent();
    }
    private void registerEvent(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et1.getText().toString().trim().equals("")) {
                    StringBuffer sb = new StringBuffer();
                    sb.append("______评估结果______ \n");
                    if (rb1.isChecked()||rb2.isChecked()){
                        if (rb1.isChecked()) {
                            Double weight = Double.parseDouble(et1.getText().toString());
                            double total = 170 - (62 - weight) / 0.6;
                            sb.append("男性的标准身高:" + total + "cm");
                        } else {
                            Double weight = Double.parseDouble(et1.getText().toString());
                            double total = 158 - (52 - weight) / 0.5;
                            sb.append("女性的标准身高:" + total + "cm");
                        }
                    }else{
                        showMessage("请选择性别");
                    }
                    tv.setText(sb.toString());
                }else{
                    showMessage("请输入体重");
                }
            }
        });
    }
    private void showMessage(String a){
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("系统提示");
        alert.setMessage(a);
        alert.setButton(alert.BUTTON_NEGATIVE,"确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
