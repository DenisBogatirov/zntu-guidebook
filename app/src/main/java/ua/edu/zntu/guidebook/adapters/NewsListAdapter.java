package ua.edu.zntu.guidebook.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.dto.NewsDTO;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder>{

    private LinkedList<NewsDTO> news;
    private Context context;
    public static final String LOG_TAG = "MyTAG";

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

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        int originalWidth = news.get(position).getNewsImgWidth();
        int originalHeight = news.get(position).getNewsImgHeight();
        float cardViewWidth = metrics.widthPixels - 20*metrics.density;
        float coefficient;
        int width;
        int height;

        coefficient = cardViewWidth/originalWidth ;

        width = (int) (originalWidth * coefficient + 1);
        height = (int) (originalHeight * coefficient);

        holder.imageView.setMinimumHeight(height);

        Glide.with(context).load(news.get(position).getNewsLitteImg())
                .override(width, height)
                .fitCenter()
                .into(holder.imageView);
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

    public void addItems(LinkedList<NewsDTO> news){
        for (NewsDTO obj : news){
            if(!this.news.contains(obj)) {
                this.news.add(obj);
            }
        }
    }

    public void reset(){
        this.news.clear();
    }

}
