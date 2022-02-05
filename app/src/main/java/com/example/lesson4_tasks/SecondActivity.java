package com.example.lesson4_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson4_tasks.objects.User;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        initViews2();
    }

    private void initViews() {
        TextView textView = findViewById(R.id.tv_import_name);


        String name = getIntent().getStringExtra("name");

        textView.setText(name);
    }
    private void initViews2(){
        TextView tv_import_home = findViewById(R.id.tv_import_name);
        Button button = findViewById(R.id.b_export_user);
        TextView textView1 = findViewById(R.id.tv_iport_objects);

        User user = (User) getIntent().getSerializableExtra("user");
        textView1.setText(user.toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToFinish();
            }
        });
    }

    void backToFinish(){
        Intent resultIntent = new Intent(this,MainActivity.class);
        resultIntent.putExtra("result","Salom Dunyo");
        setResult(Activity.RESULT_OK,resultIntent);
        finish();
    }
}