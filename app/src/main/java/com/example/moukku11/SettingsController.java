package com.example.moukku11;


import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsController{

    private static SettingsController controller = new SettingsController();

    private int font_size;
    private int text_color;
    private String text_gravity;
    private int text_heigth;
    private String inputString;
    TextView textView;
    EditText editText;


    private SettingsController(){

    }

    public static SettingsController getInstance(){
        return controller;
    }

    public int getFont_size(){
        return font_size;
    }

    public int getText_height() {
        return text_heigth;
    }

    public int getText_color(){
        return text_color;
    }

    public String getInputString(){
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
        textView.setText(this.inputString);
    }

    public void setText_Style(String text_style){

        if(text_style.equals("normal")){
            textView.setTypeface(Typeface.DEFAULT);

        }
        if(text_style.equals("bold")){
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }

    }

    public void setText_color(int text_color) {
        textView.setTextColor(text_color);
        this.text_color = text_color;
        // Black 0xff000000
        //Blue 0xff0000ff
        //Green 0xff00ff00
    }

    public void set_Text_View(TextView textView){
        this.textView = textView;

    }

    public void set_Edit_Text(EditText editText){
        this.editText = editText;
    }

    public void setText_CapsLock(String text_caps) {
        if(text_caps.equals("CapsOn")){
            textView.setAllCaps(true);
        }
        if(text_caps.equals("CapsOff")){
            textView.setAllCaps(false);
        }
    }
    public void setFont_size(int font_size) {
        textView.setTextSize(font_size);
        this.font_size = font_size;
    }

    public void textEditONorOFF(Boolean s){
        System.out.println(s + "jsjejfrjgor");
        if(s){
            editText.setFocusableInTouchMode(true);
            editText.setEnabled(true);
            editText.setHint("Writeable");
            textView.setText("Writeable");

        }
        else {
            editText.setFocusable(false);
            editText.setEnabled(false);
            textView.setText(editText.getText());
            //editText.setText("");
            editText.setText("Writeable");

        }
        }
}
