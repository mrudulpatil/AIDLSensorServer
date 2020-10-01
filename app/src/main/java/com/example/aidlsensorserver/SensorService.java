package com.example.aidlsensorserver;

import android.app.Service;
import android.content.Intent;

import android.os.IBinder;
import android.os.RemoteException;

public class SensorService extends Service  {
    private GetResult resultObj=new GetResult();

    public SensorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return resultObj;
    }


    private class GetResult extends SensorAIDLInterface.Stub
    {
        @Override
        public String getResult() throws RemoteException {
            SensorData sd=SensorData.getInstance();
            return sd.getResult();

        }
    }
}
