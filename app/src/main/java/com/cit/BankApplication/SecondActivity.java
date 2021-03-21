package com.cit.BankApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;


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
}
