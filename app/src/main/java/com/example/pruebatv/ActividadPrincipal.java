package com.example.pruebatv;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class ActividadPrincipal extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

}
