package ru.mirea.dyachenkov.mireaproject.Fragments;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import ru.mirea.dyachenkov.mireaproject.R;

public class MusicPlayerWorker extends Worker {
    private MediaPlayer mediaPlayer;
    public MusicPlayerWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
        this.mediaPlayer = MediaPlayer.create(context, R.raw.duckbill);
    }

    @Override
    public Result doWork() {
        mediaPlayer.start();
        return Result.success();
    }
}
