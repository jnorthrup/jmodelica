var list_across0 = [
'_contents_xml.htm',
'_reference.xml',
'_index.xml',
'_search_xml.htm',
'_external.xml'
];
var list_up0 = [
'cppad.xml',
'appendix.xml',
'theory.xml',
'reversetheory.xml'
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
'faq.xml',
'speed.xml',
'theory.xml',
'glossary.xml',
'bib.xml',
'bugs.xml',
'wishlist.xml',
'whats_new.xml',
'include_deprecated.xml',
'license.xml'
];
var list_down1 = [
'forwardtheory.xml',
'reversetheory.xml',
'reverse_identity.xml'
];
var list_down0 = [
'expreverse.xml',
'logreverse.xml',
'sqrtreverse.xml',
'sincosreverse.xml',
'atanreverse.xml',
'asinreverse.xml',
'acosreverse.xml'
];
var list_current0 = [
'reversetheory.xml#Taylor Notation',
'reversetheory.xml#Binary Operators',
'reversetheory.xml#Binary Operators.Addition',
'reversetheory.xml#Binary Operators.Subtraction',
'reversetheory.xml#Binary Operators.Multiplication',
'reversetheory.xml#Binary Operators.Division',
'reversetheory.xml#Standard Math Functions'
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
