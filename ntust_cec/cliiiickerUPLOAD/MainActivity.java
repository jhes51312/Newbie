package com.exa.cliiiicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView , textView2 , textView3, textView4;
    private CheckBox checkBox , checkBox2 , checkBox3;
    private RadioGroup radioGroup;
    private RadioButton radioButton , radioButton2 , radioButton3;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);

        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);

        spinner = (Spinner)findViewById(R.id.spinner);

        radioGroup.setOnCheckedChangeListener(radiogrouplisten);

        checkBox.setOnCheckedChangeListener(checklisten);
        checkBox2.setOnCheckedChangeListener(checklisten);
        checkBox3.setOnCheckedChangeListener(checklisten);

        String[]balls = new String[]{"basket","base","soccer","else"};

        ArrayAdapter<String>adapterballs = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,balls);
        adapterballs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterballs);
        spinner.setSelection(1,false);
        spinner.setOnItemSelectedListener(spinlisten);

    }

   private CheckBox.OnCheckedChangeListener checklisten = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

            int n = 0;
            String sum = "";
            String s1 = "", s2 = "", s3 = "";
            if (checkBox.isChecked()) {
                n++;
                s1 = checkBox.getText().toString() + " ";
            } else {
                s1 = "";
            }
            if (checkBox2.isChecked()) {
                n++;
                s2 = checkBox2.getText().toString() + " ";
            } else {
                s2 = "";
            }
            if (checkBox3.isChecked()) {
                n++;
                s3 = checkBox3.getText().toString() + " ";
            } else {
                s3 = "";
            }
            sum = s1 + s2 + s3;
            textView2.setText("how : " + sum + "and " + n + " .");
        }

    };
    private RadioGroup.OnCheckedChangeListener radiogrouplisten = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int p = radioGroup.indexOfChild((RadioButton) findViewById(i));
            int list = radioGroup.getChildCount();

            if(i == R.id.radioButton)
                textView3.setText(list + " no. " + (p+1)+" point "+radioButton.getText());
            else if(i == R.id.radioButton2)
                textView3.setText(list + " no. " + (p+1)+" point "+radioButton2.getText());
            else if(i == R.id.radioButton3)
                textView3.setText(list + " no. " + (p+1)+" point "+radioButton3.getText());
        }
    };

    private Spinner.OnItemSelectedListener spinlisten = new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?>parent, View View, int position, long id){
            String S = parent.getSelectedItem().toString();
            textView4.setText(S);
        }
        @Override
        public void onNothingSelected(AdapterView<?>parent){
            // TODO Auto-generated method stub
        }
    };
}
