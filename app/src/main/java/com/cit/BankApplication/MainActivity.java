package com.cit.BankApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";


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
    public void onStart(){
        super.onStart();
        //read username and password from SharedPreferences
        getUser();
    }
    public void doLogin(View view){
        EditText txtuser=(EditText)findViewById(R.id.sName);
        EditText txtpwd=(EditText)findViewById(R.id.sPassword);
        String username="myusername";
        String password="mypassword";
        if(txtuser.getText().toString().equals(username) && txtpwd.getText().toString().equals(password)){
            CheckBox ch=(CheckBox)findViewById(R.id.ch_rememberme);
            if(ch.isChecked())
                rememberMe(username,password); //save username and password
            //show logout activity
            showLogout(username);

        }
        else{
            Toast.makeText(this, "Invalid username or password",Toast.LENGTH_LONG).show();
        }


    }
    @OnClick(R.id.btnLogin)
    public void onClick(View v) {
        validate(Name.getText().toString(), Password.getText().toString());
    }

    private void  validate(String userName, String userPassword) {

        if ((userName.equals("mourad244") && (userPassword.equals("1234")))){
            Intent  intent =new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else if (Name.getText().toString().trim().equals("")){
            Name.setError("Enter Name");
        }

        else if (Password.getText().toString().trim().equals("")) {
            Password.setError("Enter Password");
        }

         else messageError.setVisibility(View.VISIBLE);
    }

    public void getUser(){
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username= pref.getString(PREF_USERNAME,null);
        String password = pref.getString(PREF_PASSWORD,null);

        if (username != null || password != null) {
            //directly show logout form
            showLogout(username);
        }
    }

    public void rememberMe(String user, String password){
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME,user)
                .putString(PREF_PASSWORD,password)
                .commit();
    }
    public void showLogout(String username){
        //display log out activity
        Intent intent=new Intent(this, LogoutActivity.class);
        intent.putExtra("user",username);
        startActivity(intent);
    }
}