package com.example.quiz1mobile;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class User_details extends Fragment {
    Button btnsave;
    EditText editText,id,name,password;
    TextView gender, department, session;
    RadioGroup radios;
    Spinner one;

    public User_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.home_layout, container, false);

        id = (EditText) view.findViewById(R.id.student_id);
        editText = (EditText) view.findViewById(R.id.student_email);
        name = (EditText) view.findViewById(R.id.student_name);
        password = (EditText) view.findViewById(R.id.student_password);
        radios=(RadioGroup) view.findViewById(R.id.radioSex);
//        gender= (TextView)  view.findViewById(R.id.);
        department = (TextView) view.findViewById(R.id.department);
        session = (TextView) view.findViewById(R.id.session);
        btnsave= view.findViewById(R.id.savebtn);
        one= view.findViewById(R.id.spinner1);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checked = radios.getCheckedRadioButtonId();

                if(editText.length()==0 || id.length() == 0 || name.length() == 0 || password.length() == 0 || checked==-1 ){
                    editText.setError("Email");
                    id.setError("Enter Reg number");
                    name.setError("Enter a valid name");
                    password.setError("Enter a valid password");
                    gender.setTextColor(Color.RED);
                    department.setTextColor(Color.RED);
                    session.setTextColor(Color.RED);
                }

                else {
                    ViewSuccess nextFrag= new ViewSuccess(); getActivity().getSupportFragmentManager().beginTransaction() .replace(R.id.fragment_container, nextFrag, "findThisFragment") .addToBackStack(null) .commit();


                }
            }
        });
        return view;
    }

}