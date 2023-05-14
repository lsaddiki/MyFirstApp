package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextMontant=findViewById(R.id.editTextMontant);
        Button buttonCalculer=findViewById(R.id.buttonCalculer);
        TextView textViewResult=findViewById(R.id.textViewResult);
        ListView listViewResults=findViewById(R.id.listViewResults);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        listViewResults.setAdapter(stringArrayAdapter);

        buttonCalculer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double montant=Double.parseDouble(editTextMontant.getText().toString());
                double result=montant*65;
                textViewResult.setText(String.valueOf(result));
                data.add(montant+"=>"+result);
                stringArrayAdapter.notifyDataSetChanged();
                editTextMontant.setText("");
            }
        });
    }
}