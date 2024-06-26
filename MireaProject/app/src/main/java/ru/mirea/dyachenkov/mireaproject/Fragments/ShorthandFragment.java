package ru.mirea.dyachenkov.mireaproject.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.mirea.dyachenkov.mireaproject.R;
import androidx.appcompat.app.AlertDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShorthandFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShorthandFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShorthandFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShorthandFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShorthandFragment newInstance(String param1, String param2) {
        ShorthandFragment fragment = new ShorthandFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shorthand, container, false);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        EditText name= view.findViewById(R.id.name);

        EditText text= view.findViewById(R.id.editTextText3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileExtensionDialog(String.valueOf(name.getText()),String.valueOf(text.getText()));
            }
        });

        return view;
    }

    private void showFileExtensionDialog(String fileName,String filetext) {
        final String[] fileExtensions = new String[]{"txt", "pdf", "docx"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите расширение файла для конвертации")
                .setItems(fileExtensions, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            FileOutputStream outputStream;
                            outputStream = getActivity().openFileOutput(fileName+"."+fileExtensions[which], Context.MODE_PRIVATE);
                            outputStream.write(filetext.getBytes());
                            outputStream.close();
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка.");
                            e.printStackTrace();
                        }
                    }
                });
        builder.create().show();
    }
}