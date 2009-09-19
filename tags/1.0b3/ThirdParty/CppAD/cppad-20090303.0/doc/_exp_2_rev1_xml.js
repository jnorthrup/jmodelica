var list_across0 = [
'_contents_xml.htm',
'_reference.xml',
'_index.xml',
'_search_xml.htm',
'_external.xml'
];
var list_up0 = [
'cppad.xml',
'introduction.xml',
'exp_2.xml',
'exp_2_rev1.xml'
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
'get_started.cpp.xml',
'exp_2.xml',
'exp_eps.xml',
'exp_apx_main.cpp.xml'
];
var list_down1 = [
'exp_2.hpp.xml',
'exp_2.cpp.xml',
'exp_2_for0.xml',
'exp_2_for1.xml',
'exp_2_rev1.xml',
'exp_2_for2.xml',
'exp_2_rev2.xml',
'exp_2_cppad.xml'
];
var list_down0 = [
'exp_2_rev1.cpp.xml'
];
var list_current0 = [
'exp_2_rev1.xml#Purpose',
'exp_2_rev1.xml#Mathematical Form',
'exp_2_rev1.xml#f_5',
'exp_2_rev1.xml#Index 5: f_4',
'exp_2_rev1.xml#Index 4: f_3',
'exp_2_rev1.xml#Index 3: f_2',
'exp_2_rev1.xml#Index 2: f_1',
'exp_2_rev1.xml#Verification',
'exp_2_rev1.xml#Exercises'
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
