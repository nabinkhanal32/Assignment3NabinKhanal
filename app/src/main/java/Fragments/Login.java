package Fragments;


import android.content.Context;
import android.content.Intent;
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

import com.example.assignment_3nabinkhanal.Dashboard_Activity;
import com.example.assignment_3nabinkhanal.R;

public class Login extends Fragment implements View.OnClickListener {
    private EditText etUser, etPass;
    private Button btnLogin;


    public Login() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login,container,false);
        etPass = view.findViewById(R.id.etPass);
        etUser = view.findViewById(R.id.etUser);

        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        UserLogin();
    }
    public  void UserLogin()
    {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        String UserName = sharedPreferences.getString("Username", "");
        String Password = sharedPreferences.getString("Password","");

        if (UserName.equals(etUser.getText().toString()) && Password.equals(etPass.getText().toString())) {
            Toast.makeText(this.getActivity(), "Login Succesfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.getActivity(), Dashboard_Activity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this.getActivity(), "Please Enter your valid Username and password", Toast.LENGTH_SHORT).show();
        }


    }

}