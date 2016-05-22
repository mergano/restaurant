package com.kiyoshi.core;

import java.lang.ref.WeakReference;

public class ClearGC {

    public static void ClearGarbageCollection() {
        Object obj = new Object();
        WeakReference ref = new WeakReference<>(obj);
        obj = null;
        while (ref.get() != null) {
            System.gc();
        }
    }
}
