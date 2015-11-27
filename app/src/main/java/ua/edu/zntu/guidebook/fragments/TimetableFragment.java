package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.activities.MainActivity;
import ua.edu.zntu.guidebook.enums.Period;

public class TimetableFragment extends Fragment{

    public final static String TAG = "TimetableFragmentTag";

    private Context context;
    private View view;
    private TimetableAsyncTask asyncTask;

    private TextView txt;

    private Date date ;
    private Calendar calendar;
    private int hours ;
    private int min ;

    private int time ;

    long sec ;


    public TimetableFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.timetable_layout, container, false);

        txt = (TextView) view.findViewById(R.id.textView);

        date = new Date();// given date


        asyncTask = new TimetableAsyncTask();
        asyncTask.execute();



        return view;
    }

    public class TimetableAsyncTask extends AsyncTask<Void, Long, Void> {





        int i =0;



        private Period currentPeriod ;




        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(context, "00", Toast.LENGTH_SHORT).show();





        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            txt.setText(String.valueOf(values[0]));
        }

        @Override
        protected Void doInBackground(Void... params) {

            while (i<100){

            calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(date);   // assigns calendar to given date
            hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            min = calendar.get(Calendar.MINUTE); // gets min
            time = Integer.parseInt(String.valueOf(hours * 60 + min));
            sec = Long.parseLong(String.valueOf(calendar.getTimeInMillis()));
            publishProgress(sec);

/*
        if(time>510&&time<590) {

        }else

        if(time>605&&time<685){

        }else

        if((time>715)&&(time<795)){

        }else

        if((time>805)&&(time<885)){

        }else

        if((time>895)&&(time<975)){

        }else

        if((time>1005)&&(time<1085)){

        }else

        if((time>=1095) && (time<=1175)){

        } else

        if((time>=1185)&&(time<=1265)){

        } else
*/


                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;}
            return null;
        }

    }
}
