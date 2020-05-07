package com.saudi.simbamessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //create a KEy for the intent extra
    public static final String EXTRA_MESSAGE_KEY = "my key";
    //create an edit text object
    private EditText messageEditText;
    //creating log tag
public static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect messageEditText with EditText in the layout
        messageEditText = findViewById(R.id.edit_text_message);



        //connect the textview variable with the text view in the layout
        TextView messageTextView = findViewById(R.id.TextView_reply_message);
        // retrieve the intent
        Intent myIntent = getIntent();
        //get the message as a string using the key as send from the main activity
        String myMessage = myIntent.getStringExtra(MainActivity.EXTRA_MESSAGE_KEY);
        //display the message in the textview in the UI using the method setText
        messageTextView.setText(myMessage);

    }

    public void LaunchSecondActivity(View view) {

        //create an intent to start the second activity
        Intent myintent = new Intent(this, SecondActivity.class);
       //start the second activity using the method startActivity
        Log.d(LOG_TAG, "button clicked");
        //get the message from the edit text as a string
        String mymessage = messageEditText.getText().toString();
        //let's put the message in the intent using the putExtra
        myintent.putExtra(EXTRA_MESSAGE_KEY, mymessage);
        startActivity(myintent);
    }
}
