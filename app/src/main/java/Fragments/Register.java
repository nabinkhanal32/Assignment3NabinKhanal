package Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment_3nabinkhanal.R;

public class Register extends Fragment implements View.OnClickListener {
    private EditText etUsername, etEmail,etPassword,etCPassword;
    private Button btnSignup;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register,container,false);

        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        etCPassword = view.findViewById(R.id.etCPassword);
        btnSignup = view.findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);

        return view;




    }

    public Register() {
    }

    @Override
    public void onClick(View v) {
        if(etPassword.getText().toString().equals(etCPassword.getText().toString())){
            UserRegister();
        }else{
            Toast.makeText(this.getActivity(),"confirm password not matched",Toast.LENGTH_LONG).show();
        }

    }

    public void UserRegister()
    {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Username",etUsername.getText().toString());
        editor.putString("Email",etUsername.getText().toString());
        editor.putString("Password",etPassword.getText().toString());
        editor.putString("Conform Password",etPassword.getText().toString());


        editor.commit();

        Toast.makeText(this.getActivity(),"Successfully Registered",Toast.LENGTH_LONG).show();

    }

}