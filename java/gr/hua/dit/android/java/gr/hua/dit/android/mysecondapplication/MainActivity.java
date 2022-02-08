package gr.hua.dit.android.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edittext);
                String userText = editText.getText().toString();
                TextView textView = findViewById(R.id.textview);
                textView.setText(userText);
                Intent intent = new Intent();
                //intent.setAction(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.dit.hua.gr"));
                //vres ena Activity poy kanei view ayto to url

                //implicit way
                intent.setClass(getApplicationContext(), SecondActivity.class);
                //also setClassName();
                intent.putExtra("int1",5);
                intent.putExtra("int2",3);
                startActivity(intent);
            }
        });

        String[] strings = new String[]{"one", "two", "three", "four"};
        ListView listView = findViewById(R.id.listview);
        //xeirizetai to widget gia na valw periexomeno sto listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);

    }
}