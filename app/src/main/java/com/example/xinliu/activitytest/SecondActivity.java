package com.example.xinliu.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
/**
 * Created by xinliu on 2016/10/21.
 */

public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);
        //用getStringExtra来接收传过来的data
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "hello firstactivity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    //通过点击回退键也可以传递数据，用onBackPressed
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return", "hello firstactivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
