package com.example.yudizsolutions.navigationdemo;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

//  Created by Meet Chandra
//    on 17/06/2018


public class DisplayFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "DisplayFragment";

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_display, container, false);
        initViews(v);

        return v;
    }


    private void getUserData() {

        Toast.makeText(getContext(), "getArgs", Toast.LENGTH_SHORT).show();
        txtUsername.setText(DisplayFragmentArgs.fromBundle(getArguments()).getUsername());
        txtName.setText("user");
    }

    private EditText txtName;
    private EditText txtUsername;
    private Button btnLogout;

    private void initViews(View view) {
        txtName = (EditText) view.findViewById(R.id.txtName);
        txtUsername = (EditText) view.findViewById(R.id.txtUsername);
        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);


        getUserData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id
                    .btnLogout:
                Navigation.findNavController(v).navigate(R.id.action_displayFragment_to_loginFragment);
        }
    }
}
