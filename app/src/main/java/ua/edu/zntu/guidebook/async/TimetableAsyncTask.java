package ua.edu.zntu.guidebook.async;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.enums.Period;


public class TimetableAsyncTask extends AsyncTask<Void, Integer, Void> {

    private Period currentPeriod ;

    private View fragmentView;

    //TMP
    TextView txt;

    private Date date ;
    private Calendar calendar;
    private int hours ;
    private int min ;

    private int time ;

    public TimetableAsyncTask(View fragmentView) {
        this.fragmentView = fragmentView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txt = (TextView) fragmentView.findViewById(R.id.textView);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        txt.setText(String.valueOf(values[0]));
    }

    @Override
    protected Void doInBackground(Void... params) {


        while (time<1270){

            date = new Date();// given date
            calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(date);   // assigns calendar to given date
            hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            min = calendar.get(Calendar.MINUTE); // gets min
            time = Integer.parseInt(String.valueOf(hours * 60 + min));

            currentPeriod = getCurrentPeriod(time);

            publishProgress(time);

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        return null;
    }

    private Period getCurrentPeriod(Integer time){

        if( time>510 && time<590 ) {
            return Period.FIRSTLESSON;
        }else

        if( time>605 && time<685 ){
            return Period.SECONDLESSON;
        }else

        if( time>715 && time<795 ){
            return Period.THIRDLESSON;
        }else

        if( time>805 && time<885 ){
            return Period.FOURTHLESSON;
        }else

        if( time>895 && time<975 ){
            return Period.FIFTHLESSON;
        }else

        if( time>1005 && time<1085 ){
            return Period.SIXTHLESSON;
        }else

        if( time>=1095 && time<=1175 ){
            return Period.SEVENTHLESSON;
        } else

        if( time>=1185 && time<=1265 ){
            return Period.EIGHTHLESSON;
        } else return Period.BREAK;
    }

}