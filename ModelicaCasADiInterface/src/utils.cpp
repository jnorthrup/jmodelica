/*
Copyright (C) 2018 Modelon AB

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, version 3 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

//JNI
#include "jni.h"
#include "jccutils.h"

#include "java/util/Collection.h"
#include "java/util/Iterator.h"
#include "java/lang/String.h"
#include <string>
#include "JCCEnv.h"

#include "Utils.hpp"

char *jobjectoToString(jobject obj)
{
    try {
        if (obj) {
            JNIEnv *vm_env = env->get_vm_env();
            jclass obj_ = (jclass) vm_env->NewGlobalRef(vm_env->FindClass("java/lang/Object"));
            jstring str = (jstring) vm_env->CallObjectMethod(obj, vm_env->GetMethodID(obj_, "toString", "()Ljava/lang/String;"));
            int len = vm_env->GetStringUTFLength(str);
            char *bytes = new char[len + 1];
            jboolean isCopy = 0;
            const char *utf = vm_env->GetStringUTFChars(str, &isCopy);

            if (!bytes)
                return NULL;

            memcpy(bytes, utf, len);
            bytes[len] = '\0';

            vm_env->ReleaseStringUTFChars(str, utf);
            vm_env->DeleteLocalRef(obj);
            
            return bytes; 
        } else {
            return NULL;
        }
    } catch (int exception) {
        switch (exception) {
            case _EXC_PYTHON:
                return NULL;
            case _EXC_JAVA: {
                JNIEnv *vm_env = env->get_vm_env();

                vm_env->ExceptionDescribe();
                vm_env->ExceptionClear();

                return NULL;
            }
            default:
                throw;
        }
    }
}
