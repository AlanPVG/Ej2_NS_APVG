package com.example.ej2_numbersorting_apvg;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class showResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        List<Integer> origArray = (ArrayList<Integer>) getIntent().getSerializableExtra(MainActivity.EXTRA_origARRAY_STRING);

        TextView resultTextV = findViewById(R.id.resultTextView);

        Integer numberArray[] = origArray.toArray(new Integer[origArray.size()]);//Conversión de lista a arreglo
        bubbleSort(numberArray);
        resultTextV.setText(origArray.toString() + "\n" + Arrays.deepToString(numberArray) );//

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
}
