package ru.mirea.dyachenkov.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Загрузка данных");
        progressDialog.setMessage("Пожалуйста, подождите...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Круговой индикатор
        progressDialog.setCancelable(false); // Нельзя закрыть диалоговое окно
        progressDialog.setMax(100);
        progressDialog.setProgress(50);

        return  progressDialog;
    }
}
