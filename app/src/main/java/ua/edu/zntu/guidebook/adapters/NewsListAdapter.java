package ua.edu.zntu.guidebook.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.dto.NewsDTO;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder>{

    private LinkedList<NewsDTO> news;

    public NewsListAdapter(LinkedList<NewsDTO> news) {
        this.news = news;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_layout, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.textTitle.setText(news.get(position).getTitle());
        holder.textText.setText(news.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textTitle;
        TextView textText;

        public NewsHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.newsCardView);
            textTitle = (TextView) itemView.findViewById(R.id.newsTitle);
            textText = (TextView) itemView.findViewById(R.id.newsText);

        }
    }

}
