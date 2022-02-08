package gr.hua.dit.android.activityforresultappadditionnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent(); //poios ksekinhse to event

        Button button = findViewById(R.id.mybutton2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.myedittextnumber);
                EditText editText2 = findViewById(R.id.myedittextnumber2);
                intent.putExtra("num1", Integer.parseInt(editText.getText().toString())); //Integer.parseInt to convert string to int
                intent.putExtra("num2", Integer.parseInt(editText2.getText().toString()));
                setResult(RESULT_OK , intent);
                finish();
            }
        });
    }
}