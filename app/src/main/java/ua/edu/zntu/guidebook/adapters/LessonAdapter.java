package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.graphics.Color;
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

    public LessonAdapter(Context context, List<Lesson> lessonList) {
        this.lessonList = lessonList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public boolean areAllItemsEnabled() { return false; }

    @Override
    public boolean isEnabled(int position) { return false; }

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

            lessonNumber_tv.setBackgroundColor(Color.parseColor("#ffab40"));
            lessonTime_tv.setBackgroundColor(Color.parseColor("#ffab40"));
        }

        else {

            lessonNumber_tv.setBackgroundColor(Color.parseColor("#e2e2e2"));
            lessonTime_tv.setBackgroundColor(Color.parseColor("#e2e2e2"));

        }

        return view;
    }

    private Lesson getLesson(int position){
        return (Lesson) getItem(position);
    }

    public void getCurrentLesson(int time){

            for (Lesson tmp : lessonList) {
                if (tmp.insideInterval(time)) {
                    currentLesson = tmp;
                    break;
                }
                else currentLesson = lessonList.get(8);
        }
        this.notifyDataSetChanged();
    }
}