package com.example.ej2_numbersorting_apvg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_origARRAY_STRING = "com.example.ej2_numbersorting_apvg.EXTRA_origARRAY_STRING";
    Button submitBttn, showResultBttn;
    EditText editTextNumber;

    public static List<Integer> numberList = new ArrayList<>();
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
                if(editTextNumber.length() != 0){
                    if (numberList.size()<20) {
                        numberList.add(Integer.parseInt(editTextNumber.getText().toString()));
                        editTextNumber.setText("");
                        Toast.makeText(MainActivity.this, numberList.toString(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Sólo puedes ingresar 20 números", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Tienes que ingresar un número para continuar", Toast.LENGTH_SHORT).show();
                }


            }
        });

        showResultBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberList.size()!=0){
                    openShowResultAct();
                }
                else{
                    Toast.makeText(MainActivity.this, "El arreglo a ordenar está vacío", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }


    public void openShowResultAct(){
        List<Integer> originalArray = numberList;
        Intent intent = new Intent(this, showResultActivity.class);
        intent.putExtra(EXTRA_origARRAY_STRING, (Serializable) originalArray);
        startActivity(intent);
    }

}
