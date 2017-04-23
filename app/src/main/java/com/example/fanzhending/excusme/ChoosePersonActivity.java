package com.example.fanzhending.excusme;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout;

import static com.example.fanzhending.excusme.R.id.dad;
import static com.example.fanzhending.excusme.R.id.default_msg_sender;
import static com.example.fanzhending.excusme.R.id.mom;
import static com.example.fanzhending.excusme.R.id.roommate;


//import static com.example.fanzhending.excusme.R.id.default_msg_sender;
//Add up navigation

public class ChoosePersonActivity extends AppCompatActivity {
    public static String message2,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_person);
        // Get the Intent that started this activity and extract the string
//Get the bundle
        Bundle bundle = getIntent().getExtras();

//Extract the data…
        message = bundle.getString("number");
        RadioGroup rg = (RadioGroup) findViewById(R.id.RG);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.default_msg_sender:
                        message2="default";// do operations specific to this selection
                        break;
                    case R.id.mom:
                        message2="mom";// do operations specific to this selection
                        break;
                    case R.id.dad:
                        message2="dad";// do operations specific to this selection
                        break;
                    case R.id.roommate:
                        message2="roommate";
                        break;
                }
            }
        });
    }
  /*  public void viewtext(View view) {
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(message2);
    }*/
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChooseMessageActivity.class);
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("number", message);
        bundle.putString("person",message2);

//Add the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
