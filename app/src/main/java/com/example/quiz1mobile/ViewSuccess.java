package com.example.quiz1mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;

public class ViewSuccess extends Fragment {
    public Button view_pref;

    public ViewSuccess() {
        // Require empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.success_layout, container, false);
        view_pref = view.findViewById(R.id.button_3);


        view_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new CreateRecord(), null).commit();
            }
        });
        return view;
    }
}