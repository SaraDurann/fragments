package org.sara.fragments;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


        public class MainActivity extends AppCompatActivity implements
                FragmentOne.OnFragmentInteractionListener,
                FragmentTwo.OnFragmentInteractionListener {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                //container es el nombre del fragment
                FragmentOne fragment = FragmentOne.newInstance("HOLA", "QUE HACE");
                fragmentTransaction.add(R.id.container, fragment);
                fragmentTransaction.commit();
            }
            @Override
            public void onFragmentInteraction(Uri uri) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =
                        fragmentManager.beginTransaction();
                FragmentTwo fragment = FragmentTwo.newInstance("HOLA", "QUE HACE");
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }

