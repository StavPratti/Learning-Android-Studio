package gr.hua.dit.android.mydemoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends Activity {

    private TextView textView; //i initialize it inside the onCreate s

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mytextview); //initialization

        Button button = findViewById(R.id.mybutton); //bring me an object (button) so that it can handle mybutton
        button.setOnClickListener(new View.OnClickListener() { //when an event (listener) "click" occurs, create a new object type "onClickListener" that inside runs the method onClick
            @Override //changes the content of mybutton when user clicks on it
            public void onClick(View v) {
                // TextView textView = findViewById(R.id.mytextview);
                // textView.setText("Blah blah");
         //       @SuppressLint("WrongViewCast") EditText editText = findViewById(R.id.mytextview); //finds the resource of edit text
                /* ((EditText)findViewById(R.id.myedittext)).getText() */
         //       String text = editText.getText().toString(); //i convert editText to toString because editText does not return string
                //TextView textView = findViewById(R.id.mytextview); //creates an object that handles mytextview
         //       textView.setText(text); //contains the string text
                //System.out.println("Lorem Ipsum");
         //       Log.println(Log.ERROR, "test error", "ERROR!!"); //i write the name of the class, . and i look for the static var
                //Log.e
                //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                //SecondActivity secondActivity = new SecondActivity(); //WRONG

                //how to initiate an intent
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dit.hua.gr")); //parse accepts a string and converts it to URI, for browsing in the internet -> EMMESOS TROPOS
                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class); //dhmioyrgia intent me anafora sthn klash poy eimai, klash poy uelw na paw -> AMESOS TROPOS
                //intent2.setClassName("gr.hua.dit.android.mydemoapp","gr.hua.dit.android.mydemoapp.SecondActivity"); //dhmioyrgia intent me anafora sta packages -> AMESOS TROPOS
                //startActivity(intent2);
            }
        });


//        //if properties in design on onClick
//        public void doSomething(View v){
//            @SuppressLint("WrongViewCast") EditText editText = findViewById(R.id.mytextview);
//            String text = editText.getText().toString();
//            TextView textView = findViewById(R.id.mytextview);
//            textView.setText(text);
//        }

        //mybutton2 puts in text view a standard text (karfwta)
//        Button button2 = findViewById(R.id.mybutton2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textView.setText("Blah blah2");
//            }
//        });
    }
}

