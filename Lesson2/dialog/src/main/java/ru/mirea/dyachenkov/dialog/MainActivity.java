package ru.mirea.dyachenkov.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText timeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeTextView = findViewById(R.id.editTextTime);

        Button pickDateButton = findViewById(R.id.btPickDate);
        pickDateButton.setOnClickListener(v -> {
            MyDateDialogFragment myDateDialogFragment = new MyDateDialogFragment();
            myDateDialogFragment.show(getSupportFragmentManager(), "datePicker");
        });


    }
    public void onProgressClickShowDialog(View view){
        MyProgressDialogFragment myProgressDialogFragment=new MyProgressDialogFragment();
        myProgressDialogFragment.show(getSupportFragmentManager(),"mirea");
    }
    public void onClickShowDialog(View view){
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onTimeShowDialog(View view){
        MyTimeDialogFragment dialogFragment = new MyTimeDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onTimeOkClicked( int hourOfDay, int minute) {
        timeTextView.setText(hourOfDay + ":" + minute);
    }

}