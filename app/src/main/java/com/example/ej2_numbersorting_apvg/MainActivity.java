package com.example.ej2_numbersorting_apvg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Arrays;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ARRAY_STRING = "com.example.ej2_numbersorting_apvg.EXTRA_ARRAY_STRING";
    Button submitBttn, showResultBttn;
    EditText editTextNumber;

    public static List<Integer> numberList = new ArrayList<>();
    public static List<Integer> auxList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.arrNumber);

        submitBttn = findViewById(R.id.submitNumber);

        showResultBttn = findViewById(R.id.showResBttn);


        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberList.size()<20) {
                    numberList.add(Integer.parseInt(editTextNumber.getText().toString()));
                    editTextNumber.setText("");
                    Toast.makeText(MainActivity.this, numberList.toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Sólo puedes ingresar 20 números", Toast.LENGTH_SHORT).show();

                    Integer numberArray[] = numberList.toArray(new Integer[numberList.size()]);//Conversión de lista a arreglo
                    bubbleSort(numberArray);
                    Collections.addAll(auxList, numberArray);
                }

            }
        });

        showResultBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShowResultAct();
            }
        });



    }


    public void bubbleSort(Integer arr[]){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public void openShowResultAct(){
        String arrayString = auxList.toString();
        Intent intent = new Intent(this, showResultActivity.class);
        intent.putExtra(EXTRA_ARRAY_STRING,arrayString);
        startActivity(intent);
    }

}
