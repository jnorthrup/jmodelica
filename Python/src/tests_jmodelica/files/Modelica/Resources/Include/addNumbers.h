#ifndef ADDNUMBERS_H
#define ADDNUMBERS_H

#if defined _WIN32
    #define DllExport __declspec(dllexport)
#else
    #define DllExport
#endif

DllExport double add(double a, double b);
DllExport void add_output(double a, double b, double *c);
void multiplyAnArray(int* inputs, int* outputs, int size, int m);

#endif
