#include <iostream>
#include <stdexcept>
#include <jni.h>

#include "initjcc.h"
#include "jccutils.h"

using namespace java::lang;

const char* describeAndClearJavaException(JavaError e) {
    jthrowable ex = vm_env->ExceptionOccurred();
    if (ex == NULL) {
        return "unknown Java exception (already cleared?)";
    }
    vm_env->ExceptionClear();
    jclass swClass = vm_env->FindClass("java/io/StringWriter");
    jmethodID swConstructor = vm_env->GetMethodID(swClass, "<init>", "()V");
    jobject sw = vm_env->NewObject(swClass, swConstructor);
    jclass pwClass = vm_env->FindClass("java/io/PrintWriter");
    jmethodID pwConstructor = vm_env->GetMethodID(pwClass, "<init>", "(Ljava/io/Writer;)V");
    jobject pw = vm_env->NewObject(pwClass, pwConstructor, sw);
	jclass exClass = vm_env->GetObjectClass(ex);
	jmethodID printStackTrace = vm_env->GetMethodID(exClass, "printStackTrace", "(Ljava/io/PrintWriter;)V");
	vm_env->CallObjectMethod(ex, printStackTrace, pw);
	jmethodID toString = vm_env->GetMethodID(swClass, "toString", "()Ljava/lang/String;");
	jstring message = (jstring) vm_env->CallObjectMethod(sw, toString);
	const char *mstr = vm_env->GetStringUTFChars(message, NULL);
    // Keep the string so that we can print it in the exception handler.
    // This would be a memory leak but the JVM will be shut down soon anyway.
    //vm_env->ReleaseStringUTFChars(message, mstr);
    vm_env->DeleteLocalRef(pw);
    vm_env->DeleteLocalRef(pwClass);
    vm_env->DeleteLocalRef(sw);
    vm_env->DeleteLocalRef(swClass);
    vm_env->DeleteLocalRef(message);
    vm_env->DeleteLocalRef(exClass);
    vm_env->DeleteLocalRef(ex);
    return mstr;
}

void rethrowJavaException(JavaError e) {
    throw std::runtime_error(describeAndClearJavaException(e));
}

jstring fromUTF(const char *bytes) {
    return vm_env->NewStringUTF(bytes);
}
String StringFromUTF(const char *bytes) {
    return String(fromUTF(bytes));
}

JArray<String> new_JArray(const char *items[], int n) {
    String *itemsS = new String[n];
    for (int k=0; k < n; k++) itemsS[k] = StringFromUTF(items[k]);
    JArray<String> result = new_JArray<String>(itemsS, n);
    delete[] itemsS;
    return result;
}
