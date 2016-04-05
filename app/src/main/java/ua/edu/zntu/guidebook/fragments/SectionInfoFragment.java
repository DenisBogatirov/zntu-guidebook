package ua.edu.zntu.guidebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.pojo.Person;
import ua.edu.zntu.guidebook.pojo.Section;

public class SectionInfoFragment extends Fragment {
    public static final String TAG = "SectionInfoFragmentTag";
    private static final int LAYOUT = R.layout.linearlayout;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        LinearLayout list = (LinearLayout) view.findViewById(R.id.section_info);
        Section section = (Section) getArguments().getSerializable("Section");

        for (Person person : section.getPersons()) {
            list.addView(person.getPersonView(getContext()));
        }

        return view;
    }
}
