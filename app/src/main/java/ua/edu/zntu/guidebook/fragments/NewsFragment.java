package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.ConnectException;
import java.util.LinkedList;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.adapters.NewsListAdapter;
import ua.edu.zntu.guidebook.api.ApiConstants;
import ua.edu.zntu.guidebook.api.ApiEndpointInterface;
import ua.edu.zntu.guidebook.dto.NewsDTO;
import ua.edu.zntu.guidebook.ui.EndlessRecyclerViewScrollListener;

public class NewsFragment extends Fragment {

    public static final String TAG = "NewsFragmentTag";
    private static final int LAYOUT = R.layout.new_news_layout;
    public static final String LOG_TAG = "MyTAG";

    private View view;
    private FloatingActionButton fabRefresh;
    private Context context;
    private RecyclerView rv;
    private LinkedList<NewsDTO> news = new LinkedList<>();
    private RxJavaCallAdapterFactory rxAdapter;
    private Retrofit retrofit;
    private ApiEndpointInterface apiService;
    private Observable<LinkedList<NewsDTO>> request;
    private Subscription subscription;
    private LinearLayoutManager linearLayoutManager;
    private NewsListAdapter newsListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getContext();
        view = inflater.inflate(LAYOUT, container, false);
        linearLayoutManager = new LinearLayoutManager(context);
        fabRefresh = (FloatingActionButton) view.findViewById(R.id.fabNewsRefresh);
        newsListAdapter = new NewsListAdapter(news, context);

        rv = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(newsListAdapter);
        rv.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                // fetch data here
                getNews(totalItemsCount);


            }
        });

        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNews(newsListAdapter.getItemCount());
            }
        });

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        retrofit = new Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build();
        apiService = retrofit.create(ApiEndpointInterface.class);

        getNews(0);
        return view;
    }


    private void setNews(LinkedList<NewsDTO> news) {
            newsListAdapter.addItems(news);
            newsListAdapter.notifyDataSetChanged();
    }

    private void getNews(int offset) {

        // --------RXJava Starts Here---------

        request = apiService.getTodos(offset).cache();

        subscription = request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LinkedList<NewsDTO>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        // cast to retrofit.HttpException to get the response code
                        if (e instanceof HttpException) {
                            HttpException response = (HttpException) e;
                            int code = response.code();
                            Log.e(LOG_TAG, String.valueOf(code));
                        }
                        else if (e instanceof ConnectException){
                            Snackbar.make(view, "Неможливо оновити новини", Snackbar.LENGTH_LONG).show();
                        }
                            e.printStackTrace();

                    }

                    @Override
                    public void onNext(LinkedList<NewsDTO> result) {
                        setNews(result);
                    }
                });


        // --------RXJava Ends Here-----------

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
