package com.idisfkj.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by idisfkj on 16/9/25.
 * Email : idisfkj@qq.com.
 */
public class HelloMessage implements Parcelable{
    private String message;
    private int pId;

    public HelloMessage(String message, int pId) {
        this.message = message;
        this.pId = pId;
    }

    protected HelloMessage(Parcel in) {
        message = in.readString();
        pId = in.readInt();
    }

    public static final Creator<HelloMessage> CREATOR = new Creator<HelloMessage>() {
        @Override
        public HelloMessage createFromParcel(Parcel in) {
            return new HelloMessage(in);
        }

        @Override
        public HelloMessage[] newArray(int size) {
            return new HelloMessage[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeInt(pId);
    }
}
