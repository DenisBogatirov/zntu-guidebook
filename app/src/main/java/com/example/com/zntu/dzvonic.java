package com.example.com.zntu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 1injener on 14.04.15.
 */

public class dzvonic extends Activity {

    /*   sfg
    public boolean onCreateOptionsMenu(Menu menus) {
        getMenuInflater().inflate(R.menu.menu_main, menus);
        return true; ВОТ Я ЧТО ТО ИЗМЕНИЛ
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivity clMailn;
        clMailn.ItemClick(id);
        return true;
    }
кооментарий  віа
    */

     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_dzvonic);


         Date date = new Date();   // given date
         Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
         calendar.setTime(date);   // assigns calendar to given date
         int hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
         int min = calendar.get(Calendar.MINUTE); // gets min

         int time = Integer.parseInt(String.valueOf(hours*60+min));

         TextView peremena = (TextView) findViewById(R.id.textView15);

         if(time>510&&time<590) {
             TextView txt = (TextView) findViewById(R.id.textView7);
             txt.setBackgroundDrawable( getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if(time>605&&time<685){
             TextView txt = (TextView) findViewById(R.id.textView8);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if((time>715)&&(time<795)){
             TextView txt = (TextView) findViewById(R.id.textView14);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if((time>805)&&(time<885)){
             TextView txt = (TextView) findViewById(R.id.textView9);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if((time>895)&&(time<975)){
             TextView txt = (TextView) findViewById(R.id.textView10);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if((time>1005)&&(time<1085)){
             TextView txt = (TextView) findViewById(R.id.textView11);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         }else

         if((time>=1095) && (time<=1175)){
             TextView txt = (TextView) findViewById(R.id.textView12);
             txt.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         } else

         if((time>=1185)&&(time<=1265)){
             TextView txt = (TextView) findViewById(R.id.textView13);
             txt.setBackgroundDrawable( getResources().getDrawable(R.drawable.rounded_zvonic));
             peremena.setVisibility(View.INVISIBLE);
         } else
             peremena.setVisibility(View.VISIBLE);

    }

}


