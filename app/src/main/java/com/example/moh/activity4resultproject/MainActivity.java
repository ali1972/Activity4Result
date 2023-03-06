package com.example.moh.activity4resultproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final int CODEADD = 567;
    public static final int  CODEMUL = 568;
    private TextView resultTextView;
    private TextView maxScoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.result);
        maxScoreTV = findViewById(R.id.max);

        SharedPreferences sharedPreferences = getSharedPreferences("data.txt",MODE_PRIVATE);
        maxScoreTV.setText("Max Score :" + sharedPreferences.getInt("MaxScore",0));




    }

    public void gotoActivity(View v){
        if(v.getId() == R.id.add ) {
            Intent i = new Intent(this, Activity2.class);
            startActivityForResult(i, CODEADD);
        }else if( v.getId() == R.id.mul ){
            Intent i = new Intent(this, MulActivity.class);
            startActivityForResult(i, CODEMUL);
        }
    }
    public void go(View v){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        SharedPreferences sharedPreferences = getSharedPreferences("data.txt",MODE_PRIVATE);
        //SharedPreferences.Editor edit = sharedPreferences.edit();
        int max = sharedPreferences.getInt("MaxScore",0);
        if(requestCode == CODEADD && resultCode == RESULT_OK ) {
            int x = data.getIntExtra("Result", 0);
            if( x > max ){
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("MaxScore",x);
                edit.commit();
                maxScoreTV.setText("MaxScore : " +x);

            }
            resultTextView.setText("Add :"+ x+"");
        }else if(requestCode == CODEMUL && resultCode == RESULT_OK){
            resultTextView.setText("Mul :" + data.getIntExtra("Result",0));
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }
}
