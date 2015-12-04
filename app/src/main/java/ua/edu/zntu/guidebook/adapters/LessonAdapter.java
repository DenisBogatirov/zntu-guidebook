package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.pojo.Lesson;

public class LessonAdapter extends BaseAdapter {

    private List<Lesson> lessonList;
    private LayoutInflater inflater;
    private Lesson currentLesson;
    private Context context;

    public LessonAdapter(Context context, List<Lesson> lessonList) {
        this.lessonList = lessonList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lessonList.size();
    }

    @Override
    public Object getItem(int position) {
        return lessonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lessonList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.listview_lesson_layout, parent, false);
        }

        Lesson lesson = getLesson(position);

        TextView lessonNumber_tv = (TextView) view.findViewById(R.id.lessonNumber_tv);
        TextView lessonTime_tv = (TextView) view.findViewById(R.id.lessonTime_tv);

        lessonNumber_tv.setText(lesson.getNumber());
        lessonTime_tv.setText(lesson.getTime());

        if(lesson == currentLesson){
            lessonNumber_tv.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
            lessonTime_tv.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        }

        else {

            lessonNumber_tv.setBackgroundColor(ContextCompat.getColor(context, R.color.mainBackground));
            lessonTime_tv.setBackgroundColor(ContextCompat.getColor(context, R.color.mainBackground));

        }

        return view;
    }

    private Lesson getLesson(int position){
        return (Lesson) getItem(position);
    }

    public void setCurrentLesson(int time){

            for (Lesson tmp : lessonList) {
                if (tmp.insideInterval(time)) {
                    currentLesson = tmp;
                    break;
                }
                else currentLesson = lessonList.get(8);
        }

        this.notifyDataSetChanged();
    }

    public Lesson getCurrentLesson() { return currentLesson; }

    public int getNextLesson(int time) {
        int nextLesson = 1440;
        for (Lesson tmp : lessonList)
            if (tmp.getStartInterval() > time && tmp.getStartInterval() < nextLesson)
                nextLesson = tmp.getStartInterval();
            else if (time > 1265) nextLesson = lessonList.get(0).getStartInterval();
        return nextLesson;
    }

}
