package com.example.com.zntu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * Created by 1injener on 16.07.15.
 */
public class Class_Menu2 extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin2);


        // Получаем экземпляр элемента Spinner
        final Spinner spinner_lay = (Spinner)findViewById(R.id.DovidnikSp);

// Настраиваем адаптер
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.TelephoneList, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Вызываем адаптер
        spinner_lay.setAdapter(adapter);


    }




    }




