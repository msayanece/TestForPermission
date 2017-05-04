package com.example.pc43.testforpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private String LOG_MSG = "sayan";
    private final int REQUEST_FOR_LOCATION = 1001;
    private final int REQUEST_FOR_EXTERNAL_STORAGE = 1002;
    private final int REQUEST_FOR_SMS_READ = 1003;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissionForLocation();
        requestPermissionForSMS();
        requestPermissionForExternamStorage();


    }

    public boolean requestPermissionForLocation(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(getApplicationContext(), "Location permission is mandatory",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_FOR_LOCATION);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_FOR_LOCATION);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean requestPermissionForExternamStorage(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(getApplicationContext(), "Location permission is mandatory",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_FOR_EXTERNAL_STORAGE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_FOR_EXTERNAL_STORAGE);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean requestPermissionForSMS(){
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            // explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_SMS)) {
                Toast.makeText(getApplicationContext(), "Location permission is mandatory",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS},
                        REQUEST_FOR_SMS_READ);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS},
                        REQUEST_FOR_SMS_READ);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        Log.d(LOG_MSG, " onRequestPermissionsResult");
        switch (requestCode) {
            case REQUEST_FOR_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_MSG, " yes selected");
                    // permission was granted
                    Toast.makeText(getApplicationContext(), "Location Permission granted", Toast.LENGTH_LONG).show();
                } else {
                    Log.d(LOG_MSG, " no selected");
                    Toast.makeText(getApplicationContext(), "",Toast.LENGTH_LONG).show();
                   finish();
                }
                break;
            }
            case REQUEST_FOR_SMS_READ: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_MSG, " yes selected");
                    // permission was granted
                    Toast.makeText(getApplicationContext(), "SMS Permission granted", Toast.LENGTH_LONG).show();
                } else {
                    Log.d(LOG_MSG, " no selected");
                    Toast.makeText(getApplicationContext(), "",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            }
            case REQUEST_FOR_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_MSG, " yes selected");
                    // permission was granted
                    Toast.makeText(getApplicationContext(), "SMS Permission granted", Toast.LENGTH_LONG).show();
                } else {
                    Log.d(LOG_MSG, " no selected");
                    Toast.makeText(getApplicationContext(), "",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            }
        }
    }
}
