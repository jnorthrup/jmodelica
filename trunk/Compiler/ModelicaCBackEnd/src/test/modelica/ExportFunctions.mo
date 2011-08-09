/*
    Copyright (C) 2011 Modelon AB

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

package ExportFunctions

model Scalar2To1
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.CCodeGenTestCase(
         name="Scalar2To1",
         description="",
         template="
$C_export_functions$
$C_export_wrappers$
",
         generatedCode="
DllExport double func_ExportFunctions_Scalar2To1_f_export(double x_v, int y_v) {
    double z_v;
    func_ExportFunctions_Scalar2To1_f_def(x_v, y_v, &z_v);
    return z_v;
}


char* select_1_names[] = { \"ExportFunctions_Scalar2To1_f\" };
int select_1_lengths[] = { 28 };
double (*select_1_funcs[])(double, int) = { *func_ExportFunctions_Scalar2To1_f_export };
DllExport double __stdcall select_1(char* name, double x_v, int y_v) {
    int i, j;
    for (i = 0, j = 0; name[i] != 0; i++) 
        while (j < 1 && i <= select_1_lengths[j] && name[i] > select_1_names[j][i]) j++;
    if (j >= 1 || strcmp(select_1_names[j], name)) return 0;
    return select_1_funcs[j](x_v, y_v);
}

")})));

  function f
    input Real x;
    input Integer y;
    output Real z;
  algorithm
    z := x + y;
  end f;
  
algorithm
  f(1.0, 2);
end Scalar2To1;


model ScalarGrouping1
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.CCodeGenTestCase(
         name="ScalarGrouping1",
         description="",
         template="
$C_export_functions$
$C_export_wrappers$
",
         generatedCode="
DllExport double func_ExportFunctions_ScalarGrouping1_fa2_export(double y_v) {
    double w_v;
    func_ExportFunctions_ScalarGrouping1_fa2_def(y_v, &w_v);
    return w_v;
}

DllExport double func_ExportFunctions_ScalarGrouping1_fa1_export(double x_v) {
    double z_v;
    func_ExportFunctions_ScalarGrouping1_fa1_def(x_v, &z_v);
    return z_v;
}

DllExport double func_ExportFunctions_ScalarGrouping1_fb1_export(double x1_v, double x2_v) {
    double y_v;
    func_ExportFunctions_ScalarGrouping1_fb1_def(x1_v, x2_v, &y_v);
    return y_v;
}

DllExport double func_ExportFunctions_ScalarGrouping1_fb2_export(double x_v, double y_v) {
    double z_v;
    func_ExportFunctions_ScalarGrouping1_fb2_def(x_v, y_v, &z_v);
    return z_v;
}


char* select_1_names[] = { \"ExportFunctions_ScalarGrouping1_fa1\", \"ExportFunctions_ScalarGrouping1_fa2\" };
int select_1_lengths[] = { 35, 35 };
double (*select_1_funcs[])(double) = { *func_ExportFunctions_ScalarGrouping1_fa1_export, *func_ExportFunctions_ScalarGrouping1_fa2_export };
DllExport double __stdcall select_1(char* name, double x_v) {
    int i, j;
    for (i = 0, j = 0; name[i] != 0; i++) 
        while (j < 2 && i <= select_1_lengths[j] && name[i] > select_1_names[j][i]) j++;
    if (j >= 2 || strcmp(select_1_names[j], name)) return 0;
    return select_1_funcs[j](x_v);
}

char* select_2_names[] = { \"ExportFunctions_ScalarGrouping1_fb1\", \"ExportFunctions_ScalarGrouping1_fb2\" };
int select_2_lengths[] = { 35, 35 };
double (*select_2_funcs[])(double, double) = { *func_ExportFunctions_ScalarGrouping1_fb1_export, *func_ExportFunctions_ScalarGrouping1_fb2_export };
DllExport double __stdcall select_2(char* name, double x1_v, double x2_v) {
    int i, j;
    for (i = 0, j = 0; name[i] != 0; i++) 
        while (j < 2 && i <= select_2_lengths[j] && name[i] > select_2_names[j][i]) j++;
    if (j >= 2 || strcmp(select_2_names[j], name)) return 0;
    return select_2_funcs[j](x1_v, x2_v);
}

")})));

  function fa1
    input Real x;
    output Real z = x;
  algorithm
  end fa1;
  
  function fa2
    input Real y;
    output Real w = -y;
  algorithm
  end fa2;
  
  function fb2
    input Real x;
    input Real y;
    output Real z = x + y;
  algorithm
  end fb2;
  
  function fb1
    input Real x1;
    input Real x2;
    output Real y = x1 - x2;
  algorithm
  end fb1;
  
algorithm
  fa2(0);
  fa1(0);
  fb1(0, 0);
  fb2(0, 0);
end ScalarGrouping1;


model ArrayInputs1
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.CCodeGenTestCase(
         name="ArrayInputs1",
         description="",
         template="
$C_export_functions$
$C_export_wrappers$
",
         generatedCode="
DllExport double func_ExportFunctions_ArrayInputs1_f2_export(double* y_ap, int y_a0) {
    double w_v;
    int y_a_size[1];
    jmi_array_t y_a_obj;
    jmi_array_t* y_a = &y_a_obj;
    y_a_obj.var = y_ap;
    y_a_obj.size = y_a_size;
    y_a_obj.num_elems = 1 * y_a0;
    y_a_size[0] = y_a0;
    func_ExportFunctions_ArrayInputs1_f2_def(y_a, &w_v);
    return w_v;
}

DllExport double func_ExportFunctions_ArrayInputs1_f1_export(double* x_ap, int x_a0) {
    double z_v;
    int x_a_size[1];
    jmi_array_t x_a_obj;
    jmi_array_t* x_a = &x_a_obj;
    x_a_obj.var = x_ap;
    x_a_obj.size = x_a_size;
    x_a_obj.num_elems = 1 * x_a0;
    x_a_size[0] = x_a0;
    func_ExportFunctions_ArrayInputs1_f1_def(x_a, &z_v);
    return z_v;
}


char* select_1_names[] = { \"ExportFunctions_ArrayInputs1_f1\", \"ExportFunctions_ArrayInputs1_f2\" };
int select_1_lengths[] = { 31, 31 };
double (*select_1_funcs[])(double*, int) = { *func_ExportFunctions_ArrayInputs1_f1_export, *func_ExportFunctions_ArrayInputs1_f2_export };
DllExport double __stdcall select_1(char* name, double* x_ap, int x_a0) {
    int i, j;
    for (i = 0, j = 0; name[i] != 0; i++) 
        while (j < 2 && i <= select_1_lengths[j] && name[i] > select_1_names[j][i]) j++;
    if (j >= 2 || strcmp(select_1_names[j], name)) return 0;
    return select_1_funcs[j](x_ap, x_a0);
}

")})));

  function f1
    input Real x[:];
    output Real z = 0;
  algorithm
  end f1;
  
  function f2
    input Real y[:];
    output Real w = 0;
  algorithm
  end f2;

algorithm
  f2({0});
  f1({0});
end ArrayInputs1;


model ArrayInputs2
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.CCodeGenTestCase(
         name="ArrayInputs2",
         description="",
         template="
$C_export_functions$
$C_export_wrappers$
",
         generatedCode="
DllExport double func_ExportFunctions_ArrayInputs2_f2_export(double* y_ap, int y_a0, int y_a1) {
    double w_v;
    int y_a_size[2];
    jmi_array_t y_a_obj;
    jmi_array_t* y_a = &y_a_obj;
    y_a_obj.var = y_ap;
    y_a_obj.size = y_a_size;
    y_a_obj.num_elems = 1 * y_a0 * y_a1;
    y_a_size[0] = y_a0;
    y_a_size[1] = y_a1;
    func_ExportFunctions_ArrayInputs2_f2_def(y_a, &w_v);
    return w_v;
}

DllExport double func_ExportFunctions_ArrayInputs2_f1_export(double* x_ap, int x_a0, int x_a1) {
    double z_v;
    int x_a_size[2];
    jmi_array_t x_a_obj;
    jmi_array_t* x_a = &x_a_obj;
    x_a_obj.var = x_ap;
    x_a_obj.size = x_a_size;
    x_a_obj.num_elems = 1 * x_a0 * x_a1;
    x_a_size[0] = x_a0;
    x_a_size[1] = x_a1;
    func_ExportFunctions_ArrayInputs2_f1_def(x_a, &z_v);
    return z_v;
}


char* select_1_names[] = { \"ExportFunctions_ArrayInputs2_f1\", \"ExportFunctions_ArrayInputs2_f2\" };
int select_1_lengths[] = { 31, 31 };
double (*select_1_funcs[])(double*, int, int) = { *func_ExportFunctions_ArrayInputs2_f1_export, *func_ExportFunctions_ArrayInputs2_f2_export };
DllExport double __stdcall select_1(char* name, double* x_ap, int x_a0, int x_a1) {
    int i, j;
    for (i = 0, j = 0; name[i] != 0; i++) 
        while (j < 2 && i <= select_1_lengths[j] && name[i] > select_1_names[j][i]) j++;
    if (j >= 2 || strcmp(select_1_names[j], name)) return 0;
    return select_1_funcs[j](x_ap, x_a0, x_a1);
}

")})));

  function f1
    input Real x[:,:];
    output Real z = 0;
  algorithm
  end f1;
  
  function f2
    input Real y[:,:];
    output Real w = 0;
  algorithm
  end f2;

algorithm
  f2({{0}});
  f1({{0}});
end ArrayInputs2;


model OnlyUnsupported
 annotation(JModelica(unitTesting = JModelica.UnitTesting(testCase={
     JModelica.UnitTesting.CCodeGenTestCase(
         name="OnlyUnsupported",
         description="Test that unsupported functions aren't included when exporting functions",
         template="
$C_export_functions$
$C_export_wrappers$
",
         generatedCode="")})));

  function f1
    input Real x;
    output Real[2] y = { 1, 2 };
  algorithm
  end f1;
  
  function f2
    input Real x;
    output Real y = 1;
    output Real z = 2;
  algorithm
  end f2;
  
  function f3
    input Real x;
    output Boolean y = true;
  algorithm
  end f3;
  
algorithm
  f1(1);
  f2(1);
  f3(1);
end OnlyUnsupported;

end ExportFunctions;
