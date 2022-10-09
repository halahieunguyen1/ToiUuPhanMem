#include <stdio.h>
#include <math.h>
#include "jni.h"
#include <stdio.h>
#include "stdlib.h"
#include "string.h"
#include<time.h>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_toiuuphammem2_MainActivity_congSoNguyen(JNIEnv *env, jobject thiz, int a, int b) {
    return 123;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_toiuuphammem2_MainActivity_getFullname(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("ABC");
}

extern "C"
JNIEXPORT jobject  JNICALL
Java_com_example_toiuuphammem2_ResultAndTime_congSoNguyen(JNIEnv *env, jobject obj, jint a,
                                                             jint b) {
    jclass objectClass = (env)->FindClass("com/example/toiuuphammem2/ResultAndTime");
    jfieldID result = (env)->GetFieldID(objectClass,"result","I");
    jfieldID time = (env)->GetFieldID(objectClass,"time","I");
    int rtn;
    struct timespec res, res1;
    int c= (int) a;
    int d = (int) b;
    clock_getres( CLOCK_REALTIME, &res);
    clock_getres( CLOCK_REALTIME, &res1);
    (env)->SetIntField(obj, result, rtn);
    (env)->SetIntField(obj, time,res1.tv_nsec - res.tv_nsec);

    return obj;
}
