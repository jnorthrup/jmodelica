/*
   This interface describes a DAE on the form

     F(ci,cd,pi,pd,dx,x,u,w,t) = 0

   were

     ci   independent constant
     cd   dependent constants
     pi   independent parameters
     pd   dependent parameters

     dx    differentiated variables
     x     variables whos derivatives appear in the DAE
     u     inputs
     w     algebraic variables
     t     time

*/


#ifndef _JMI_DAE_H
#define _JMI_DAE_H

#include "jmi.h"

#if defined __cplusplus
        extern "C" {
#endif

/**
 * Return sizes of model vectors.
 */
int jmi_dae_get_sizes(int* n_ci, int* n_cd, int* n_pi, int* n_pd,
                  int* n_dx, int* n_x, int* n_u, int* n_w, int* n_eq);

/**
 * Evaluation of DAE residual.
 */
int jmi_dae_F(Double_t* ci, Double_t* cd, Double_t* pi, Double_t* pd,
          Double_t* dx, Double_t* x, Double_t* u, Double_t* w,
          Double_t t, Double_t* res);

/*
DAE_der_struct  jmi_dae_init(int der_type);

int jmi_dae_dF(DAE_der_struct data, Double_t* ci, Double_t* cd, Double_t* pi, Double_t* pd,
              Double_t* dx, Double_t* x, Double_t* u,
     	      Double_t* w, Double_t t, int mask, Double_t* jac) {

	if (data->der_type == AD) {
		jmi_dae_sd_dF(DAE_der_struct data, Double_t* ci, Double_t* cd, Double_t* pi, Double_t* pd,
	              Double_t* dx, Double_t* x, Double_t* u,
	     	      Double_t* w, Double_t t, int mask, Double_t* jac);

	}


}

int jmi_dae_der_query(int* der_availability_mask);
*/

#if defined __cplusplus
    }
#endif


#endif
