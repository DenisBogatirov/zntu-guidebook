package com.example.com.zntu;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by 1injener on 16.07.15.
 */
public class Class_Menu2 extends Activity {


 //   final Spinner DovSpinner = (Spinner)findViewById(R.id.DovidnikSp);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin2);

    }

/*
        //Установка слушателя для выпадающего списка
        Spinner spinner = (Spinner) findViewById(R.id.DovidnikSp);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемента spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.TelephoneList, android.R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // Получаем выбранный объект
        Object item = parent.getItemAtPosition(pos);

        Toast.makeText(getApplicationContext(), item.toString(), Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Обработка события
    }


    */


    }




