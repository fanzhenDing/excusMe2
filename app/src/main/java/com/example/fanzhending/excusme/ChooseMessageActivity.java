package com.example.fanzhending.excusme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.ScheduledExecutorService;

public class ChooseMessageActivity extends AppCompatActivity {
    public static String number,person,excuse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_message);
        Intent intent = getIntent();
//Get the bundle
        Bundle bundle = intent.getExtras();

//Extract the data…
        number = bundle.getString("number");
        person=bundle.getString("person");
        RadioGroup rg = (RadioGroup) findViewById(R.id.RG);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.flood:
                        excuse="Your apartment's flooded";// do operations specific to this selection
                        break;
                    case R.id.fire:
                        excuse="Your house is on fire";// do operations specific to this selection
                        break;
                    case R.id.missing:
                        excuse="Happy Birthday";// do operations specific to this selection
                        break;
                }
            }
        });

        // Capture the layout's TextView and set the string as its text
        /*TextView textView = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView.setText(number);
        textView2.setText(person);*/
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("number", number);
        bundle.putString("person",person);
        bundle.putString("excuse",excuse);

//Add the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
