package ua.edu.zntu.guidebook.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import ua.edu.zntu.guidebook.R;

import ua.edu.zntu.guidebook.async.TimetableAsyncTask;
import ua.edu.zntu.guidebook.enums.Period;

public class TimetableFragment extends Fragment{

    public final static String TAG = "TimetableFragmentTag";


    private View view;
    private TimetableAsyncTask asyncTask;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.timetable_layout, container, false);


        asyncTask = new TimetableAsyncTask(view);
        asyncTask.execute();

        return view;
    }


}
