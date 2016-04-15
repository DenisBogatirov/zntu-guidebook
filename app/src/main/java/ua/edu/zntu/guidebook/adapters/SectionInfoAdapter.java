package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.pojo.Person;
import ua.edu.zntu.guidebook.pojo.Section;

public class SectionInfoAdapter extends RecyclerView.Adapter<SectionInfoAdapter.SectionInfoHolder> {

    private LinkedList<View> sectionViews;
    private Context context;
    private static final int LAYOUT = R.layout.section_info_item;
    public static final String LOG_TAG = "MyTAG";

    public SectionInfoAdapter(Section section, Context context) {
        this.sectionViews = section.getViews(context);
        this.context = context;
    }

    @Override
    public SectionInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(LAYOUT, parent, false);


        return new SectionInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(SectionInfoHolder holder, int position) {

            holder.sectionLinearLayout.removeAllViews();
            holder.sectionLinearLayout.addView(sectionViews.get(position));

    }

    @Override
    public int getItemCount() {
        return sectionViews.size();
    }

    public static class SectionInfoHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        LinearLayout sectionLinearLayout;


        public SectionInfoHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.newsCardView);
            sectionLinearLayout = (LinearLayout) itemView.findViewById(R.id.sectionLinearLayout);

        }
    }
}
