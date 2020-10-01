package com.example.aidlsensorserver;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final int SENSOR_DELAY=8*1000;//8 ms

    private SensorManager mSensorManager;
    private Sensor mRotationSensor;
    //private float x=0.0f,y=0.0f,z=0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        mRotationSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        startListening();
    }

    public void startListening() {

        if (mRotationSensor == null) {
            Log.e("Error","Rotation vector sensor not available; will not provide orientation data.");
            return;
        }
        mSensorManager.registerListener(this, mRotationSensor, SENSOR_DELAY);
    }

    public void stopListening() {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor == mRotationSensor) {
            SensorData sd=SensorData.getInstance();
            sd.setResult(sensorEvent.values[0],sensorEvent.values[1],sensorEvent.values[2]);
//            x=sensorEvent.values[0];
//            y=sensorEvent.values[1];
//            z=sensorEvent.values[2];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

//    public static String setResult()
//    {
//        return "*** Sensor Data ***\n\nX="+x+"\n\nY="+y+"\n\nZ="+z;
//    }
}