package gr.hua.dit.android.serviceexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //give and start intent
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MyService.class);
        //startService(intent);

        //bind service
        
        //listener
        //creation of iBinder object
        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
                Log.d("Service", binder.getService().getRandomInt()+"");
            }

            @Override
            public void onServiceDisconnected(ComponentName name){
        }
    };
        //needs three arguments: intent, service connection, flags
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }
}