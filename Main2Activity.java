package com.example.l.collections_of_java;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RelativeLayout r1;
    Spinner s;
    TextView t1,t2,t3;
    ArrayList<String> ar=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        s= (Spinner) findViewById(R.id.spi);
        r1= (RelativeLayout) findViewById(R.id.relative12);
        t1= (TextView) findViewById(R.id.tv1);
        t2= (TextView) findViewById(R.id.tv2);
        t3= (TextView) findViewById(R.id.tv3);
//       Intent intent=getIntent();
//        ar=intent.getStringArrayListExtra("mystring");
        try{
            BufferedReader input=null;
            File file=null;
            file=new File(getCacheDir(),"abc.txt");
            input=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer=new StringBuffer();
            while((line = input.readLine())!= null){
                buffer.append(line);
            }
//            String data=String.valueOf(buffer.append(line));
            t1.setText(buffer.toString());

            Toast.makeText(this, "read data", Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            e.printStackTrace();
        }
        Intent intent=getIntent();
        ar=intent.getStringArrayListExtra("mystring");
        final ArrayAdapter adp=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ar);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adp);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String data=s.getSelectedItem().toString();
                if(s.getSelectedItem().equals("java")){
//                    t1.setText("null");
                   t1.setText("java is object oriented programming language");

                }
                if(s.getSelectedItem().equals("php")){
//                    t2.setText("null");
                    t1.setText("php stands for hypertext preprocessor");
                }
                if(s.getSelectedItem().equals("android")){
//                    t3.setText("null");
                    t1.setText("android is open source");
                }

//                Toast.makeText(Main2Activity.this, "item is"+data, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        String data=s.getSelectedItem().toString();
//        Toast.makeText(this, "item is"+data, Toast.LENGTH_SHORT).show();



       }
}
