#include <iostream>
#include <stdexcept>
#include <jni.h>

#include "initjcc.h"
#include "jccutils.h"

using namespace java::lang;

const char* describeAndClearJavaException(JavaError e) {
    std::cout << "Java error occurred: " << std::endl;
    vm_env->ExceptionDescribe();
    jboolean isCopy = false;
    jthrowable exception = vm_env->ExceptionOccurred();
    jmethodID toString = vm_env->GetMethodID(vm_env->FindClass("java/lang/Object"), "toString", "()Ljava/lang/String;");
    jstring s = (jstring) vm_env->CallObjectMethod(exception, toString);
    const char* utf = vm_env->GetStringUTFChars(s, &isCopy);
    vm_env->ExceptionClear();
    return utf;
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
