package com.example.com.zntu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by 1injener on 12.05.15.
 */
public class Class_Menu1 extends Activity implements
        CompoundButton.OnCheckedChangeListener {

    String  flag_dzinT;
    ToggleButton toogleButtonB;

    public static final String APP_PREFERENCES = "ZNTU_settings";
    public String APP_PREFERENCES_DZIN2 = "ZNTU_dzin_dzin"; //с юморком)
    SharedPreferences DZIN2;

    protected void onCreate(Bundle savedInstanceState) {
        DZIN2 = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dzin);

        toogleButtonB = (ToggleButton) findViewById(R.id.toggleButton);

 /*       if (DZIN2.contains(APP_PREFERENCES_DZIN2)) {
            flag_dzinT = DZIN2.getString(APP_PREFERENCES_DZIN2, "0");
            boolean mBoolT = true;
            boolean mBoolF = false;
            String one="1";

            if (one.equals(flag_dzinT)){ toogleButtonB.setChecked(mBoolF);
            } else
            {
                toogleButtonB.setChecked(mBoolT);
            }
        }
*/
        toogleButtonB.setOnCheckedChangeListener(this);

    }


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            DZIN2 = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed1 = DZIN2.edit();
            ed1.putString(APP_PREFERENCES_DZIN2, "1");
            ed1.apply();

            DZIN2 = getPreferences(MODE_PRIVATE);
           String saved = DZIN2.getString(APP_PREFERENCES_DZIN2, "0");

           Toast.makeText(getApplicationContext(), "Сповіщення Вимкнено" , Toast.LENGTH_SHORT).show();
        }
        else {
            DZIN2 = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = DZIN2.edit();
            ed.putString(APP_PREFERENCES_DZIN2, "0");
            ed.apply();

            DZIN2 = getPreferences(MODE_PRIVATE);
            String saved = DZIN2.getString(APP_PREFERENCES_DZIN2, "0");

           Toast.makeText(getApplicationContext(), "Сповіщення Активовано" , Toast.LENGTH_SHORT).show();
        }
    }
}
