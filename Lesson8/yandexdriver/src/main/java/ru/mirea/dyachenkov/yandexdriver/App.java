package ru.mirea.dyachenkov.yandexdriver;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final static String YANDEX_MAP_API_KEY = "262bb5cc-4618-45d1-b2d9-5dc6109c12bf";

    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey(YANDEX_MAP_API_KEY);
    }
}
