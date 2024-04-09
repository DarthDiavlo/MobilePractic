package ru.mirea.dyachenkov.player;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import ru.mirea.dyachenkov.player.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i=0;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.title.setText("Следующая песня !!!");
            }
        });
        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( binding.title.getText().equals("Cейчас играет ...")){
                binding.title.setText("Stop");
                }else {binding.title.setText("Cейчас играет ...");}
            }
        });
        binding.previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.title.setText("Предыдущая песня ???");
            }
        });
    }
}