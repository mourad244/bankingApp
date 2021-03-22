package com.cit.BankApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;



public class SecondActivity extends AppCompatActivity {
    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";

    @BindView(R.id.listView)
    ListView listView;
    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        //create ArrayList of String
        ArrayList<Items> arrayList = new ArrayList<Items>();

        //create Data
        arrayList.add(new Items(R.drawable.ic_baseline_phone_bill, "Facture", "300,00$", "05-01-2006"));
        arrayList.add(new Items(R.drawable.ic_emission, "Emission", "200,00$", "03-01-2006"));
        arrayList.add(new Items(R.drawable.ic_paiment, "Paiment", "100,00$", "25-01-2006"));
        arrayList.add(new Items(R.drawable.ic_card_paiment, "paiment par carte", "50,00$", "10-01-2006"));
        arrayList.add(new Items(R.drawable.ic_espece, "Retrait d'espèces", "250,00$", "12-01-2006"));

        //create ItemsAdapter
        ItemsAdapter itemsAdapter = new ItemsAdapter(this, R.layout.list_row, arrayList);

        listView.setAdapter(itemsAdapter);

        /*//Add elements to arraylist
        arrayList.add("Facture Internet");
        arrayList.add("Emission d'un");
        arrayList.add("Paiement d'un");
        arrayList.add("Paiement par carte");
        arrayList.add("Retrait d'espèces");



//Create Adapter
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

//assign adapter to listview
        listItems.setAdapter(arrayAdapter);*/

//add listener to listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent2 =new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent2);

            }
        });
    }

    public void onStart(){
        super.onStart();

        //read username and password from SharedPreferences
        getUser();
    }
    public void getUser(){
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username= pref.getString(PREF_USERNAME,null);
        String password = pref.getString(PREF_PASSWORD,null);
        TextView view=(TextView)findViewById(R.id.txtuser);
        view.setText("Welcome "+username);
        if (username != null || password != null) {
            //directly show logout form

        }
    }
    public void logout(View view){
        SharedPreferences sharedPrefs =getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        editor.apply();
        user="";
        //show login form
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
