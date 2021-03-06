package com.example.com.zntu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by 1injener on 16.07.15.
 */
public class Class_Menu2 extends Activity {
    private static final String TAG = "myLogs";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin2);

        final ListView listView_Dovidka = (ListView)findViewById(R.id.listViewDovidka);



        listView_Dovidka.setVisibility(View.VISIBLE);

// определяем массив типа String
        final String[] catnames = getResources().getStringArray(R.array.TelephoneList);
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, catnames);
        listView_Dovidka.setAdapter(adapter);

        listView_Dovidka.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Log.d(TAG, "itemClick: position = " + id);
               Intent intent = new Intent(Class_Menu2.this, Class_Menu2_Sub.class);

                String ListPos = position + "";

                intent.putExtra("txtPoz", ListPos);
               startActivity(intent);


            }
        });
    }
}
