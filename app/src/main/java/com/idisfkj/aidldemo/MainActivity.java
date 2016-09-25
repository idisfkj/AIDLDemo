package com.idisfkj.aidldemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mPidText;
    private IRemoteService iRemoteService;
    private boolean mBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPidText = (TextView) findViewById(R.id.pid_text);
        mPidText.setText("本地id:" + Process.myPid());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainActivity.this, RemoteService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
        mBind = false;
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iRemoteService = IRemoteService.Stub.asInterface(iBinder);
            mBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iRemoteService = null;
            mBind = false;
        }
    };

    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.show_pid_bt:
                if (mBind) {
                    try {
                        Log.v("TAG", "远程id:" + iRemoteService.sayHello().getpId());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.show_message_bt:
                if (mBind) {
                    try {
                        Log.v("TAG", "Message:" + iRemoteService.sayHello().getMessage());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
