package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.pojo.Section;


public class SectionAdapter extends BaseAdapter {

    private List<Section> sectionList;
    private LayoutInflater inflater;
    private Context context;
    private Section section;

    private TextView sectionTitle;

    public SectionAdapter(List<Section> sectionList, Context context) {
        this.sectionList = sectionList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sectionList.size();
    }

    @Override
    public Object getItem(int position) {
        return sectionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sectionList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_section_layout, parent, false);
        }

        section = (Section) getItem(position);
        sectionTitle = (TextView) convertView.findViewById(R.id.sectionTitle);

        sectionTitle.setText(section.getTitle());

        return convertView;
    }
}
