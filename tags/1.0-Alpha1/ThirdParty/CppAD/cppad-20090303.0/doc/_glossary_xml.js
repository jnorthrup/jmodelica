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
'glossary.xml'
];
var list_down2 = [
'install.xml',
'introduction.xml',
'ad.xml',
'adfun.xml',
'library.xml',
'preprocessor.xml',
'example.xml',
'appendix.xml'
];
var list_down1 = [
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
var list_current0 = [
'glossary.xml#AD Function',
'glossary.xml#AD of Base',
'glossary.xml#AD Levels Above Base',
'glossary.xml#Base Function',
'glossary.xml#Base Type',
'glossary.xml#Elementary Vector',
'glossary.xml#Operation',
'glossary.xml#Operation.Atomic',
'glossary.xml#Operation.Sequence',
'glossary.xml#Operation.Dependent',
'glossary.xml#Operation.Independent',
'glossary.xml#Parameter',
'glossary.xml#Sparsity Pattern',
'glossary.xml#Tape',
'glossary.xml#Tape.Active',
'glossary.xml#Tape.Inactive',
'glossary.xml#Tape.Independent Variable',
'glossary.xml#Tape.Dependent Variables',
'glossary.xml#Taylor Coefficient',
'glossary.xml#Variable'
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
