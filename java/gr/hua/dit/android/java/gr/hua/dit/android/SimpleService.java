package gr.hua.dit.android.boundservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
//import android.support.annotation.Nullable;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


public class SimpleService extends Service {

    public SimpleService() {

    }

    private LocalBinder myBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        myBinder = new LocalBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public int getRandomInt() {
        return (new Random().nextInt(100));
    }

    public class LocalBinder extends Binder {
        public SimpleService getService() {
            return SimpleService.this;
        }

        ;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) { //dwse ta ergaleia gia na kanw start/stop moysikh vs unBind?
        LocalBinder myBinder = new LocalBinder();

        return myBinder; //ICP
    }


//    void writeLongToFile(long value){
//        try {
//            FileOutputStream fos = openFileOutput("delay.dat", Context.MODE_PRIVATE);
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeLong(value);
//            dos.close();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(), "Could not access file. Service stopped!", Toast.LENGTH_SHORT).show();
//            stopSelf();
//        } catch (IOException e) {
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(), "Could not write to file. Service stopped!", Toast.LENGTH_SHORT).show();
//            stopSelf();
//        }
//    }
//    long readLongFromFile(){
//        long time = 0;
//        try {
//            FileInputStream fis = openFileInput("delay.dat");
//            DataInputStream dis = new DataInputStream(fis);
//            time = dis.readLong();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//            //in case there's no value to read from file just push zero to it just to make sure there's something stored
//            writeLongToFile(0);
//        }
//        return time;
//    }
}