package com.example.yudizsolutions.navigationdemo;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


//  Created by Meet Chandra
//    on 17/06/2018

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "LoginFragment";

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView: ");
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(v);


        return v;

    }

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView btnCreateNew;

    private void initViews(View view) {
        txtUsername = (EditText) view.findViewById(R.id.txtUsername);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnCreateNew = (TextView) view.findViewById(R.id.btnCreateNew);
        btnCreateNew.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    private LoginFragmentDirections.Action_loginFragment_to_displayFragment compareData(String txtUsername, String txtPassword) {

        LoginFragmentDirections.Action_loginFragment_to_displayFragment action = LoginFragmentDirections.action_loginFragment_to_displayFragment();
        action.setUsername(txtUsername);
        return action;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id
                    .btnCreateNew:
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_signUpFragment);
                break;


            case R.id
                    .btnLogin:
                if (valid()) {

                    LoginFragmentDirections.Action_loginFragment_to_displayFragment args = compareData(txtUsername.getText().toString(), txtPassword.getText().toString());

                    if (args != null)
                        Navigation.findNavController(v).navigate(args);
                }
                break;
        }

    }


    private boolean valid() {

        if (!(txtUsername.getText().toString().equals("")&& txtPassword.getText().toString().equals(""))) {
            return true;
        }

        Toast.makeText(getContext(), "Fill the data first" + txtUsername.getText(), Toast.LENGTH_SHORT).show();
        return false;
    }


}
