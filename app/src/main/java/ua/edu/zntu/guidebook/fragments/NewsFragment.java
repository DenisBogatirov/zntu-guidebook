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
import android.webkit.WebView;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
import ua.edu.zntu.guidebook.async.ParseTask;
import ua.edu.zntu.guidebook.dto.Example;
import ua.edu.zntu.guidebook.dto.NewsDTO;
import ua.edu.zntu.guidebook.dto.TodosDTO;

public class NewsFragment extends Fragment {

    public static final String TAG = "NewsFragmentTag";
    private static final int LAYOUT = R.layout.new_news_layout;
    public static final String LOG_TAG = "MyTAG";
    public static final String BASE_URL = "http://denisbogatirov.ho.ua/";


    private View view;
    private FloatingActionButton fabRefresh;
    private Context context;
    private RecyclerView rv;
    private LinkedList<TodosDTO> news = new LinkedList<>();


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

        getNews();

        return view;
    }


    private void setNews(LinkedList<TodosDTO> news) {
        this.rv.setAdapter(new NewsListAdapter(news));
    }

    private void getNews () {

        // --------RXJava Starts Here---------

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        ApiEndpointInterface apiService =
                retrofit.create(ApiEndpointInterface.class);

        Observable<LinkedList<Example>> call = apiService.getTodos();
        Subscription subscription = call
                .subscribeOn(Schedulers.io()) // optional if you do not wish to override the default behavior
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<LinkedList<Example>>() {
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
                    }

                    @Override
                    public void onNext(LinkedList<Example> todos) {
                        Log.d(LOG_TAG, "onNext");
//                        setNews(todos);
                        Log.d(LOG_TAG, todos.toString());
                    }
                });


        // --------RXJava Ends Here-----------

    }

}
