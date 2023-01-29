package com.example.madrasaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText name_input, sabq_input,sabqi_input, manzil_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name_input = findViewById(R.id.name_input);
        sabq_input = findViewById(R.id.sabq_input);
        sabqi_input = findViewById(R.id.sabqi_input);
        manzil_input = findViewById(R.id.manzil_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(name_input.getText().toString().trim(),
                        sabq_input.getText().toString().trim(),
                        sabqi_input.getText().toString().trim(),
                        manzil_input.getText().toString().trim());
                        //Integer.valueOf(pages_input.getText().toString().trim()));
            }
        });
    }
}