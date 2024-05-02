package ru.mirea.dyachenkov.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

public class MyTimeDialogFragment extends DialogFragment {

    private int lastSelectedHour = 0;
    private int lastSelectedMinute = 0;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ((MainActivity)getActivity()).onTimeOkClicked(hourOfDay,minute);
                    }
                },
                lastSelectedHour,
                lastSelectedMinute,
                true
        );
        return  timePickerDialog;
    }
}
