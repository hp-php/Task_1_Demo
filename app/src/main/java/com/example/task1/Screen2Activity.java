package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    int counter1;
    Button sub,id_back;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        counter1 = 0;
        sub = (Button) findViewById(R.id.bSub);
        mEditText =  findViewById(R.id.mEditText);
        id_back =  findViewById(R.id.id_back);

      mEditText.setText(getIntent().getIntExtra("counter",1)+"");
        Log.e("counter",getIntent().getIntExtra("counter",0)+"");



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Subtract 1 from counter
                counter1 = counter1 - 1;
                mEditText.setText(" Your total is :" + counter1);

            }
        });
        id_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra("MyData", mEditText.getText().toString());
               // Log.e("counter",mEditText.getText().toString());
                //intent.putExtra("counter",mEditText.getText());

//                intent.putExtra("counter",getIntent().getStringExtra("counter"));
//                Log.e("counter",getIntent().getStringExtra("counter"));
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
//    @Override
//    public void onBackPressed() {
//
//    }
}

