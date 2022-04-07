package com.example.moukku11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
    Button applyChanges, writeButton;
    SettingsController controller = SettingsController.getInstance();
    HashMap<String, Integer> colors;
    EditText actv2Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        applyChanges = findViewById(R.id.apply);
        writeButton = findViewById(R.id.writableButton);
        actv2Text = findViewById(R.id.SettingsInput);



        String s1 [] = {"Default","10", "20","30", "40","50", "70"};
        String s2 [] = {"Default","Black", "Blue", "Green",};
        String s3 [] = {"Default","CapsOn", "CapsOff"};
        String s4 [] = {"Default", "bold", "normal"};
        String s5 [] = {"Finnish", "Swedish", "English"};

        spinnerMaker(spinner1, s1);
        spinnerMaker(spinner2, s2);
        spinnerMaker(spinner3, s3);
        spinnerMaker(spinner4, s4);
        spinnerMaker(spinner5,s5);

        colors = new HashMap<String, Integer>();
        colors.put("Black", 0xff000000);
        colors.put("Blue", 0xff0000ff);
        colors.put("Green", 0xff00ff00);


        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(writeButton.getText());
                if (writeButton.getText().equals("Write: off") == true){
                    controller.textEditONorOFF(false);
                    writeButton.setText("Write: on");
                    System.out.println(writeButton.getText());
                }
                else{
                    controller.textEditONorOFF(true);
                    writeButton.setText("Write: off");
                    System.out.println(writeButton.getText());

            }}
        });

    }


    public void spinnerMaker(Spinner spinner, String s []){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,s);
        spinner.setAdapter(arrayAdapter);

    }

    public void settingsChanges(View view){
        if(spinner1.getSelectedItem().toString().equals("Default") == false) {
            controller.setFont_size(Integer.parseInt(spinner1.getSelectedItem().toString()));
        }

        if(spinner2.getSelectedItem().toString().equals("Default") == false) {
            controller.setText_color(colors.get(spinner2.getSelectedItem().toString()));
        }

        if(spinner3.getSelectedItem().toString().equals("Default") == false) {
            controller.setText_CapsLock(spinner3.getSelectedItem().toString());
        }
        if(spinner4.getSelectedItem().toString().equals("Default") == false){
            controller.setText_Style(spinner4.getSelectedItem().toString());
        }
        if(actv2Text.getText().toString().isEmpty() == false){
            controller.setInputString(actv2Text.getText().toString());
        }
        actv2Text.setText("");

        Toast.makeText(MainActivity2.this, "Changes made!", Toast.LENGTH_SHORT).show();

    }


}