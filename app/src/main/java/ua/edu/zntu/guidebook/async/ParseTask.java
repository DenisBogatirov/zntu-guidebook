package ua.edu.zntu.guidebook.async;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import ua.edu.zntu.guidebook.dto.NewsDTO;

public class ParseTask extends AsyncTask<Void, Void, LinkedList<NewsDTO>> {

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    LinkedList<NewsDTO> listNewsDTO = new LinkedList<>();

    @Override
    protected LinkedList<NewsDTO> doInBackground(Void... params) {
        // получаем данные с внешнего ресурса
        try {
            URL url = new URL("http://denisbogatirov.ho.ua/json.json");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject dataJsonObj;
        JSONArray news;
        try {
            dataJsonObj = new JSONObject(resultJson);
            news = dataJsonObj.getJSONArray("news");


            for (int i = 0; i < news.length(); i++) {
                String title = news.getJSONObject(i).getString("title");
                String text = news.getJSONObject(i).getString("text");

                listNewsDTO.add(new NewsDTO(title, text));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        return listNewsDTO;
    }

    @Override
    protected void onPostExecute(LinkedList<NewsDTO> strJson) {
        super.onPostExecute(strJson);

    }
}
