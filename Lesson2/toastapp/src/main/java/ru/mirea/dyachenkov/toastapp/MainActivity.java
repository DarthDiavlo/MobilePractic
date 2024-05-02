package ru.mirea.dyachenkov.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextText);
    }
    public void onButtonClick(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "СТУДЕНТ No 25 ГРУППА БСБО-05-22 Количество символов - "+
                        editText.getText().toString().length(),
                Toast.LENGTH_LONG);
        toast.setGravity(15,15,15);
        toast.show();
    }
}