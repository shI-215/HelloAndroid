package com.tcom.helloandroid;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//AppCompatActivity——向下兼容，最低兼容到Android2.1（AppCompatActivity是Activity的子类）
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_web;
    private Button btn_phone;
    private ImageView image;
    private ProgressBar progressbar;
    private Button add;
    private Button delete;
    private Button flush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//通过setContentView引入activity_main布局
        initView();
//        Intent intent = new Intent(MainActivity.this, MainActivity.class);
//        startActivityForResult(intent, 1);

//        Intent intent = new Intent();
//        intent.putExtra("result", "hello");
//        setResult(RESULT_OK, intent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case 1:
//                if (requestCode==RESULT_OK){
//                    String result=data.getStringExtra("result");
//                }
//                break;
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hello_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hello_item_01:
                Toast.makeText(MainActivity.this, "Hello-Item-01", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hello_item_02:
                Toast.makeText(MainActivity.this, "Hello-Item-02", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hello_item_03:
                Toast.makeText(MainActivity.this, "Hello-Item-03", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        btn_web = (Button) findViewById(R.id.btn_web);
        btn_phone = (Button) findViewById(R.id.btn_phone);
        image = (ImageView) findViewById(R.id.image);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        flush = (Button) findViewById(R.id.flush);

        btn_web.setOnClickListener(this);
        btn_phone.setOnClickListener(this);
//        image.setImageResource(R.drawable.ic_launcher_background);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        flush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_web:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.btn_phone:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
                break;
            case R.id.add:
                int progress = progressbar.getProgress();
                progress = progress + 5;
                progressbar.setProgress(progress);
                break;
            case R.id.delete:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("警告");
                dialog.setMessage("确定删除吗？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("取消", null);
                dialog.show();
                break;
            case R.id.flush:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("请稍后");
                progressDialog.setMessage("加载中。。。");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
        }
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent();
//        intent.putExtra("result", "hello");
//        setResult(RESULT_OK, intent);
//    }
}
