package ru.mirea.dyachenkov.mireaproject.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.mirea.dyachenkov.mireaproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        EditText name= (EditText) view.findViewById(R.id.name);
        EditText age= (EditText) view.findViewById(R.id.age);
        EditText email= (EditText) view.findViewById(R.id.email);
        EditText orientation= (EditText) view.findViewById(R.id.orientation);
        Button save=(Button)view.findViewById(R.id.saveButton);
        name.setText(sharedPref.getString("name", "Error"));
        age.setText(sharedPref.getString("age", "Error"));
        email.setText(sharedPref.getString("email", "Error"));
        orientation.setText(sharedPref.getString("orientation", "Error"));
        save.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", String.valueOf(name.getText()));
                editor.putString("age", String.valueOf(age.getText()));
                editor.putString("email",String.valueOf(email.getText()));
                editor.putString("orientation",String.valueOf(orientation.getText()));
                editor.apply();
            }
        });
        return view;
    }
}