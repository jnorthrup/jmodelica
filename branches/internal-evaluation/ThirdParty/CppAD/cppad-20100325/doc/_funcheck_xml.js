var list_across0 = [
'_contents_xml.htm',
'_reference.xml',
'_index.xml',
'_search_xml.htm',
'_external.xml'
];
var list_up0 = [
'cppad.xml',
'adfun.xml',
'funcheck.xml'
];
var list_down2 = [
'install.xml',
'introduction.xml',
'ad.xml',
'adfun.xml',
'library.xml',
'example.xml',
'configure.xml',
'appendix.xml'
];
var list_down1 = [
'independent.xml',
'funconstruct.xml',
'dependent.xml',
'abort_recording.xml',
'seq_property.xml',
'funeval.xml',
'drivers.xml',
'funcheck.xml',
'omp_max_thread.xml',
'optimize.xml',
'fundeprecated.xml'
];
var list_down0 = [
'funcheck.cpp.xml'
];
var list_current0 = [
'funcheck.xml#Syntax',
'funcheck.xml#Purpose',
'funcheck.xml#f',
'funcheck.xml#g',
'funcheck.xml#g.x',
'funcheck.xml#y',
'funcheck.xml#x',
'funcheck.xml#r',
'funcheck.xml#a',
'funcheck.xml#ok',
'funcheck.xml#Vector',
'funcheck.xml#FunCheck Uses Forward',
'funcheck.xml#Discussion',
'funcheck.xml#Example'
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
