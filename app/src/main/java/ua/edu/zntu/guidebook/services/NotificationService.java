package ua.edu.zntu.guidebook.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.activities.MainActivity;

public class NotificationService extends Service {

    private final int NOTIFICATION_ID = 100;

    public final String APP_PREFERENCES = "ZNTU_settings";
    public final String APP_PREFERENCES_COUNTER = "news_id";

    private NotificationManager nm;

    private String line;
    private String saved;
    private SharedPreferences sharedPreferences;

    public NotificationService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        checkNews();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    private void checkNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    BufferedReader in = null;
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet request = new HttpGet();

                    URI website = new URI("http://1injener.ru/id_news");
                    request.setURI(website);
                    HttpResponse response = httpclient.execute(request);
                    in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    line = in.readLine();


                    sharedPreferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
                    saved = sharedPreferences.getString(APP_PREFERENCES_COUNTER, "0");


                    if (!saved.equals(line)){
                        showNotification();
                        SharedPreferences.Editor ed = sharedPreferences.edit();
                        ed.putString(APP_PREFERENCES_COUNTER, line);
                        ed.apply();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                stopSelf();
            }

        }).start();
    }

    public void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.ic_launcher))
                .setTicker("Got new News")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Some new f**** news")
                .setContentText("Check it");

        Notification notification = builder.build();

        nm.notify(NOTIFICATION_ID, notification);
    }
}
