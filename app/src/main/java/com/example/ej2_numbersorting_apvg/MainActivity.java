package com.example.ej2_numbersorting_apvg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button submitBttn;
    EditText editTextNumber;

    public static List<Integer> numberArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.arrNumber);

        submitBttn = findViewById(R.id.submitNumber);


        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberArray.add(Integer.parseInt(editTextNumber.getText().toString()));
                Toast.makeText(MainActivity.this, numberArray.toString(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}
