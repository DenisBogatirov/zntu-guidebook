package ua.edu.zntu.guidebook.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import ua.edu.zntu.guidebook.R;
import ua.edu.zntu.guidebook.activities.MainActivity;

public class NotificationService extends Service {

    private final int NOTIFICATION_ID = 100;

    public final String APP_PREFERENCES = "ZNTU_settings";
    public final String APP_PREFERENCES_COUNTER = "news_id";

    private HttpClient httpClient;
    private HttpGet request;
    private HttpResponse response;
    private BufferedReader in = null;
    private URI website;

    private NotificationManager nm;

    private String line;
    private String saved;
    private SharedPreferences sharedPreferences;


    private Thread aThread = null;

    public NotificationService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        httpClient = new DefaultHttpClient();
        request = new HttpGet();

        try {
            website = new URI("http://1injener.ru/id_news");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        checkNews();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    private void checkNews() {
       aThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    if (isOnline()) {

                        try {

                            in = null;

                            request.setURI(website);
                            response = httpClient.execute(request);
                            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                            line = in.readLine();

                            sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
                            saved = sharedPreferences.getString(APP_PREFERENCES_COUNTER, "0");

                        } catch (Exception e) {
                            e.printStackTrace();
                            line = saved;


                        }

                        if (!saved.equals(line)) {
                            showNotification();
                            SharedPreferences.Editor ed = sharedPreferences.edit();
                            ed.putString(APP_PREFERENCES_COUNTER, line);
                            ed.apply();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                }
            }

        });

        aThread.start();
    }

    public void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_stat_notification)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.ic_launcher))
                .setTicker(getString(R.string.notification_ticker))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text));

        Notification notification = builder.build();
        notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;

        nm.notify(NOTIFICATION_ID, notification);
    }

    public boolean isOnline() {

        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(cs);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
