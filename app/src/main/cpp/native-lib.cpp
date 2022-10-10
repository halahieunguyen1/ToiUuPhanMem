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


long Fibonacci(long begin, long end, int loop)
{
    long fib = 0, a;
    for (int t = 1; t < loop; t++) {
        if (begin < 0 || end < 0) {
            return (long)0;
        }
        if (end < begin) {
            long k = end;
            end = begin;
            begin = k;
        }
        long a1 = 1, a2 = 1;
        if (end == 1) {
            if (begin == 0) return (long)1;
            return (long)0;
        }
        long i = 2;
        a = 1;
        if (begin == 1) a=1;
        if (begin == 2) a=2;
        if (begin == 0) a=0;
        while (i < begin)
        {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
            i++;
        }
        fib = a;
        i++;
        while (i <= end)
        {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
            i++;
        }
    }
    return a - fib;
}
extern "C"
JNIEXPORT jlong  JNICALL
Java_com_example_toiuuphammem2_AbstractNDKActivity_totalFibo(JNIEnv *env, jobject obj, jlong a,
                                                           jlong b, jint loop) {
    return (*Fibonacci)(a, b, loop);
}


extern "C"
JNIEXPORT jdouble JNICALL
Java_com_example_toiuuphammem2_AbstractNDKActivity_CircleArea(JNIEnv *env,jclass clazz,jfloat n) {
    return 3.14159*n*n;
}