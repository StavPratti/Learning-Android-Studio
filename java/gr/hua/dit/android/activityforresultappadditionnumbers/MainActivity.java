package gr.hua.dit.android.activityforresultappadditionnumbers;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); //3 parameteres !!
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int a = data.getIntExtra("num1", 0);
                int b = data.getIntExtra("num2", 0);
                TextView textView = findViewById(R.id.mytextview);
                textView.setText((a+b)+"");
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}