package ru.mirea.dyachenkov.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextText2);
    }

    public void onMultiButtonClick(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", editText.getText().toString());
        startActivity(intent);
    }
}