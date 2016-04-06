package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.LinkedList;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.NewsListAdapter;
import ua.edu.zntu.guidebook.dto.NewsDTO;

public class NewsFragment extends Fragment {

    public static final String TAG = "NewsFragmentTag";
    private static final int LAYOUT = R.layout.new_news_layout;

    private View view;
    private WebView newsWebView;
    private FloatingActionButton fabRefresh;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getContext();
        view = inflater.inflate(LAYOUT, container, false);
        fabRefresh = (FloatingActionButton) view.findViewById(R.id.fabNewsRefresh);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new NewsListAdapter(createMockData()));

//        newsWebView = (WebView) view.findViewById(R.id.news_webview);
//        newsWebView.getSettings().setJavaScriptEnabled(true);
//        newsWebView.loadUrl("http://denisbogatirov.ho.ua/json.php");
//
//
//        fabRefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                newsWebView.reload();
//            }
//        });

        return view;
    }

    private LinkedList<NewsDTO> createMockData() {
        LinkedList<NewsDTO> news = new LinkedList<>();
        news.add(new NewsDTO("1"));
        news.add(new NewsDTO("2"));
        news.add(new NewsDTO("3"));
        news.add(new NewsDTO("4"));
        news.add(new NewsDTO("5"));
        news.add(new NewsDTO("6"));
        news.add(new NewsDTO("7"));
        news.add(new NewsDTO("8"));
        news.add(new NewsDTO("9"));
        news.add(new NewsDTO("10"));
        return news;
    }

}
