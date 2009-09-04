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
'funeval.xml',
'reverse.xml',
'reverse_any.xml'
];
var list_down3 = [
'independent.xml',
'funconstruct.xml',
'dependent.xml',
'abort_recording.xml',
'seqproperty.xml',
'funeval.xml',
'drivers.xml',
'funcheck.xml',
'omp_max_thread.xml',
'fundeprecated.xml'
];
var list_down2 = [
'forward.xml',
'reverse.xml',
'sparse.xml'
];
var list_down1 = [
'reverse_one.xml',
'reverse_two.xml',
'reverse_any.xml'
];
var list_down0 = [
'reverse_any.cpp.xml'
];
var list_current0 = [
'reverse_any.xml#Syntax',
'reverse_any.xml#Purpose',
'reverse_any.xml#x^(k)',
'reverse_any.xml#X(t, u)',
'reverse_any.xml#W(t, u)',
'reverse_any.xml#f',
'reverse_any.xml#p',
'reverse_any.xml#w',
'reverse_any.xml#dw',
'reverse_any.xml#dw.First Order',
'reverse_any.xml#dw.Second Order',
'reverse_any.xml#Vector',
'reverse_any.xml#Example'
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
