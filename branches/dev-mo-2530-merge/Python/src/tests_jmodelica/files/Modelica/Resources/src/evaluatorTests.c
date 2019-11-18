#include "evaluatorTests.h"

DllExport double f_d_i(int a) {
    return 3.0*(double)a;
}

DllExport double f_d_idd(int a, double b, double c) {
    return b*c + 3.0*(double)a;
}

DllExport int f_i_ii(int a, int b) {
    return a + b;
}

DllExport void f___iddpR_ddddddddddd_(int a, double b, double c, R_ddddddddddd* d) {
    d->member_0 = (double)a;
    d->member_1 = b;
    d->member_2 = c;
    d->member_3 = 3.0;
    d->member_4 = 4.0;
    d->member_5 = 5.0;
    d->member_6 = 6.0;
    d->member_7 = 7.0;
    d->member_8 = 8.0;
    d->member_9 = 9.0;
    d->member_10 = 10.0;
}
