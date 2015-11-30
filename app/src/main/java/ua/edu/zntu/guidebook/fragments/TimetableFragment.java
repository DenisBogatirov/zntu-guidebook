package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.async.TimetableAsyncTask;

public class TimetableFragment extends Fragment{

    public static final String TAG = "TimetableFragmentTag";
    private static final int LAYOUT = R.layout.timetable_layout;

    private View view;
    private TimetableAsyncTask asyncTask;
    private Context context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        context = getContext();


        asyncTask = TimetableAsyncTask.getInstance(view, context);

        return view;
    }
}
