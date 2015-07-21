package com.example.com.zntu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;


/**
 * Created by 1injener on 16.07.15.
 */
public class Class_Menu2 extends Activity {



    //Privet Push Commit Pull
 //   final Spinner DovSpinner = (Spinner)findViewById(R.id.DovidnikSp);



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin2);



        String[] data = {"one", "two", "three", "four", "five"};

        /** Called when the activity is first created. */
            // адаптер
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            Spinner spinner = (Spinner) findViewById(R.id.DovidnikSp);
            spinner.setAdapter(adapter);
            // заголовок
            spinner.setPrompt("Title");
            // выделяем элемент
            spinner.setSelection(2);
            // устанавливаем обработчик нажатия
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    // показываем позиция нажатого элемента
                    Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }
    }