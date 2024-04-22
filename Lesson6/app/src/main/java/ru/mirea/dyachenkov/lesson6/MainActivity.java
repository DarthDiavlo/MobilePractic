package ru.mirea.dyachenkov.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.mirea.dyachenkov.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        binding.editTextText.setText(sharedPref.getString("GROUP", "GROUP"));
        binding.editTextText2.setText(sharedPref.getString("NUMBER", "NUMBER"));
        binding.editTextText3.setText(sharedPref.getString("FILM", "FILM"));
        binding.button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("GROUP", String.valueOf(binding.editTextText.getText()));
                editor.putString("NUMBER", String.valueOf(binding.editTextText2.getText()));
                editor.putString("FILM",String.valueOf(binding.editTextText3.getText()));
                editor.apply();
            }
        });
    }
}