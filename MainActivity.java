package com.example.l.collections_of_java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button dis;
    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText) findViewById(R.id.et1);
        e2= (EditText) findViewById(R.id.et2);
        e3= (EditText) findViewById(R.id.et3);
        e4= (EditText) findViewById(R.id.et4);
        e5= (EditText) findViewById(R.id.et5);
        dis= (Button) findViewById(R.id.disp);
//        String a1=e1.getText().toString();
//        String a2=e2.getText().toString();
//        String a3=e3.getText().toString();
//        final ArrayList<String> mylist=new ArrayList<String>();
//        mylist.add(a1);
//        mylist.add(a2);
//        mylist.add(a3);
        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a1=e1.getText().toString();
                String a2=e2.getText().toString();
                String a3=e3.getText().toString();
                String a4=e4.getText().toString();
                String a5=e5.getText().toString();

                final ArrayList<String> mylist=new ArrayList<String>();
                mylist.add(a1);
                mylist.add(a2);
                mylist.add(a3);
                mylist.add(a4);
                mylist.add(a5);
                File file=null;
                FileOutputStream fos=null;
                BufferedReader input=null;
                String content=String.valueOf(mylist);
                try{
                    file=new File(getCacheDir(),"abc.txt");
                    fos=new FileOutputStream(file);
                    fos.write(content.getBytes());
                    fos.close();
//                    FileOutputStream fos=openFileOutput("abc.txt",MODE_PRIVATE);
//                    OutputStreamWriter osw=new OutputStreamWriter(fos);
                    Toast.makeText(MainActivity.this, "data saved successfully", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    e.printStackTrace();
                }
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putStringArrayListExtra("mystring",mylist);
                startActivity(intent);

//                Toast.makeText(MainActivity.this,a1+a2+a3, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
