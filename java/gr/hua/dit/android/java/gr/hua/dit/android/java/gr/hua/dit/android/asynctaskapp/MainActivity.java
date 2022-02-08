package gr.hua.dit.android.asynctaskapp;

import android.app.Activity;
import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.WorkerThread;
import androidx.work.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView progressView = findViewById(R.id.progressView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the correct way is --> runOnUiThread(new Runnable)
                //4 next lines are wrong
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        progressView.setText("Blah");
                    }
                });
                t.start();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.post(new Runnable() {
                       @Override
                    public void run(){
                           progressView.setText("Blah blah");
                       }
                });
            }

        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run(){
                        try{
                            URL url = new URL("https://");
                            URLConnection connection = url.openConnection();
                            BufferedReader reader = new BufferedReader(new InputStream[(connection.getInputStream()]);
                            Log.d("READER", reader.readLine());
                        }catch(MalformedURLException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
            }


            });
    }
}


//     class Worker extends AsyncTask<Integer, Integer, Void>{
//     //what types are the parametres, progress poy kanei report pros ta pisw, results
//        @Override //obliges to make it
//        protected Void doInBackground(Integer... params) {
//            //we're going to introduce some artificial heavy lifting here
//            int max = params[0];
//            for(int i=0; i<max;i++){
//                try {//to sleep thelei try catch
//                    Thread.sleep(1000); //gia ena deyterolepto
//                    //progressView.setText(i+""); //I THINK THIS IS NOT ALLOWED
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                publishProgress(i);
//            }
//            return null; //by default
//        }

//        @Override
//        protected void onProgressUpdate (Integer...values){
//            super.onProgressUpdate(values);
//            progressView.setText(values[0].toString() + "");
//        }
//
//        @Override
//        protected void onPreExecute () {
//            Toast.makeText(getApplicationContext(), "Starting worker", Toast.LENGTH_SHORT).show();
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute (Void aVoid){
//            Toast.makeText(getApplicationContext(), "Job's done!", Toast.LENGTH_SHORT).show();
//            super.onPostExecute(aVoid);
//        }

    }
}