package ua.edu.zntu.guidebook.async;


import android.os.AsyncTask;
import android.os.SystemClock;

public class TimetableAsyncTask extends AsyncTask<Void, Integer, Void>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... params) {

        SystemClock.sleep(10000);
        return null;
    }
}
