package ua.edu.zntu.guidebook.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.webkit.WebView;

import ua.edu.zntu.guidebook.R;

public class NewsFragment extends Fragment {

    public static final String TAG = "NewsFragmentTag";
    private static final int LAYOUT = R.layout.news_layout;

    private View view;
    private WebView newsWebView;
    private FloatingActionButton fabRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);

        newsWebView = (WebView) view.findViewById(R.id.news_webview);
        newsWebView.getSettings().setJavaScriptEnabled(true);
        newsWebView.loadUrl("http://pks-zntu.org.ua/NewsPKS/index.php");

        fabRefresh = (FloatingActionButton) view.findViewById(R.id.fabRefresh);

        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsWebView.reload();
//                fabRefresh.startAnimation(AnimationUtils.loadAnimation(getContext() ,R.anim.fab_rotate));
            }
        });

        return view;
    }


}
