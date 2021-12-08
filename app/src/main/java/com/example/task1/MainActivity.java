package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter;
    Button add,id_next;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;
        add = (Button) findViewById(R.id.bAdd);
     //   sub = (Button) findViewById(R.id.bSub);
        display =  findViewById(R.id.tvDisplay);
        id_next =  findViewById(R.id.id_next);
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds 1 to the counter
                counter = counter + 1;
                display.setText(" Your total is :" + counter);
            }
        });

        id_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Screen2Activity.class);
                i.putExtra("counter", counter);
                //Log.e("counter",counter+"");
                startActivityForResult(i, 1);

            }
        });

//
//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Subtract 1 from counter
//                counter = counter - 1;
//                display.setText(" Your total is :" + counter);
//            }
//        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String myStr = data.getStringExtra("MyData");
                Log.e("MyData",data.getStringExtra("MyData"));
                display.setText(myStr);
                Log.e("myStr",myStr);

            }
        }
    }
}