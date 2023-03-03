package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView2);
        button=findViewById(R.id.button2);
        Intent i=getIntent();
        int r=getRandom();
        String usn=i.getStringExtra("lucky");
        Toast.makeText(MainActivity2.this,"Hello "+usn,Toast.LENGTH_SHORT).show();
        textView.setText(""+r);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(usn,r);
            }
        });
    }
    public void shareData(String usn,int rnd)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,usn+" got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"Rohit's Lucky number is "+rnd);
        startActivity(Intent.createChooser(
                i,"Choose a platform"
        ));
    }
    public int getRandom(){
        Random r=new Random();
        int num=r.nextInt(1000);
        return num;
    }
}