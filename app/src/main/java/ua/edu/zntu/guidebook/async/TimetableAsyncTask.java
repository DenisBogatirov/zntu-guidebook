package ua.edu.zntu.guidebook.async;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.LessonAdapter;
import ua.edu.zntu.guidebook.pojo.Lesson;


public class TimetableAsyncTask extends AsyncTask<Void, Integer, Void> {

    private int currentPeriod ;

    private View fragmentView;
    private Context context;

    private ListView lessonListView;
    private LessonAdapter lessonAdapter;

    private Date date ;
    private Calendar calendar;
    private int hours ;
    private int min ;

    private int time ;

    public TimetableAsyncTask(View fragmentView, Context context) {
        this.fragmentView = fragmentView;
        this.context = context;
        lessonAdapter = new LessonAdapter(context, initData());
    }


    private List<Lesson> initData(){
        List<Lesson> list = new ArrayList<>();

        list.add(new Lesson(1, "1 пара", "08:30 - 09:50"));
        list.add(new Lesson(2, "2 пара", "10:05 - 11:25"));
        list.add(new Lesson(3, "3 пара", "11:55 - 13:15"));
        list.add(new Lesson(4, "4 пара", "13:25 - 14:45"));
        list.add(new Lesson(5, "5 пара", "14:55 - 16:15"));
        list.add(new Lesson(6, "6 пара", "16:45 - 18:05"));
        list.add(new Lesson(7, "7 пара", "18:15 - 19:35"));
        list.add(new Lesson(8, "8 пара", "19:45 - 21:05"));
        list.add(new Lesson(9, " ", "Перерва"));

        return list;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        lessonListView = (ListView) fragmentView.findViewById(R.id.timetable_listView);
        lessonListView.setAdapter(lessonAdapter);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        lessonAdapter.setNow(values[0]);

    }

    @Override
    protected Void doInBackground(Void... params) {



        while (time<1440){

            date = new Date();// given date
            calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(date);   // assigns calendar to given date
            hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            min = calendar.get(Calendar.MINUTE); // gets min
            time = Integer.parseInt(String.valueOf(hours * 60 + min));


            if( time>510 && time<590 ) {
                currentPeriod = 0;
            }else

            if( time>605 && time<685 ){
                currentPeriod = 1;
            }else

            if( time>715 && time<795 ){
                currentPeriod = 2;
            }else

            if( time>805 && time<885 ){
                currentPeriod = 3;
            }else

            if( time>895 && time<975 ){
                currentPeriod = 4;
            }else

            if( time>1005 && time<1085 ){
                currentPeriod = 5;
            }else

            if( time>=1095 && time<=1175 ){
                currentPeriod = 6;
            } else

            if( time>=1185 && time<=1265 ){
                currentPeriod = 7;
            } else currentPeriod = 8;

            publishProgress(currentPeriod);


                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        return null;
    }
}