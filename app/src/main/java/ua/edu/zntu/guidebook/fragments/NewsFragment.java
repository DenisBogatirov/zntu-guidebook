package ua.edu.zntu.guidebook.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import ua.edu.zntu.guidebook.api.ApiEndpointInterface;
import ua.edu.zntu.guidebook.dto.TodosDTO;

public class NewsFragment extends Fragment {

    public static final String TAG = "NewsFragmentTag";
    private static final int LAYOUT = R.layout.new_news_layout;
    public static final String LOG_TAG = "MyTAG";
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";


    private View view;
    private FloatingActionButton fabRefresh;
    private Context context;
    private RecyclerView rv;
    private LinkedList<TodosDTO> news = new LinkedList<>();
    private RxJavaCallAdapterFactory rxAdapter;
    private Retrofit retrofit;
    private ApiEndpointInterface apiService;
    private Observable<LinkedList<TodosDTO>> request;
    private Subscription subscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getContext();
        view = inflater.inflate(LAYOUT, container, false);
        fabRefresh = (FloatingActionButton) view.findViewById(R.id.fabNewsRefresh);
        rv = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new NewsListAdapter(news));

        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNews();
            }
        });

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build();
        apiService = retrofit.create(ApiEndpointInterface.class);
        request = apiService.getTodos().cache();
        getNews();
        return view;
    }


    private void setNews(LinkedList<TodosDTO> news) {
        this.rv.setAdapter(new NewsListAdapter(news));
    }

    private void getNews () {

        // --------RXJava Starts Here---------

        subscription = request
                .subscribeOn(Schedulers.io()) // optional if you do not wish to override the default behavior
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<LinkedList<TodosDTO>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        // cast to retrofit.HttpException to get the response code
                        if (e instanceof HttpException) {
                            HttpException response = (HttpException) e;
                            int code = response.code();
                        }
                        Log.d(LOG_TAG,"Error");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(LinkedList<TodosDTO> result) {
                        Log.d(LOG_TAG, "onNext");
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
