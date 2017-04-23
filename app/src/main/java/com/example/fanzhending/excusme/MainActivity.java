package com.example.fanzhending.excusme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        //comment
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChoosePersonActivity.class);
        EditText editText = (EditText) findViewById(R.id.user_input);
        String message = editText.getText().toString();
        //Create the bundle
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("number", message);

//Add the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
