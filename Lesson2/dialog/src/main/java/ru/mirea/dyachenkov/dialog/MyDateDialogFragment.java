package ru.mirea.dyachenkov.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Создаем DatePickerDialog с текущей датой
        return new DatePickerDialog(getActivity(), (view, selectedYear, selectedMonth, selectedDay) -> {
            // Обработка выбранной даты
            String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            ((TextView) getActivity().findViewById(R.id.tvDate)).setText(formattedDate);
        }, year, month, dayOfMonth);
    }
}
