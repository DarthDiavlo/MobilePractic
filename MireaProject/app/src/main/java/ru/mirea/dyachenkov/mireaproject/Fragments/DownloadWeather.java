package ru.mirea.dyachenkov.mireaproject.Fragments;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ru.mirea.dyachenkov.mireaproject.MainActivity;
import ru.mirea.dyachenkov.mireaproject.R;

public class DownloadWeather extends AsyncTask<String, Void, String> {
    //https://api.open-meteo.com/v1/forecast?latitude=55.75&longitude=37.62&current_weather=true
    TextView time;
    TextView weather;
    TextView temperature;
    TextView windspeed;
    TextView winddirection;
    TextView day;
    public DownloadWeather(View view) {
        this.weather=view.findViewById(R.id.weather);
        this.time=view.findViewById(R.id.time);
        this.temperature=view.findViewById(R.id.temperature);
        this.windspeed=view.findViewById(R.id.windspeed);
        this.winddirection=view.findViewById(R.id.winddirection);
        this.day=view.findViewById(R.id.day);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        weather.setText("Загружаем...");
    }
    @Override
    protected String doInBackground(String... urls) {
        try {
            return downloadIpInfo(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
    @Override
    protected void onPostExecute(String result) {
        weather.setText("Результат");
        Log.d( MainActivity.class.getSimpleName(), result);
        try {
            JSONObject responseJson = new JSONObject(result);
            Log.d(MainActivity.class.getSimpleName(), "Response: " + responseJson);
            JSONObject currentWeather = responseJson.getJSONObject("current_weather");
            temperature.setText("temperature: " + currentWeather.getString("temperature"));
            windspeed.setText("windspeed: " + currentWeather.getString("windspeed"));
            time.setText("time: " + currentWeather.getString("time"));

            if(currentWeather.getString("is_day")=="1"){
                day.setText("День");
            }else {
                day.setText("Ночь");
            }
            winddirection.setText("winddirection: "+getWindDirection(Integer.parseInt(currentWeather.getString("winddirection"))));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(result);
    }

    private String downloadIpInfo(String address) throws IOException {
        InputStream inputStream = null;
        String data = "";
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(100000);
            connection.setConnectTimeout(100000);
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(true);
            connection.setUseCaches(false);
            connection.setDoInput(true);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                inputStream = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int read = 0;
                while ((read = inputStream.read()) != -1) {
                    bos.write(read);
                }
                bos.close();
                data = bos.toString();
            } else {
                data = connection.getResponseMessage() + ". Error Code: " + responseCode;
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return data;
    }
    public static String getWindDirection(int degrees) {
        if (degrees >= 0 && degrees < 45) {
            return "Северное";
        } else if (degrees >= 45 && degrees < 90) {
            return "Северо-Восточное";
        } else if (degrees >= 90 && degrees < 135) {
            return "Восточное";
        } else if (degrees >= 135 && degrees < 180) {
            return "Юго-Восточное";
        } else if (degrees >= 180 && degrees < 225) {
            return "Южное";
        } else if (degrees >= 225 && degrees < 270) {
            return "Юго-Западное";
        } else if (degrees >= 270 && degrees < 315) {
            return "Западное";
        } else if (degrees >= 315 && degrees < 360) {
            return "Северо-Западное";
        } else {
            return "Недопустимое значение градусов";
        }
    }
}
