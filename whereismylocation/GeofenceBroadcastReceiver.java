package gr.hua.dit.android.whereismylocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {

    //user enters geofence and geofenceClient wakes up this receiver
    //elaborates the transitions
    @Override
    public void onReceive(Context context, Intent intent) {

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            String errorMessage = GeofenceStatusCodes
                    .getStatusCodeString(geofencingEvent.getErrorCode());
            Log.e("BroadcastReceiver", errorMessage);
            return;
        }
        if (geofencingEvent.getGeofenceTransition() == Geofence.GEOFENCE_TRANSITION_ENTER){
            Log.d("BroadcastReceiver", "Entered in Geofence!");

        }
        if (geofencingEvent.getGeofenceTransition() == Geofence.GEOFENCE_TRANSITION_EXIT){
            Log.d("BroadcastReceiver", "Exited from Geofence!");

        }

    }
}
