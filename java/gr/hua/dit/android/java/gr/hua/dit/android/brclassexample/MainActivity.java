package gr.hua.dit.android.brclassexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends Activity {

    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
    }
        private void registerReceiver() {
            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    try {
                        String result;
                        int a = Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON);
                        if (a == 0) {
                            result = "OFF";
                        } else {
                            result = "ON";
                        }

                        Toast.makeText(context, "AIRPLANE MODE: " + result, Toast.LENGTH_SHORT).show();
                    } catch (Settings.SettingNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            };
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            registerReceiver(receiver, filter);
        }

    }

