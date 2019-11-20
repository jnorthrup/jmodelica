#ifndef EVALUATORTESTS_H
#define EVALUATORTESTS_H

#if defined _WIN32
    #define DllExport __declspec(dllexport)
#else
    #define DllExport
#endif

/* Record definitions */
typedef struct R_ddddddddddd_ R_ddddddddddd;
struct R_ddddddddddd_ {
    double member_0;
    double member_1;
    double member_2;
    double member_3;
    double member_4;
    double member_5;
    double member_6;
    double member_7;
    double member_8;
    double member_9;
    double member_10;
};

DllExport double f_d_i(int);
DllExport double f_d_idd(int, double, double);
DllExport int f_i_ii(int, int);
DllExport void f___iddpR_ddddddddddd_(int, double, double, R_ddddddddddd*);

#endif
