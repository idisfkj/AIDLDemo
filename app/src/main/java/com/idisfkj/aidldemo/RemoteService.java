package com.idisfkj.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;

public class RemoteService extends Service {
    public RemoteService() {
    }

    IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public HelloMessage sayHello() throws RemoteException {
            return new HelloMessage("当前线程:" + Thread.currentThread().toString() + "\n"
                    + "当前线程id:" + Thread.currentThread().getId() + "\n"
                    + "主线程id:" + getMainLooper().getThread().getId(), Process.myPid());
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
