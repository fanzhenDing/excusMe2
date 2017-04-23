package com.example.fanzhending.excusme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScheduleActivity extends AppCompatActivity {
    public static String person2,number2,excuse2,delay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Bundle bundle = getIntent().getExtras();
        person2=bundle.getString("person");
        number2=bundle.getString("number");
        excuse2=bundle.getString("excuse");
        delay2=(String)findViewById(R.id.delay).toString();
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ConfirmActivity.class);
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("number", number2);
        bundle.putString("person",person2);
        bundle.putString("excuse",excuse2);
        bundle.putString("delay",delay2);
//Add the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
