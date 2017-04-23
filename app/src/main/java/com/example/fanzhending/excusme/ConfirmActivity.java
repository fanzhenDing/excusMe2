package com.example.fanzhending.excusme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {
    public static String delay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        delay3 = bundle.getString("delay");
        /*String variable = getString((R.string.variable),delay3);*/
        TextView textView = (TextView) findViewById(R.id.textView7);
        textView.setText(delay3);
    }
    public void endProject(View view) {
        Intent intent = new Intent(this, ChoosePersonActivity.class);
        Bundle bundle = getIntent().getExtras();
        String num = bundle.getString("number");
        Bundle new_bundle = new Bundle();
        new_bundle.putString("number",num);
        intent.putExtras(new_bundle);
        startActivity(intent);
    }

}
