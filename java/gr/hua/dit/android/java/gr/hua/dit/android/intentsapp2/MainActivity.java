package gr.hua.dit.android.intentsapp2;

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

        Intent startIntent = getIntent();
        //int a = (int) startIntent.getExtras().get("integer1");
        //if(a == null)
        int a = startIntent.getIntExtra("integer1", -9);
        String b = startIntent.getStringExtra("string1");
        startIntent.putExtra("result", a+b); //putExtra gia na staloyn dedomena sthn 1h activity
        setResult(this.RESULT_OK,startIntent);
        finish();

//        if (a == -9){
//            Toast.makeText(this, "No extras", Toast.LENGTH_SHORT).show();
//        }

        //Toast.makeText(this, a+"", Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.dit.hua.gr")); //implicit routing
                Intent intent = new Intent ("gr.hua.dit.android.intentsapp2", Uri.parse("gr.hua.dit.android.intentsapp.MainActivity"));
                startActivity(intent);
                finish();
            }
        });
    }
}