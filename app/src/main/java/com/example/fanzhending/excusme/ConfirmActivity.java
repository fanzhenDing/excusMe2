package com.example.fanzhending.excusme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfirmActivity extends AppCompatActivity {
    public static int delay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        delay3 = Integer.parseInt(bundle.getString("delay2"));
        String variable = getString((R.string.variable),delay3);
    }
    public void endProject(View view) {
        Intent intent = new Intent(this, ChoosePersonActivity.class);
        startActivity(intent);
    }

}
