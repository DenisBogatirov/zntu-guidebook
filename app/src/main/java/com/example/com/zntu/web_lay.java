package com.example.com.zntu;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
/**
 * Created by 1injener on 16.04.15.
 */

public class web_lay  extends Activity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_lay);

        WebView mWebView = (WebView) findViewById(R.id.webViewPKS);
        mWebView.getSettings().setJavaScriptEnabled(true);
        this.setTitle("WebView");
        mWebView.loadUrl("http://pks-zntu.org.ua/NewsPKS/index.php");
    }


    public void reload_web(View view) {
    WebView mWebView = (WebView) findViewById(R.id.webViewPKS);
    mWebView.reload();
    }


    }


