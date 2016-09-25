// IRemoteService.aidl
package com.idisfkj.aidldemo;

// Declare any non-default types here with import statements
import com.idisfkj.aidldemo.HelloMessage;
interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    HelloMessage sayHello();

}
