 /*
    Copyright (C) 2015 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License version 3 as published
    by the Free Software Foundation, or optionally, under the terms of the
    Common Public License version 1.0 as published by IBM.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License, or the Common Public License, for more details.

    You should have received copies of the GNU General Public License
    and the Common Public License along with this program.  If not,
    see <http://www.gnu.org/licenses/> or
    <http://www.ibm.com/developerworks/library/os-cpl.html/> respectively.
*/

#ifndef _JMI_DYN_MEM_H
#define _JMI_DYN_MEM_H

/* Linked list for saving pointers to be freed at return */
typedef struct _jmi_dynamic_list jmi_dynamic_list;
struct _jmi_dynamic_list {
    void* data;
    jmi_dynamic_list* next;
};

/**
 * Free list nodes following <code>head</code> and their data.
 */
void jmi_dynamic_list_free(jmi_dynamic_list* head);

/* Keeps pointers to the head and last elements of a list.
 * Might be tail in a longer list. */
typedef struct jmi_dynamic_mem_t {
    jmi_dynamic_list* head;
    jmi_dynamic_list** last;
} jmi_dynamic_mem_t;

/**
 * Find the end of the memory list
 */
jmi_dynamic_list** jmi_dynamic_mem_last();

void jmi_dynamic_mem_add(jmi_dynamic_mem_t* mem, void* data);

void jmi_dynamic_mem_free(jmi_dynamic_mem_t* mem);

/* Macro for declaring dynamic list variable - should be called at beginning of function */
#define JMI_DYNAMIC_INIT() \
    jmi_dynamic_mem_t dynamic_mem = {NULL, NULL};

/* Macro for adding a pointer to dynamic list - used from generated code */
#define JMI_DYNAMIC_ADD(pointer) \
    JMI_DYNAMIC_ADD_POINTER(pointer)

void jmi_dynamic_add_pointer(jmi_dynamic_mem_t* mem, void* data);

/* Macro for adding a pointer to dynamic list - only for use in other macros */
#define JMI_DYNAMIC_ADD_POINTER(pointer) \
    do {\
        if (!dynamic_mem.head) {\
            dynamic_mem.last = jmi_dynamic_mem_last();\
            dynamic_mem.head = *dynamic_mem.last;\
        }\
        jmi_dynamic_add_pointer(&dynamic_mem, pointer);\
    } while (0);

/* Dynamic deallocation of all dynamically allocated arrays and record arrays - should be called before return */
#define JMI_DYNAMIC_FREE() \
    if (dynamic_mem.head) jmi_dynamic_mem_free(&dynamic_mem);


#endif /* _JMI_DYN_MEM_H */
