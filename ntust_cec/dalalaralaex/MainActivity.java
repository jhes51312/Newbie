package com.mple.dalalarala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDate , editTextNumber;
    private RadioGroup radioGroup;
    private RadioButton radioButton , radioButton2 , radioButton3;
    private TextView textView4;
    private Spinner spinner;
    private Button button , button2;
    private ArrayList<mItem> Record;
    int i = 0;
    String Time = "";
    String Item = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Record = new ArrayList<>();
            textView4 = (TextView)findViewById(R.id.textView4);
            editTextDate = (EditText)findViewById(R.id.editTextDate);
            editTextNumber = (EditText)findViewById(R.id.editTextNumber);
            button = (Button)findViewById(R.id.button);
            button2 = (Button)findViewById(R.id.button2);
            radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
            radioButton = (RadioButton)findViewById(R.id.radioButton);
            radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
            radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
            spinner = (Spinner)findViewById(R.id.spinner);

            ArrayAdapter<CharSequence>adaptermenus = ArrayAdapter.createFromResource(this, R.array.menus,android.R.layout.simple_spinner_dropdown_item);
            adaptermenus.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

            spinner.setAdapter(adaptermenus);
            spinner.setOnItemSelectedListener(spinnerlisten);

            radioGroup.setOnCheckedChangeListener(radioGrouplisten);
            button.setOnClickListener(btnlisten);
            button2.setOnClickListener(btnshlisten);

    }

    private RadioGroup.OnCheckedChangeListener radioGrouplisten = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {

        }

        public void onCheckChange(RadioGroup group, int checkID){

            if(checkID == R.id.radioButton)
                Time = radioButton.getText().toString();
            else if(checkID == R.id.radioButton2)
                Time = radioButton2.getText().toString();
            else if(checkID == R.id.radioButton3)
                Time = radioButton3.getText().toString();

        }
    };

    private Spinner.OnItemSelectedListener spinnerlisten = new Spinner.OnItemSelectedListener(){
@Override
        public void onItemSelected(AdapterView<?>parent, View view, int position, long id){
            Item = parent.getSelectedItem().toString();
        }
@Override
        public void onNothingSelected(AdapterView<?> parent){

        }

    };

    private  Button.OnClickListener btnlisten = new Button.OnClickListener(){

        @Override
        public void onClick(View view){

            i++;
            if(editTextDate.getText().toString().equals("")) {
                textView4.setText("Press Date");
            }
            else if(editTextNumber.getText().toString().equals("")) {
                textView4.setText("Press Price");
            }
            else{
                String date = editTextDate.getText().toString();
                int money = Integer.parseInt(editTextNumber.getText().toString());

                Record.add(new mItem(date, money, Time, Item));
                textView4.setText("");
                editTextDate.setText("");
                editTextNumber.setText("");

                }

        }

    };


     private Button.OnClickListener btnshlisten = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String result = "";

             for(int j=0; j<i; j++){
                 mItem str = Record.get(j);
                 result = result + " date: "+str.getRecordDate()+" , price: "+str.getRecordMoney()+" , time : "+str.getRecordTime()+" , list : "+str.getRecordType()+'\n';
             }
             textView4.setText(result);
         }
     };

}