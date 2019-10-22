package org.sara.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOne extends Fragment {
    private EditText editTextFragmentOne;
    private ImageView circulo;
    private int colorId = android.R.color.black;
    private Button buttonAzul;
    private Button buttonRojo;
    private Button buttonVerde;
    private Button buttonNaranja;
    private Button buttonFragmentOne;
    private OnFragmentInteractionListener mListener;
    public FragmentOne() {
        // Required empty public constructor
    }

    private void changeColor() {
        circulo.setColorFilter(ContextCompat.getColor(getContext(), colorId));
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        editTextFragmentOne = rootView.findViewById(R.id.editTextFragmentOne);
        buttonFragmentOne = rootView.findViewById(R.id.buttonFragmentOne);
        circulo = rootView.findViewById(R.id.circulo);
        buttonFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(colorId);
            }
        });
        Button colorOne = rootView.findViewById(R.id.buttonAzul);
        Button colorTwo = rootView.findViewById(R.id.buttonVerde);
        Button colorThree = rootView.findViewById(R.id.buttonNaranja);
        Button colorFour = rootView.findViewById(R.id.buttonRojo);
        colorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_blue_dark;
                changeColor();
            }
        });
        colorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_green_dark;
                changeColor();
            }
        });
        colorThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_orange_dark;
                changeColor();
            }
        });
        colorFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_red_dark;
                changeColor();
            }
        });
        return rootView;
    }

    private void onButtonPressed(int colorId) {
        if (mListener != null) {
            mListener.onFragmentInteraction(editTextFragmentOne.getText().toString(), colorId);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String text, int colorId);
    }
}