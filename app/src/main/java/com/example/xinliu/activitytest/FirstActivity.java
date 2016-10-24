package com.example.xinliu.activitytest;

import android.content.Intent;
import android.net.Uri;
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
 * Created by xinliu on 2016/10/19.
 *
 * （1）销毁当前Activity
 * （2）点击按钮，弹出提示框
 * （3）显式跳转到另一个Activity
 *
 */

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮 销毁当前应用
                //finish();

                //点击按钮 弹出"you click button1 提示框"
                //Toast.makeText(FirstActivity.this, "You click button 1",Toast.LENGTH_SHORT).show();

                //显式启动SecondActivity
                //声明一个Intent引用 并初始化（传入两个参数，分别为上下文和要启动的activity）
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //把intent传入startActivity方法，启动SecondActivity
                //startActivity(intent);

                //隐式启动SecondActivity
                //传入一个url来启动SecondActivity
                //Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //每一个intent中只能有一个action，但可以有多个category，下面添加一个category
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //startActivity(intent);

                //隐式启动的另一种形式，调用其他应用，比如打开浏览器，进入baidu网页
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);

                //调用拨号程序，传入tel协议，号码为10086
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);

                //将字符串hello SecondAvtivity传递给SecondActivity,需要secondactivity配合，怎么配合，要在secondactivity中接收这个参数
                //用intent.getStringExtra("extra_data");来接收data
                //String data = "hello SecondAvtivity";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //startActivity(intent);

                //
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "you click add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you click remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
}
