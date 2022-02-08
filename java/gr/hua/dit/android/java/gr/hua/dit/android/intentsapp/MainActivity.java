package gr.hua.dit.android.intentsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent startIntent = getIntent(); //epistrefei to intent poy ksypnhse to sygkekrimeno activity
        Toast.makeText(this, startIntent.getDataString(), Toast.LENGTH_SHORT).show(); //ektypwsh data
        // sto sygkekrimeno intent ths MainActivity to intent einai gia na anoiksei h efarmogh
        //o launcher poy prospauei na anoiksei h efarmogh

        Button button = findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.dit.hua.gr")); //implicit routing
                //Intent intent = new Intent (MainActivity.this, SecondActivity.class); //the second always .class
                Intent intent = new Intent("gr.hua.dit.android.intentsapp2", Uri.parse("gr.hua.dit.android.intentsapp.MainActivity"));

                //gia na stelnei h prwth activity dedomena sth 2h
                //h putExtra dexetai san orismata 1 pair me prwto to onoma ths parametroy kai deytero thn timh ths (mporei na einai ena object)
                intent.putExtra("integer1", 5);
                intent.putExtra("string1", "Hello world!");

                //startActivity(intent);
                //finish();

                // se mia periptwsh poy o xrhsths px symplhrwnei mia forma kai ueloyme oi times aytomata epistrefontai sthn allh activity
                // dexetai ws orismata to intent poy ueloyme na steiloyme ki ena request code, ena call back poy ua klhuei mono otan epistrepsei apo thn deyterh activity o elegxos, h plhroforia
                startActivityForResult(intent, 7); //the number is random, it shows the queue
                //mporoyme na exoyme polla startActivityForResult alla MONH ths h onActivityResult ta xeirizetai kai prepei na kserei ariumo gia na ksexwrizei
            }
        });
    }

    // onActivityResult is the answer to startActivityForResult
            @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 7) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_LONG).show();
            }
        }
    }
}