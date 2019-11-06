#ifndef ADDNUMBERS_H
#define ADDNUMBERS_H

#if defined _WIN32
    #define DllExport __declspec(dllexport)
#else
    #define DllExport
#endif

DllExport double add(double a, double b);
DllExport void add_output(double a, double b, double *c);
DllExport double multiple_add(double a, double b, double c, double d, double e, double f, double g, double h, double i);
void multiplyAnArray(int* inputs, int* outputs, int size, int m);

#endif
