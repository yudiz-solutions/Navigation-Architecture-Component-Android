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


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SignUpFragment";

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView: ");
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        initViews(v);
        return v;
    }

    private EditText txtName;
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnCreateNew;
    private TextView btnLogin;

    private void initViews(View view) {

        txtName = (EditText) view.findViewById(R.id.txtName);
        txtUsername = (EditText) view.findViewById(R.id.txtUsername);
        txtPassword = (EditText) view.findViewById(R.id.txtPassword);
        btnCreateNew = (Button) view.findViewById(R.id.btnCreateNew);
        btnLogin = (TextView) view.findViewById(R.id.btnLogin);

        btnCreateNew.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id
                    .btnCreateNew:
                if (valid()) {

                    Toast.makeText(getContext(), "User Created ! ", Toast.LENGTH_SHORT).show();


                    //for navigate to login fragment
                    Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_loginFragment);
                }
                break;

            case R.id
                    .btnLogin:
                //for navigate to login fragment
                Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_loginFragment);
                break;
        }

    }


    private boolean valid() {
            //empty text validation
        if (!(txtUsername.getText().toString().equals("") && txtPassword.getText().toString().equals("") && txtName.getText().toString().equals(""))) {
            return true;
        }

        Toast.makeText(getContext(), "Fill the data first" + txtUsername.getText(), Toast.LENGTH_SHORT).show();
        return false;
    }


}
