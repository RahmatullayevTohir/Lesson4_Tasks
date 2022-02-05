package com.example.lesson4_tasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson4_tasks.objects.User;

public class MainActivity extends AppCompatActivity {
    TextView textView_home;
    int LAUNCH_DETAIL =1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViews2();
        initViews3();
    }

    private void initViews() {
        Button b_export_name = findViewById(R.id.b_export_name);

//        b_export_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openSecondActivity();
//            }
//        });

    }



    void initViews2(){
        Button b_export_object = findViewById(R.id.b_export_object);
        b_export_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(22,"Rahmatullayev Tohir");
                openSecondActivity1(user);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==LAUNCH_DETAIL){
            if (requestCode == Activity.RESULT_OK){
                String text = data.getStringExtra("result");
                textView_home.setText(text);
            }
        }
    }

    void openSecondActivity3(User user){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("user", user);
        startActivityForResult(intent,LAUNCH_DETAIL);

    }

    void initViews3(){
        Button button = findViewById(R.id.b_export_user);
        textView_home = findViewById(R.id.tv_home);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user  = new User(22,"Tohir");
                openSecondActivity3(user);
            }
        });
    }
//    void openSecondActivity(){
//        Intent intent1 = new Intent(this,SecondActivity.class);
//        intent1.putExtra("name","Rahmatullayev Tohir");
//        startActivity(intent1);
//    }

    void openSecondActivity1(User user){
        Intent intent2 = new Intent(this, SecondActivity.class);
        intent2.putExtra("user",user);
        startActivity(intent2);
    }
}