#include "addNumbers.h"

double add(double a, double b)
{
  return a + b;
}

void add_output(double a, double b, double *c)
{
  *c = a + b;
}

void multiplyAnArray(int* inputs, int* outputs, int size, int m)
{
  int i;
  for (i = 0; i < size; i++) {
      outputs[i] = inputs[i] * m;
  }

}
