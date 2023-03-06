package com.example.moh.activity4resultproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MulActivity extends Activity {
    private EditText number1;
    private EditText number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);

        number1 = findViewById(R.id.number1Id);
        number2 = findViewById(R.id.number2Id);
    }

    public void compute(View v){
        Intent intent = new Intent();
        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        int result = num1 * num2;
        intent.putExtra("Result",result);
        setResult(RESULT_OK,intent);
        finish();

    }
}
