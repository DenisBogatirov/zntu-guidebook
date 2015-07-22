package com.example.com.zntu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by 1injener on 16.07.15.
 */
public class Class_Menu2 extends Activity {
    ListView listView = (ListView)findViewById(R.id.listViewDovidka);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin2);


// определяем массив типа String
        final String[] catnames = getResources().getStringArray(R.array.TelephoneList);
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, catnames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), ((TextView)itemClicked).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });



    }





    }




