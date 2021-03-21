package com.cit.BankApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.sName)
    EditText Name;
    @BindView(R.id.sPassword)
    EditText Password;
    @BindView(R.id.msgError)
    TextView messageError;
    /*@BindView(R.id.btnLogin) Button connecter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*Name = (EditText)findViewById(R.id.sName);
        Password = (EditText)findViewById(R.id.sPassword);
        connecter = (Button)findViewById(R.id.btnLogin);*/
    }

    @OnClick(R.id.btnLogin)
    public void onClick(View v) {
        validate(Name.getText().toString(), Password.getText().toString());

}



    private void  validate(String userName, String userPassword) {

        if ((userName.equals("mourad") && (userPassword.equals("1234")))){
            Intent  intent =new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        }


        else if ("".equals(Name.getText().toString().trim())){
            Name.setError("Enter Name");

        }
        else if ("".equals(Password.getText().toString().trim())) {
            Password.setError("Enter Password");

        }

         else

    {
        messageError.setVisibility(View.VISIBLE);

    }

    }
}