#include "addNumbers.h"

DllExport double add(double a, double b)
{
  return a + b;
}

DllExport void add_output(double a, double b, double *c)
{
  *c = a + b;
}

DllExport double multiple_add(double a, double b, double c, double d, double e, double f, double g, double h, double i)
{
  return a+b+c+d+e+f+g+h+i;
}

void multiplyAnArray(int* inputs, int* outputs, int size, int m)
{
  int i;
  for (i = 0; i < size; i++) {
      outputs[i] = inputs[i] * m;
  }

}
