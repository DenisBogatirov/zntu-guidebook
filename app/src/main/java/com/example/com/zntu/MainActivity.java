package com.example.com.zntu;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;



/*

Intent myIntent = new Intent(Intent.ACTION_CALL, Uri.parse(“tel:” + Contacts_Phone));
myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(myIntent);

 */



public class MainActivity extends Activity implements View.OnClickListener {
    int mCounter;
    int flag_dzin;

    ImageButton btnZntu;
    ImageButton btnCall;
    ImageButton btnFnd;
    ImageButton btnUnn;

    String line = "0";
    String saved = "0";

    private static final int NOTIFY_ID = 101;
    public static final String APP_PREFERENCES = "ZNTU_settings";
    SharedPreferences sPref;
    public String APP_PREFERENCES_COUNTER = "news_id";
    public String APP_PREFERENCES_DZIN = "ZNTU_dzin_dzin"; //с юморком)


    public boolean ItemClick(int id) {
        switch (id) {
            case R.id.Menu1:
                Intent intent = new Intent(MainActivity.this, Class_Menu1.class);
                startActivity(intent);
                break;

            case R.id.Menu2:
                Intent intent2 = new Intent(MainActivity.this, Class_Menu2.class);
                startActivity(intent2);
                break;

            default:
                Toast.makeText(MainActivity.this, "ЕПТВАЮ", Toast.LENGTH_SHORT).show();
                // return super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menus) {
        getMenuInflater().inflate(R.menu.menu_main, menus);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ItemClick(id);
        return true;
    }


    protected void onStart() {
        super.onStart();
        //   Timer timer = new Timer();
        //   timer.schedule(new UpdateTimeTask(),0,7000);

        //           Toast.makeText(this, "ID Сохранен", Toast.LENGTH_SHORT).show();
    }

    protected void onPause() {
        super.onPause();


        //  Toast.makeText(this,"СОХРАНЕННый ID "+ saved, Toast.LENGTH_SHORT).show();

        // Запоминаем данные
 /*
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(DZIN_FLAG, 7777777);
        editor.apply(); */
    }

    @Override
    protected void onResume() {
        super.onResume();

     /*  if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            // Получаем число из настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
            // Выводим на экран данные из настроек
            Toast.makeText(getApplicationContext(),"Записанное "+ mCounter,
                    Toast.LENGTH_LONG).show();
        }   */
    }


    public void onCreate(Bundle savedInstanceState) {

        sPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        Timer timer = new Timer();
        timer.schedule(new UpdateTimeTask(), 0, 10000);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        btnZntu = (ImageButton) findViewById(R.id.btnZntu);
        btnZntu.setOnClickListener(this);
        btnCall = (ImageButton) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);
        btnFnd = (ImageButton) findViewById(R.id.btnFnd);
        btnFnd.setOnClickListener(this);
        btnUnn = (ImageButton) findViewById(R.id.btnUnn);
        btnUnn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZntu:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.zntu.edu.ua")));
                break;
            case R.id.btnCall:
                //  Toast.makeText(MainActivity.this, "Later", Toast.LENGTH_SHORT).show();

                Intent intent0 = new Intent(MainActivity.this, dzvonic.class);
                startActivity(intent0);

                break;
            case R.id.btnUnn:

                Intent intent3 = new Intent(MainActivity.this, web_lay.class);
                startActivity(intent3);

                break;
            case R.id.btnFnd:
                Intent intent = new Intent(MainActivity.this, FindActivity.class);
                startActivity(intent);
                break;
        }
    }


    private class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    try {
                        BufferedReader in = null;
                        //   String data = null;
                        HttpClient httpclient = new DefaultHttpClient();
                        HttpGet request = new HttpGet();

                        URI website = new URI("http://1injener.ru/id_news");
                        request.setURI(website);
                        HttpResponse response = httpclient.execute(request);
                        in = new BufferedReader(new InputStreamReader(
                                response.getEntity().getContent()));
                        line = in.readLine();


                        sPref = getPreferences(MODE_PRIVATE);
                        saved = sPref.getString(APP_PREFERENCES_COUNTER, "0");


                        if (saved.equals(line)) {
                            //  Toast.makeText(getApplicationContext(), "НЕТУ ОБНОВЛЕНИЙ", Toast.LENGTH_LONG).show();
                        } else {

                            Toast.makeText(getApplicationContext(), "Новини Профкому студентів ЗНТУ", Toast.LENGTH_LONG).show();

                            sPref = getPreferences(MODE_PRIVATE);
                            SharedPreferences.Editor ed = sPref.edit();
                            ed.putString(APP_PREFERENCES_COUNTER, line);
                            ed.apply();


                            Context context = getApplicationContext();

                            Intent notificationIntent = new Intent(context, MainActivity.class);
                            PendingIntent contentIntent = PendingIntent.getActivity(context,
                                    0, notificationIntent,
                                    PendingIntent.FLAG_CANCEL_CURRENT);

                            Resources res = context.getResources();
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

                            builder.setContentIntent(contentIntent)
                                    .setSmallIcon(R.drawable.zntu_notif)
                                            // большая картинка
                                            // .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.zntu_notif))
                                            //   .setTicker(res.getString(R.string.warning)) // текст в строке состояния
                                    .setTicker("Профком студентів ЗНТУ - Новини")
                                    .setWhen(System.currentTimeMillis())
                                    .setAutoCancel(true)
                                            //.setContentTitle(res.getString(R.string.notifytitle)) // Заголовок уведомления
                                    .setContentTitle("Профком студентів")
                                            //.setContentText(res.getString(R.string.notifytext))
                                    .setContentText("Оновлення новин на сайті Профкому"); // Текст уведомленимя

                            //Notification notification = builder.getNotification(); // до API 16
                            Notification notification = builder.build();

                            NotificationManager notificationManager = (NotificationManager) context
                                    .getSystemService(Context.NOTIFICATION_SERVICE);
                            notificationManager.notify(NOTIFY_ID, notification);

                            MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.zvuk_omg);
                            mp.start();
                        }

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Помилка завантаження Новин", Toast.LENGTH_SHORT).show();
                        Log.e("log_tag", "Error in http connection " + e.toString());
                    }


                }
            });


        }

    }
}