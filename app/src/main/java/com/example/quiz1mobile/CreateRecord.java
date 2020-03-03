package com.example.quiz1mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import static com.example.quiz1mobile.MainActivity.Email;
import static com.example.quiz1mobile.MainActivity.MyPREFERENCES;
import static com.example.quiz1mobile.MainActivity.Password;

public class CreateRecord extends Fragment {
    EditText email, password;
    public Button view_pref;

    public CreateRecord() {
        // Require empty public constructor
    }


    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final SharedPreferences sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        // Inflate layer for create preferences fragment.
        View view = inflater.inflate(R.layout.home_layout, container, false);
        email=(EditText)view.findViewById(R.id.student_id);
        password =(EditText)view.findViewById(R.id.student_password);

        String strUserName = email.getText().toString();

        if(TextUtils.isEmpty(strUserName)) {
            email.setError("Please enter email.");
        }

        if(TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Please enter password");
        }
        

        view_pref =(Button) view.findViewById(R.id.button);

        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }


        Spinner staticSpinner = (Spinner) view.findViewById(R.id.spinner1);
        Spinner staticSpinner2 = (Spinner) view.findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter, staticAdapter2;
        staticAdapter = ArrayAdapter
                .createFromResource(view.getContext(), R.array.brew_array,
                        android.R.layout.simple_spinner_item);

        staticAdapter2 = ArrayAdapter
                .createFromResource(view.getContext(), R.array.brew_array_2,
                        android.R.layout.simple_spinner_item);


        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter2
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner2.setAdapter(staticAdapter2);


        view_pref = view.findViewById(R.id.button);
        view_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ViewSuccess(), null).commit();
                String n  = email.getText().toString();
                String ph  = password.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Email, n);
                editor.putString(Password, ph);
                editor.apply();
                Toast.makeText(getActivity(),"Content Saved",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


}
