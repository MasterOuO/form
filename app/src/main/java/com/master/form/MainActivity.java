package com.master.form;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,mail,bir,schoolinput;
    Spinner spinner;
    String ge="男性";
    final String[] school = {"大同大學", "台灣大學", "師大附中", "文化大學", "其他"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        mail=findViewById(R.id.mail);
        bir=findViewById(R.id.bir);
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.rgGender);
        spinner = findViewById(R.id.spinner);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                ge=radioButton.getText().toString();
                //tvMessage.setText(radioButton.getText());
            }
    });


        ArrayAdapter<String> lunchList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, school);
        spinner.setAdapter(lunchList);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                schoolinput = findViewById(R.id.schoolinput);
                int pos = spinner.getSelectedItemPosition();
                if(pos==4) schoolinput.setVisibility(View.VISIBLE);
                else schoolinput.setVisibility(View.INVISIBLE);
                //Toast.makeText(MainActivity.this, "您選擇了:" + lunch[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        schoolinput = findViewById(R.id.schoolinput);
        int pos = spinner.getSelectedItemPosition();
        if(pos==4) schoolinput.setVisibility(View.VISIBLE);
        else schoolinput.setVisibility(View.INVISIBLE);
        //inputMethodManager m = (InputMethodManager) super.getSystemService(Context.INPUT_METHOD_SERVICE);
        // super .hideSoftInputFromWindow(xxxx.getWindowToken(), 0);
        //view=findViewById(R.id.one);
        //view2=findViewById(R.id.two);
    }

    //private AccessibilityService mContext;

    public void clk(View view){
        int pos = spinner.getSelectedItemPosition();
        //Intent intent = new Intent();
        Intent intent = new Intent(this, second.class);
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("gender",ge);
        intent.putExtra("bir",bir.getText().toString());
        intent.putExtra("phone",phone.getText().toString());
        intent.putExtra("mail",mail.getText().toString());
        if(pos==4)
            intent.putExtra("school",schoolinput.getText().toString());
         else
             intent.putExtra("school",school[pos]);
        startActivity(intent);
    }

}
