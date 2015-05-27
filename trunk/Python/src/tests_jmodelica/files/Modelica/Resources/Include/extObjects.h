#ifndef _EXT_OBJECTS_H_
#define _EXT_OBJECTS_H_

void* constructor_string(const char* str);

double constant_extobj_func(void* o);

void destructor_string_create_file(void* o);

typedef struct {
    double x;
    const char* s;
} Obj1_t;
void* my_constructor1(double x, int y, int b, const char* s);
void my_destructor1(void* o1);
double use1(void* o1);

typedef struct {
    double* x;
    int* y;
    int* b;
    const char** s;
} Obj2_t;
void my_constructor2(double* x, int* y, void** o2, int* b, const char** s);
void my_destructor2(void* o2);
double use2(void* o2);

typedef struct {
    Obj1_t* o1;
    Obj2_t** o2;
} Obj3_t;
void my_constructor3(void* o1, void** o2, void** o3);
void my_destructor2(void* o3);
double use3(void* o3);

typedef struct inc_int {
    int x;
} inc_int_t;

void* inc_int_con(int x);
void inc_int_decon(void* o1);
int inc_int_use(void* o1);

void* crash_con(int x);
void crash_decon(void* o1);
int crash_use(void* o1);

void* error_con(int x);
void error_decon(void* o1);
int error_use(void* o1);

#endif
