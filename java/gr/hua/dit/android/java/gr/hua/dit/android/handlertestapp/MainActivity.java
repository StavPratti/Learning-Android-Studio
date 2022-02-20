package gr.hua.dit.android.handlertestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    final int SHOW_PROGRESS_BAR = -1;
    final int DISABLE_PROGRESS_BAR = -2;
    Handler workerHandler; //must be obligatory a property of the class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        final EditText editText = findViewById(R.id.editText);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(20);
        progressBar.setVisibility(View.INVISIBLE);

        final Handler mainHandler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int progress = msg.what; //property what
                progressBar.setProgress(progress);
                switch(msg.what){
                    case SHOW_PROGRESS_BAR:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case DISABLE_PROGRESS_BAR:
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mainHandler.sendEmptyMessage(SHOW_PROGRESS_BAR); //this number makes (in)visible the progress bar
                     for(int i=1; i<=20;i++){
                         try{
                             Thread.sleep(1000);
                             //mainHandler.sendEmptyMessage(i);
                             //implementation with runnable
                             final int finalI = i;
                             mainHandler.post(new Runnable() {
                                 @Override
                                 public void run() {
                                     progressBar.setProgress(finalI);
                                 }
                             });
                         } catch (InterruptedException e){
                             e.printStackTrace();
                         }
                     }
                        mainHandler.sendEmptyMessage(DISABLE_PROGRESS_BAR);
                    }

                }).start();
            }
        });

        //a solution for not having an error is to create an Array with workerHandlers and use the [0] one
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler workerHandler = new Handler(Looper.myLooper()){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.d("WorkerThreadHandler", msg.what+"");
                    }
                };

                Looper.loop();
            }
        }).start();

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                workerHandler.sendEmptyMessage(Integer.parseInt(text));
                //workerHandler.getLooper().quit();
            }
        });
    }
}
