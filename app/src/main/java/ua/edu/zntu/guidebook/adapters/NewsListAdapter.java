package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.dto.NewsDTO;
import ua.edu.zntu.guidebook.dto.TodosDTO;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder>{

    private LinkedList<NewsDTO> news;
    private Context context;
    private final String URL = "http://denisbogatirov.ho.ua/";

    public NewsListAdapter(LinkedList<NewsDTO> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_layout, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.textTitle.setText(String.valueOf(news.get(position).getNewsTitle()));
        holder.textText.setText(news.get(position).getNewsText());
        Picasso.with(context).load(URL+news.get(position).getNewsLitteImg()).into(holder.imageView);
//        holder.imageView.setImageBitmap(news.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textTitle;
        TextView textText;
        ImageView imageView;

        public NewsHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.newsCardView);
            textTitle = (TextView) itemView.findViewById(R.id.newsTitle);
            textText = (TextView) itemView.findViewById(R.id.newsText);
            imageView = (ImageView) itemView.findViewById(R.id.newsImage);

        }
    }

}
