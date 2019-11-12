package com.example.ej2_numbersorting_apvg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        Intent intent = getIntent();

        String sortedArray = intent.getStringExtra(MainActivity.EXTRA_ARRAY_STRING);//Arreglo ordenado

        TextView resultTextV = findViewById(R.id.resultTextView);

        resultTextV.setText(sortedArray);

    }
}
