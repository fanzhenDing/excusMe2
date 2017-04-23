package com.example.fanzhending.excusme;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.lambdainvoker.*;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

public class ScheduleActivity extends AppCompatActivity {
    public static String person2,number2,excuse2;
    String delay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Bundle bundle = getIntent().getExtras();
        person2=bundle.getString("person");
        number2=bundle.getString("number");
        excuse2=bundle.getString("excuse");

    }
    public void sendMessage(View view) {
        final Intent intent = new Intent(this, ConfirmActivity.class);
        Bundle bundle = new Bundle();
        EditText editText = (EditText) findViewById(R.id.delay);
        delay2 = editText.getText().toString();

        // Create an instance of CognitoCachingCredentialsProvider
        final CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                this.getApplicationContext(), "us-west-2:321c69f5-7620-442f-9726-b9f2dc080259",
                Regions.US_WEST_2);

        // Create LambdaInvokerFactory, to be used to instantiate the Lambda proxy.
        final LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                Regions.US_WEST_2, cognitoProvider);

        // Create the Lambda proxy object with a default Json data binder.
        // You can provide your own data binder by implementing
        // LambdaDataBinder.
        final LambdaInterface myInterface = factory.build(LambdaInterface.class);


        LambdaRequest request = new LambdaRequest(number2, delay2, person2, excuse2);
        // The Lambda function invocation results in a network call.
        // Make sure it is not called from the main thread.
        new AsyncTask<LambdaRequest, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(LambdaRequest... params) {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                try {
                    return myInterface.PutScheduledCall(params[0]);
                } catch (LambdaFunctionException lfe) {
                    Log.e("Tag", "Failed to invoke echo", lfe);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(Boolean result) {
                if (result == null) {
                    return;
                }
                Bundle bundle = new Bundle();

                bundle.putBoolean("result", result);
                bundle.putString("number", number2);
                bundle.putString("delay", delay2);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        }.execute(request);

//Add the bundle to the intent
    }
}
