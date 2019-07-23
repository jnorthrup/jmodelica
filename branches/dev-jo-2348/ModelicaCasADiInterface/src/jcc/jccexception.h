#ifndef __jccexception_h
#define __jccexception_h

#include <string>

typedef int JavaError; // Hopefully JCC will use a better type some day

std::string describeAndClearJavaException(JavaError e);
void rethrowJavaException(JavaError e);

#endif
