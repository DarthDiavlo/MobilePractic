package ru.mirea.dyachenkov.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.mirea.dyachenkov.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("runOnUiThread(Runnable action): Этот метод используется для выполнения действия на основном потоке. В вашем коде runn1 будет выполнен через 2 секунды после запуска потока.");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("post(Runnable action): Этот метод добавляет указанное действие в очередь сообщений основного потока. Действие будет выполнено в основном потоке после того, как текущий поток будет завершен.");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.tvInfo.setText("postDelayed(Runnable action, long delayMillis): Этот метод добавляет указанное действие в очередь сообщений основного потока и выполняет его после указанной задержки. В вашем коде runn3 будет выполнен через 2 секунды после добавления в очередь сообщений.");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.tvInfo.postDelayed(runn3, 2000);
                    binding.tvInfo.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}