package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.SectionInfoAdapter;
import ua.edu.zntu.guidebook.pojo.Section;

public class SectionInfoFragment extends Fragment {
    public static final String TAG = "SectionInfoFragmentTag";
    private static final int LAYOUT = R.layout.section_info_layout;

    private View view;
    private Context context;
    private Section section;
    private LinearLayoutManager linearLayoutManager;
    private SectionInfoAdapter sectionInfoAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getContext();
        view = inflater.inflate(LAYOUT, container, false);
        section = (Section) getArguments().getSerializable("Section");
        linearLayoutManager = new LinearLayoutManager(context);
        sectionInfoAdapter = new SectionInfoAdapter(section, context);

        recyclerView = (RecyclerView) view.findViewById(R.id.sectionRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(sectionInfoAdapter);

        return view;
    }
}
