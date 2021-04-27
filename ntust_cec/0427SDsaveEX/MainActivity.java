package com.ample.a0427sdsave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String [] login;
    private File filename;
    EditText editText1 , editText2;
    Button button1 , button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestStoragePermisiion();

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(btn1);
        button2.setOnClickListener(btn1);

    }

    private void requestStoragePermisiion() {
        if(Build.VERSION.SDK_INT >=23){
            int hasPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            if(hasPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                return;
            }
        }
        readFile();
    }
    //requestPermissions
    @Override
    public void onRequestPermissionsResult(int requestCode,String[]permissions,int[]grantResults){
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                readFile();
            }else{
                Toast.makeText(this,"no authority",Toast.LENGTH_SHORT).show();
                finish();
            }
        }else{
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

    private void readFile(){
        filename = new File("sdcard/test.txt");
        try{
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader((fin)));
            String line = "",wholedata ="";
            int i = 0;
            while((line=reader.readLine())!=null){
                wholedata = wholedata + line + "\n";
                i++;
            }
            login = wholedata.split("\n");
            reader.close();
            fin.close();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),"REEOE",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private Button.OnClickListener btn1 = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button1:
                    if(editText1.getText().toString().equals("")||
                       editText2.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"enter word stoipid",Toast.LENGTH_LONG).show();
                        break;
                    }
                    Boolean flag = false;
                    for(int i=0; i<login.length; i+=2){
                        if(editText1.getText().toString().equals(login[i])){
                            flag=true;
                            if(editText2.getText().toString().equals(login[i+1])){
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("LOGIN")
                                        .setMessage("LOGIN SUCcESS")
                                        .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i){
                                            finish();
                                        }
                                        })
                                        .show();
                            }else{
                                Toast.makeText(getApplicationContext(),"WRONG BEACH",Toast.LENGTH_SHORT).show();
                                editText2.setText("");
                                break;
                            }
                        }
                    }
                    if(!flag){
                        Toast.makeText(getApplicationContext(),"WRONG ACCOUNT",Toast.LENGTH_LONG).show();
                        editText1.setText("");
                        editText2.setText("");
                    }
                    break;

                case R.id.button2:
                    editText1.setText("");
                    editText2.setText("");
                    break;
            }
        }
    };

}