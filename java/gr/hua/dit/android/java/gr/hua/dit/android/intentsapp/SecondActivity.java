package gr.hua.dit.android.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent startIntent = getIntent(); //epistrefei to intent poy ksypnhse to sygkekrimeno activity
        Toast.makeText(this, startIntent.getDataString(), Toast.LENGTH_SHORT).show(); //ektypwnwi ta data dhl to hua

        Button button = findViewById(R.id.mybutton2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (SecondActivity.this, MainActivity.class); //explicit routing
                startActivity(intent);
                finish();
            }
        });
    }
}