var list_across0 = [
'_contents_xml.htm',
'_reference.xml',
'_index.xml',
'_search_xml.htm',
'_external.xml'
];
var list_up0 = [
'cppad.xml',
'example.xml',
'general.xml',
'ode_taylor_adolc.cpp.xml'
];
var list_down3 = [
'install.xml',
'introduction.xml',
'ad.xml',
'adfun.xml',
'library.xml',
'preprocessor.xml',
'example.xml',
'appendix.xml'
];
var list_down2 = [
'general.xml',
'exampleutility.xml',
'listallexamples.xml',
'test_vector.xml'
];
var list_down1 = [
'ipopt_cppad_nlp.xml',
'interface2c.cpp.xml',
'jacminordet.cpp.xml',
'jacludet.cpp.xml',
'hesminordet.cpp.xml',
'hesludet.cpp.xml',
'odestiff.cpp.xml',
'ode_taylor.cpp.xml',
'ode_taylor_adolc.cpp.xml',
'stackmachine.cpp.xml',
'mul_level.xml'
];
var list_current0 = [
'ode_taylor_adolc.cpp.xml#Purpose',
'ode_taylor_adolc.cpp.xml#ODE',
'ode_taylor_adolc.cpp.xml#ODE Solution',
'ode_taylor_adolc.cpp.xml#Derivative of ODE Solution',
'ode_taylor_adolc.cpp.xml#Taylor\'s Method Using AD',
'ode_taylor_adolc.cpp.xml#base_adolc.hpp',
'ode_taylor_adolc.cpp.xml#Tracking New and Delete',
'ode_taylor_adolc.cpp.xml#Configuration Requirement'
];
function choose_across0(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_across0[index-1];
}
function choose_up0(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_up0[index-1];
}
function choose_down3(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_down3[index-1];
}
function choose_down2(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_down2[index-1];
}
function choose_down1(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_down1[index-1];
}
function choose_down0(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_down0[index-1];
}
function choose_current0(item)
{	var index          = item.selectedIndex;
	item.selectedIndex = 0;
	if(index > 0)
		document.location = list_current0[index-1];
}
