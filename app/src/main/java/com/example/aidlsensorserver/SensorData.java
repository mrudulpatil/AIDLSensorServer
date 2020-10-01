package com.example.aidlsensorserver;

public class SensorData {
    private static SensorData instance = null;
    private float x=0,y=0,z=0;
    private SensorData() {
        // Exists only to defeat instantiation.
    }

    public static SensorData getInstance() {
        if(instance == null) {
            instance = new SensorData();
        }
        return instance;
    }

    /* Other methods protected by singleton-ness */
    protected void setResult(float x,float y, float z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    /* Other methods protected by singleton-ness */
    protected String getResult() {
        return "*** Sensor Data ***\n\nX="+x+"\n\nY="+y+"\n\nZ="+z;
    }
}
