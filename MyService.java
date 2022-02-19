package gr.hua.dit.android.serviceexampleapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    //public class LocalBinder implements IBinder{
    public class LocalBinder extends Binder{
        public MyService getService() {
          return MyService.this;
        };
    }

    @Override
    public IBinder onBind(Intent intent) { //returns IBinder
        // TODO: Return the communication channel to the service.
        LocalBinder binder =  new LocalBinder();
        return binder;
        //throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //started worker thread --> runs parallel with main thread
//        Thread t = new Thread(new Runnable(){
//            @Override
//            public void run(){
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        });
        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    //client methods
    public int getRandomInt(){
        return (new Random()).nextInt(100);
    }
}