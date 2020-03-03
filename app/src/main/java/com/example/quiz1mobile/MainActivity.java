package com.example.quiz1mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;

    public static final String MyPREFERENCES = "MwizaPrefs" ;
    public static final String Password = "password";
    public static final String Email = "email";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction ft = fragmentManager.beginTransaction();
            CreateRecord fragment1 = new CreateRecord();

            ft.add(R.id.fragment_container, fragment1, null);
            ft.commit();
        }
    }
}
