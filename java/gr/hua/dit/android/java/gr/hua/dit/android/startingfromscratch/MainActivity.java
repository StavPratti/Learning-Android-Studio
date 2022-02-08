package gr.hua.dit.android.startingfromscratch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity { //implements View.OnClickListener

    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.mybutton);
        //final TextView textView = findViewById(R.id.mytextview);

        // MyButtonClickListener myButtonClickListener = new MyButtonClickListener(this);
        // findViewById(R.id.mybutton).setOnClickListener(myButtonClickListener);

        // findViewById(R.id.mybutton).setOnClickListener(this); //2nd way

        /*findViewById(R.id.mybutton).setOnClickListener(new View.OnClickListener() { //3rd and best way with anonymous object
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Haha3", Toast.LENGTH_SHORT).show(); //MainActivity.this is referring to the anonymous object
                textView.setText("World");
            }
        }); */

        //for List View
        final String [] items = {"one", "two", "three"};
        ListView listView = findViewById(R.id.mylistview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter); //adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, items[(int)id] , Toast.LENGTH_SHORT).show(); //items[(int)id] or items[position]
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
    }

//    @Override //if I do this no need to create the new class MyButtonClickListener
//    public void onClick(View v) {
//        //if(v.getid)
//        Toast.makeText(this,"Haha2",Toast.LENGTH_SHORT).show();
//    }
}
