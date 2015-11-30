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

    private static TimetableAsyncTask instance;

    public static TimetableAsyncTask getInstance(View fragmentView, Context context) {

        setFragmentView(fragmentView);
        setContext(context);
        lessonAdapter = new LessonAdapter(context, initData());
        lessonListView = (ListView) fragmentView.findViewById(R.id.timetable_listView);
        lessonListView.setAdapter(lessonAdapter);

        if (instance == null || instance.isCancelled()) {

            instance = new TimetableAsyncTask();
            instance.execute();
        }

        return instance;
    }

    private static View fragmentView;
    private static Context context;

    private static ListView lessonListView;
    private static LessonAdapter lessonAdapter;

    private Date date ;
    private Calendar calendar;
    private int hours ;
    private int min ;

    private int time ;

    private static List<Lesson> initData(){
        List<Lesson> list = new ArrayList<>();

        list.add(new Lesson(1, 510, 590, "1 пара", "08:30 - 09:50"));
        list.add(new Lesson(2, 605, 685, "2 пара", "10:05 - 11:25"));
        list.add(new Lesson(3, 715, 795, "3 пара", "11:55 - 13:15"));
        list.add(new Lesson(4, 805, 885, "4 пара", "13:25 - 14:45"));
        list.add(new Lesson(5, 895, 975, "5 пара", "14:55 - 16:15"));
        list.add(new Lesson(6, 1005, 1085, "6 пара", "16:45 - 18:05"));
        list.add(new Lesson(7, 1095, 1175, "7 пара", "18:15 - 19:35"));
        list.add(new Lesson(8, 1185, 1265, "8 пара", "19:45 - 21:05"));
        list.add(new Lesson(9, 0, 0, " ", "Перерва"));

        return list;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        lessonAdapter.getCurrentLesson(values[0]);

    }

    @Override
    protected Void doInBackground(Void... params) {

        while (time<1440 ){


            if (isCancelled()){
                return null;
            }

            date = new Date();// given date
            calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(date);   // assigns calendar to given date
            hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
            min = calendar.get(Calendar.MINUTE); // gets min
            time = Integer.parseInt(String.valueOf(hours * 60 + min));

            publishProgress(time);


                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        return null;
    }

    public static void setFragmentView(View fragmentView) {
        TimetableAsyncTask.fragmentView = fragmentView;
    }

    public static void setContext(Context context) {
        TimetableAsyncTask.context = context;
    }

    public static void cancel(){
        instance.cancel(false);
    }
}